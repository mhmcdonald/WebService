package edu.uchicago.mhmcdonald.controller;

/**
 * Created by markmcdonald on 8/20/16.
 */

import edu.uchicago.mhmcdonald.domain.Episode;
import edu.uchicago.mhmcdonald.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;


@RestController
@RequestMapping("/api")
public class ApiController{


    private EpisodeService episodeService;

    @Autowired
    public ApiController(EpisodeService episodeService){
        this.episodeService = episodeService;
    }

    //get all episodes in JSON; enter "http://localhost:8080/api/get/all"
    @RequestMapping(value="/get/all", method=RequestMethod.GET)
    public ArrayList<String> list(Model model){
        String jsonEpisode = new String();
        ArrayList<String> episodeList = new ArrayList<String>();
        Iterable<Episode> iterable;
        iterable = episodeService.list();
        for(Episode episode : iterable){
            jsonEpisode = episode.toString();
            episodeList.add(jsonEpisode);
        }
        return episodeList;
    }

    //get single episode in JSON; enter "http://localhost:8080/api/get/episode/#"
    @RequestMapping(value="/get/episode/{id}", method=RequestMethod.GET)
    public String find(@PathVariable Long id, Model model ){
        String jsonEpisode = new String();
        ArrayList<String> episodeList = new ArrayList<String>();
        Episode episode = new Episode();
        episode = episodeService.getEpisodeById(id);
        jsonEpisode = episode.toString();
        return jsonEpisode;
    }

    //delete a single episode. This will return you to the episode list home page, where the episode is now gone.
    //enter "http://localhost:8080/api/#/delete
    @RequestMapping("/{id}/delete")
    public String delete(@PathVariable(value="id") Long id){
        episodeService.delete(id);
        return "Confirmation: Episode has been deleted.";
    }

}