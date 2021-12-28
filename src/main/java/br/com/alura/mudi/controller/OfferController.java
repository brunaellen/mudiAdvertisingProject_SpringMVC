package br.com.alura.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offer")
public class OfferController {
  
  @GetMapping
  public String getFormularioParaOfertas() {
    return "offer/offerHome";
  }
}
