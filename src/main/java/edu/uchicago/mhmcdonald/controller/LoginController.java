package edu.uchicago.mhmcdonald.controller;

/**
 * Created by markmcdonald on 8/18/16.
 * This is the Login Controller.
 */

import edu.uchicago.mhmcdonald.commands.LoginCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
public class LoginController {

    @RequestMapping("/login")
    public String showLoginForm(Model model){

        model.addAttribute("loginCommand", new LoginCommand());

        return "loginform";
    }

    @RequestMapping("logout-success")
    public String yourLoggedOut(){

        return "logout-success";
    }

    public String doLogin(@Valid LoginCommand loginCommand, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "loginform";
        }

        return "redirect:episodelist";
    }
}
