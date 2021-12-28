package br.com.alura.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mudi.controller.dto.NewOrder;
import br.com.alura.mudi.service.OrderService;

@Controller
@RequestMapping("order")
public class OrderController {
 
  @Autowired
  private OrderService orderService;
  
  @GetMapping("form")
  public String form(NewOrder newOrder) {
    return "order/form";
  }
  
  @PostMapping("new")
  public String newOrder(@Valid NewOrder newOrder, BindingResult result) {
    if(result.hasErrors()) {
      return "order/form";
    }
    
    orderService.createOrder(newOrder.toOrder());
    
    return "redirect:/user/order?success=true";
  }
  
}
