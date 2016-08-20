package edu.uchicago.mhmcdonald.controller;

/**
 * Created by markmcdonald on 8/20/16.
 */

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;
import edu.uchicago.mhmcdonald.domain.Greeting;
import edu.uchicago.mhmcdonald.domain.Episode;
import edu.uchicago.mhmcdonald.service.EpisodeService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private static BigInteger nextId;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private EpisodeService episodeService;

//    @RequestMapping("/greeting")
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                String.format(template, name));
//    }

    private static Map<BigInteger, Episode> greetingMap;

    private static Episode save(Episode episode) {
        if (greetingMap == null) {
            greetingMap = new HashMap<BigInteger, Episode>();
            nextId = BigInteger.ONE;
        }
        BigInteger bi1 = nextId;
        long l1 = bi1.longValue();
        episode.setId(l1);
        nextId = nextId.add(BigInteger.ONE);
        BigInteger bi = BigInteger.valueOf(episode.getId());

        greetingMap.put(bi, episode);
        return episode;
    }

    @RequestMapping(
            value = "/api/episodes",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Episode>> getEpisodes(){
        Collection<Episode> greetings = greetingMap.values();
        return new ResponseEntity<Collection<Episode>>(greetings, HttpStatus.OK);
    }

//    @RequestMapping("episode/{id}")
//    public String showEpisode(@PathVariable Long id, Model model){
//        model.addAttribute("episode", episodeService.getEpisodeById(id));
//        return String.valueOf(episodeService.getEpisodeById(id));
//    }


//    @RequestMapping(value = "/getlist", method = RequestMethod.GET)
//    public String list(Model model){
//        return String.valueOf(model.addAttribute("episodes", episodeService.list()));
//        }
////
//    @RequestMapping("/{id}/delete")
//    public void delete(@PathVariable(value="id") long id){
//        episodeService.delete(id);
//    }

}