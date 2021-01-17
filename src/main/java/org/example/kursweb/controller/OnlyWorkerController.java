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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/worker")
public class OnlyWorkerController {
    private int id;
    @Autowired
    OwnersService ownersService;
    @Autowired
    WorkersService workersService;
    @Autowired
    OrdersService ordersService;


    @PostMapping
    public String workerLog(@ModelAttribute("worker") Worker worker, Model model)
    {
        Worker worker1 = workersService.getByLogin(worker.getLogin());
        if(!worker.getPass().equals(worker.getPass()))
        {
            return "redirect:/";
        }
        this.id = worker1.getId();
        return "redirect:/worker/info";
    }

    @GetMapping("/info")
    public String worker_only(Model model) {
        model.addAttribute("worker", workersService.getById(id));
        List<Order> ordersList =ordersService.getByWorker(id);
        model.addAttribute("order", ordersList);
        model.addAttribute("listSize", ordersList.size());
        return "OnlyWorker_page";
    }

}
