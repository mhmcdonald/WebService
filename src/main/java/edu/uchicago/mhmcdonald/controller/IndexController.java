package edu.uchicago.mhmcdonald.controller;

import edu.uchicago.mhmcdonald.domain.Episode;
import edu.uchicago.mhmcdonald.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by markmcdonald on 8/17/16.
 */

@RestController
@RequestMapping("/api")
public class IndexController {

    private EpisodeService episodeService;

    @Autowired
    public IndexController(EpisodeService episodeService){
        this.episodeService = episodeService;
    }

    @RequestMapping( value = "/", method = RequestMethod.GET )
    public Iterable<Episode> list(){
        return episodeService.list();
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String list(Model model){
//        model.addAttribute("episodes", episodeService.list());
//        return "episodelist";
////        return "index";
//    }
//im not sure how to do this using Gerber's format:

    @RequestMapping("episode/new")
    public String newEpisode(Model model){
        model.addAttribute("episode", new Episode());
        return "episodeform";
    }

//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public Episode create(@RequestBody Episode episode){
//        return episodeService.create(episode);
//    }

    @RequestMapping(value = "episode", method = RequestMethod.POST)
    public String saveEpisode(Episode episode){

        episodeService.saveEpisode(episode);

        return "redirect:/episode/" + episode.getId();
    }

//    @RequestMapping(value = "episode/{id}", method = RequestMethod.GET)
//    public Episode read(@PathVariable(value = "id") long id){
//        Episode post = episodeService.read(id);
//        return post;
//    }

    @RequestMapping("episode/{id}")
    public String showEpisode(@PathVariable Long id, Model model){
        model.addAttribute("episode", episodeService.getEpisodeById(id));
        return "episodedetail";
    }

    @RequestMapping("episode/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("episode", episodeService.getEpisodeById(id));
        return "episodeform";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Episode update(@PathVariable(value = "id") long id, @RequestBody Episode episode){
        Episode post = episodeService.update(id,episode);
        return post;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") long id){
        episodeService.delete(id);
    }

}



