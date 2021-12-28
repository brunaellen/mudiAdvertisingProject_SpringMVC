package br.com.alura.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mudi.repository.model.Order;
import br.com.alura.mudi.service.OrderService;

@Controller
@RequestMapping("user")
public class UserController {
  
  @Autowired
  private OrderService orderService;
  
  @GetMapping("order")
  public String home(Model model) {
    List<Order> orders = orderService.getOrdersByUser();
    
    model.addAttribute("orders", orders);
    return "user/userHome";
  }
  
  @GetMapping("order/{status}")
  public String byStatus(@PathVariable("status") String status, Model model) {
    List<Order> orders = orderService.getOrdersByStatusAndUser(status);

    model.addAttribute("orders", orders);
    model.addAttribute("status", status);
    return "user/userHome";
  }
  
  @ExceptionHandler(IllegalArgumentException.class)
  public String onError() {
    return "redirect:/userHome";
  }
}
