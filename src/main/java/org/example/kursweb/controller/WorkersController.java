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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/main/owner/worker")
public class WorkersController {
    @Autowired
    OwnersService ownersService;
    @Autowired
    WorkersService workersService;
    @Autowired
    OrdersService ordersService;

    @GetMapping("/{id}")
    public String workerPage(Model model, @PathVariable("id") int id)
    {
        model.addAttribute("worker", workersService.getById(id));
        List<Order> ordersList =ordersService.getByWorker(id);
        model.addAttribute("order", ordersList);
        model.addAttribute("listSize", ordersList.size());
        return "worker_page";
    }

    @GetMapping("/editOrder/{id}")
    public String editOrder(@PathVariable("id") int id, Model model)
    {
        List<Worker> worker = workersService.findAll();
        model.addAttribute("worker", worker);
        model.addAttribute("order", ordersService.getById(id));
        return "orderEditPage";
    }


    @PostMapping
    public String edit(@ModelAttribute("order") Order order)
    {
        ordersService.update(order);

        return "redirect:/main/owner/worker/" + order.getWorker_name();
    }

    @GetMapping("/editWorker/{id}")
    public String editWorker(@PathVariable("id") int id, Model model)
    {
        List<Owner> owner = ownersService.findAll();
        model.addAttribute("owner", owner);
        model.addAttribute("worker", workersService.getById(id));
        return "workerEditPage";
    }


    @PostMapping("/edit_worker")
    public String edit_worker(@ModelAttribute("worker") Worker worker)
    {
        workersService.update(worker);

        return "redirect:/main/owner/worker/" + worker.getId();
    }

}
