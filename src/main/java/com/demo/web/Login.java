package com.demo.web;

import com.demo.entity.User;
import com.demo.service.SecurityService;
import com.demo.service.UserService;
import com.demo.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/4/27.
 */

@Controller
public class Login {

    @Autowired
    UserValidator userValidator;

    @Autowired
    UserService userService;

    @Autowired
    SecurityService securityService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model, String error, String logout){
        if (error!=null){model.addAttribute("error", "Your username and password is invalid.");}
        if (logout!=null){model.addAttribute("message", "You have been logged out successfully.");}
        return "login";
    }
    @RequestMapping(value = "registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }
    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult result,Model model){
        userValidator.validate(userForm,result);
        if (result.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        securityService.autologin(userForm.getUsername(),userForm.getPasswordConfirm());
        return "redirect:/seckill/list";
    }
}
