package org.example.kursweb.controller;

import org.example.kursweb.Models.Order;
import org.example.kursweb.Models.Owner;
import org.example.kursweb.Models.Worker;
import org.example.kursweb.Service.OrdersService;
import org.example.kursweb.Service.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/main/owner/worker/order")
public class OrdersController {

    @Autowired
    OrdersService ordersService;
    @Autowired
    WorkersService workersService;

    @GetMapping("/add_order")
    public String addWorker(Model model)
    {
        List<Worker> worker = workersService.findAll();
        model.addAttribute("worker", worker);
        model.addAttribute("order", new Order());
        return "add_order";
    }

    @PostMapping
    public String add(@ModelAttribute("order") Order order)
    {
        ordersService.save(order);
        return "redirect:/main/owner/worker/" + order.getWorker_name();
    }

    @GetMapping("/editOrder/{id}")
    public String editOrder(@PathVariable("id") int id, Model model)
    {
        List<Worker> worker = workersService.findAll();
        model.addAttribute("worker", worker);
        model.addAttribute("order", ordersService.getById(id));
        return "orderEditPage";
    }


    @PostMapping("/edit_order")
    public String edit(@ModelAttribute("order") Order order)
    {
        ordersService.update(order);

        return "redirect:/main/owner/worker/" + order.getWorker_name();
    }
}
