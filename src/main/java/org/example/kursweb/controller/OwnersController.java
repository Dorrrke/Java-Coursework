package org.example.kursweb.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.example.kursweb.Models.Order;
import org.example.kursweb.Models.Owner;
import org.example.kursweb.Models.Worker;
import org.example.kursweb.Service.OwnersService;
import org.example.kursweb.Service.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/main/owner")
public class OwnersController {
    @Autowired
    OwnersService ownersService;
    @Autowired
    WorkersService workersService;

    @GetMapping("/{id}")
    public String ownerInfo(Model model, @PathVariable("id") int id)
    {
        model.addAttribute("owner", ownersService.getById(id));
        List<Worker> ownerList = workersService.getByOwner(id);
        model.addAttribute("worker", ownerList);
        model.addAttribute("size", ownerList.size());
        return "owner_page";
    }


    @GetMapping("/add_worker")
    public String addWorker(Model model)
    {
        List<Owner> owner = ownersService.findAll();
        model.addAttribute("owner", owner);
        model.addAttribute("worker", new Worker());
        return "add_worker";
    }

    @PostMapping
    public String add(@ModelAttribute("worker") Worker worker)
    {
        workersService.save(worker);
        return "redirect:/main/owner/" + worker.getEmployer();
    }
}
