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
//@Controller
//public class EpisodeController {
//
//    private EpisodeService episodeService;
//
//    @Autowired
//    public EpisodeController(EpisodeService episodeService){
//        this.episodeService = episodeService;
//    }
//
//
////    @RequestMapping("/episode")
////    public String getEpisode(){
////        return "redirect:/index";
////    }
//
//    @RequestMapping("/episode/{id}")
//    public String getEpisodebyId(@PathVariable Long id, Model model){
//
//        model.addAttribute("episode", episodeService.read(id));
//
//        return "episode";
//    }
//}
//
////    public String getEpisode() {
////        return "redirect:/index";
////    }
////
////    @RequestMapping("/episode/{id}")
////    public String getEpisodeById(@PathVariable Long id, Model model) {
////
////        model.addAttribute("episode", episodeService.read(id));
////
////        return "episode";
////    }

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
//        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Episode create(@RequestBody Episode episode){
        return episodeService.create(episode);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Episode read(@PathVariable(value = "id") long id){
        Episode post = episodeService.read(id);
        return post;
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



