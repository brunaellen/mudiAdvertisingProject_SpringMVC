package br.com.alura.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mudi.repository.model.Order;
import br.com.alura.mudi.service.OrderService;

@Controller
@RequestMapping("/home")
public class HomeController {
  
  @Autowired
  private OrderService orderService;
  
  @GetMapping
  public String home(Model model) {
    List<Order> orders = orderService.getOrdersDelivered();
    model.addAttribute("orders", orders);
    
    return "home";
  }
}
