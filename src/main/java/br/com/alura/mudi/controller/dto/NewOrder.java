package br.com.alura.mudi.controller.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.mudi.repository.model.Order;
import br.com.alura.mudi.repository.model.StatusOrder;

public class NewOrder {
  
  @NotBlank
  private String nameOfProduct;
  
  @NotBlank
  private String urlOfProduct;
  
  @NotBlank
  private String urlOfImage;
  private String description;
  
  public String getNameOfProduct() {
    return nameOfProduct;
  }
  
  public String getUrlOfProduct() {
    return urlOfProduct;
  }
  
  public String getUrlOfImage() {
    return urlOfImage;
  }
  
  public String getDescription() {
    return description;
  }
  
  public void setNameOfProduct(String nameOfProduct) {
    this.nameOfProduct = nameOfProduct;
  }

  public void setUrlOfProduct(String urlOfProduct) {
    this.urlOfProduct = urlOfProduct;
  }

  public void setUrlOfImage(String urlOfImage) {
    this.urlOfImage = urlOfImage;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Order toOrder() {
    Order order = new Order();
    order.setDescription(description);
    order.setNameOfProduct(nameOfProduct);
    order.setUrlOfImage(urlOfImage);
    order.setUrlOfProduct(urlOfProduct);
    order.setStatus(StatusOrder.PENDING);
    return order;
  }

}
