package edu.uchicago.mhmcdonald.controller;

/**
 * Created by markmcdonald on 8/20/16.
 */

import edu.uchicago.mhmcdonald.domain.Episode;
import edu.uchicago.mhmcdonald.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import edu.uchicago.mhmcdonald.exception.ResourceNotFoundException;


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
    public ResponseEntity<ArrayList<Episode>> list(Model model){
        ArrayList<Episode> episodeList = new ArrayList<Episode>();
        Iterable<Episode> iterable;
        if(episodeService.list() == null){
            throw new ResourceNotFoundException("There were no episodes found. Please contact the API administrator.");
        }
        iterable = episodeService.list();
        for(Episode episode : iterable){
            episodeList.add(episode);
        }
        return new ResponseEntity<ArrayList<Episode>>(episodeList, HttpStatus.OK);
    }

    //get single episode in JSON; enter "http://localhost:8080/api/get/episode/#"
    @RequestMapping(value="/get/episode/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Episode> find(@PathVariable Long id, Model model ){
        Episode episode = new Episode();
        episode = episodeService.getEpisodeById(id);
        if (episode == null) {
            System.out.println("Episode with id " + id + " not found");
            throw new ResourceNotFoundException("Episode with id " + id + " not found");
        }
        return new ResponseEntity<Episode>(episode, HttpStatus.OK);
    }

    //delete a single episode. This will return you to the episode list home page, where the episode is now gone.
    //enter "http://localhost:8080/api/#/delete
    @RequestMapping("/{id}/delete")
    public ResponseEntity<Episode> delete(@PathVariable(value="id") Long id){

        Episode episode = episodeService.getEpisodeById(id);
        if (id == null) {
            System.out.println("Unable to delete. Episode with id " + id + " not found");
            throw new ResourceNotFoundException("Episode with id " + id + " not found");
        }

        episodeService.delete(id);
        System.out.println("Confirmation: Episode has been deleted.");
        return new ResponseEntity<Episode>(HttpStatus.NO_CONTENT);
    }


    //NOTE TO GRADER: To create a new Episode use PostMan to test
    @RequestMapping(value = "/create/", method = RequestMethod.POST)
    public ResponseEntity<Void> createEpisode(@RequestBody Episode episode,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Episode " + episode.getEpisodeName());

        episodeService.saveEpisode(episode);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/create/{id}").buildAndExpand(episode.getId()).toUri());
        return new ResponseEntity<>(null, headers, HttpStatus.CREATED);
    }


    //NOTE TO GRADER: to update exiting episode use PostMan to test
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Episode> updateEpisode(@PathVariable("id") long id, @RequestBody Episode episode) {
        System.out.println("Updating User " + id);

        Episode currentEpisode = episodeService.getEpisodeById(id);

        if (currentEpisode==null) {
            System.out.println("Episode with id " + id + " not found");
            return new ResponseEntity<Episode>(HttpStatus.NOT_FOUND);
        }

        currentEpisode.setEpisodeName(episode.getEpisodeName());
        currentEpisode.setEpisodeDesc(episode.getEpisodeDesc());
        currentEpisode.setEpisodeNum(episode.getEpisodeNum());
        currentEpisode.setSeason(episode.getSeason());
        currentEpisode.setImgurl(episode.getImgurl());

        episodeService.update(id, currentEpisode);
        return new ResponseEntity<Episode>(currentEpisode, HttpStatus.OK);
    }

}