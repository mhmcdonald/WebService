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

/**
 * Created by markmcdonald on 8/17/16.
 */

@Controller
public class EpisodeController {

    private EpisodeService episodeService;

    @Autowired
    public EpisodeController(EpisodeService episodeService){
        this.episodeService = episodeService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("episodes", episodeService.list());
        return "episodelist";
    }

    @RequestMapping("episode/new")
    public String newEpisode(Model model){
        model.addAttribute("episode", new Episode());
        return "episodeform";
    }


    @RequestMapping(value = "episode", method = RequestMethod.POST)
    public String saveEpisode(Episode episode){

        episodeService.saveEpisode(episode);

        return "redirect:/episode/" + episode.getId();
    }


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

    @RequestMapping(value= "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") long id){
        System.out.println(id);
        episodeService.delete(id);
        return "redirect:/";
    }


}



