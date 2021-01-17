package org.example.kursweb.controller;

import org.example.kursweb.Models.MainUser;
import org.example.kursweb.Models.Owner;
import org.example.kursweb.Models.Worker;
import org.example.kursweb.Service.OwnersService;
import org.example.kursweb.Service.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Контроллер отвечающий за вход в систему

@Controller
@RequestMapping("/")
public class LogController {
    @Autowired
    OwnersService ownersService;
    @Autowired
    WorkersService workersService;

    @GetMapping("/")
    public String index() {
        return "choiceLoginPage";
    }

    @PostMapping("/loginOwner")
    public String loginOwner(Model model)
    {
        model.addAttribute("owner", new Owner());
        return "loginOwner";
    }

    @PostMapping("/loginWorker")
    public String loginWorker(Model model)
    {
        model.addAttribute("worker", new Worker());
        return "loginWorker";
    }

    @PostMapping("/loginMain")
    public String loginMain(Model model)
    {
        model.addAttribute("main", new MainUser());
        return "loginIn";
    }
}
