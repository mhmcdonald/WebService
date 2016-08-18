//package edu.uchicago.mhmcdonald.controller;
//
//import edu.uchicago.mhmcdonald.service.EpisodeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//
///**
// * Created by markmcdonald on 8/17/16.
// */
//
//
//@Controller
//public class IndexController {
//
//    private EpisodeService episodeService;
//
//    @Autowired
//    public void setEpisodeService(EpisodeService episodeService) {
//        this.episodeService = episodeService;
//    }
//
//    @RequestMapping({"/", "index"})
//    public String getIndex(Model model) {
//
//        model.addAttribute("episodes", episodeService.list());
//
//        return "index";
//    }
//
//    @RequestMapping("secured")
//    public String secured() {
//        return "secured";
//    }
//
//    //create post
//    //read get
//    //video 3 @7mins
//
////    @RequestMapping({"/", "index"})
////    public String getIndex(Model model){
////
////        model.addAttribute("episodes", episodeService.list());
////
////        return "index";
////    }
////
////    @RequestMapping("secured")
////    public String secured(){
////        return "secured";
////    }
////}
//}