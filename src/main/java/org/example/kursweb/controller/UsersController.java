package org.example.kursweb.controller;


import org.example.kursweb.Models.MainUser;
import org.example.kursweb.Models.Owner;
import org.example.kursweb.Models.Worker;
import org.example.kursweb.Service.MainUserService;
import org.example.kursweb.Service.OwnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/main")
public class UsersController {

    @Autowired
    OwnersService ownersService;
    @Autowired
    MainUserService mainUserService;


    @PostMapping("/mainLog")
    public String mainLog(@ModelAttribute("main") MainUser mainUser, Model model)
    {
        MainUser mainUser1 = mainUserService.getByLogin(mainUser.getLogin());
        if(!mainUser.getPass().equals(mainUser1.getPass()))
        {
            return "redirect:/";
        }
        return "redirect:/main/table";
    }

    @GetMapping("/table")
    public String main(Model model) {
        List<Owner> ow = ownersService.findAll();
        model.addAttribute("owner", ow);
        return "mainPage";
    }

    @GetMapping("/add_owner")
    public String addWorker(Model model)
    {
        model.addAttribute("owner", new Owner());
        return "add_owner";
    }

    @PostMapping
    public String add(@ModelAttribute("owner") Owner owner)
    {
        ownersService.save(owner);
        return "redirect:/main/table";
    }





}
