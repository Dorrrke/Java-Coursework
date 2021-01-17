package org.example.kursweb.controller;

import org.example.kursweb.Models.Order;
import org.example.kursweb.Models.Owner;
import org.example.kursweb.Models.Worker;
import org.example.kursweb.Service.OrdersService;
import org.example.kursweb.Service.OwnersService;
import org.example.kursweb.Service.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@Controller
@RequestMapping("/owner")
public class OnlyOwnerController {

    private int id;
    @Autowired
    OwnersService ownersService;
    @Autowired
    WorkersService workersService;
    @Autowired
    OrdersService ordersService;



    @PostMapping
    public String ownerLog(@ModelAttribute("owner") Owner owner, Model model)
    {
        Owner owner1 = ownersService.getByLogin(owner.getLogin());
        if(!owner.getPass().equals(owner1.getPass()))
        {
            return "redirect:/";
        }
        this.id = owner1.getId();
        return "redirect:/owner/info";
    }

    @GetMapping("/info")
    public String owner_only(Model model) {
        model.addAttribute("owner", ownersService.getById(id));
        List<Worker> ownerList = workersService.getByOwner(id);
        model.addAttribute("worker", ownerList);
        model.addAttribute("size", ownerList.size());
        return "OnlyOwner_page";
    }

    @GetMapping("/add_worker_O")
    public String addWorker(Model model)
    {
        List<Owner> owner = ownersService.findAll();
        model.addAttribute("owner", owner);
        model.addAttribute("worker", new Worker());
        return "add_worker_O";
    }

    @PostMapping("/add_worker")
    public String add(@ModelAttribute("worker") Worker worker)
    {
        workersService.save(worker);
        return "redirect:/owner/info" + worker.getEmployer();
    }

    @GetMapping("/worker/{id}")
    public String worker_info(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("worker", workersService.getById(id));
        List<Order> ordersList =ordersService.getByWorker(id);
        model.addAttribute("order", ordersList);
        model.addAttribute("listSize", ordersList.size());
        return "only_owner_workerPage";
    }


}
