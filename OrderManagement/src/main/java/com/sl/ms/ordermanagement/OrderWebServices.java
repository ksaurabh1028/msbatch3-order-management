package com.sl.ms.ordermanagement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderWebServices {

  OrderDAO orderDao;
  
  public OrderWebServices(OrderDAO orderDao) {
    super();
    this.orderDao = orderDao;
  }

  @GetMapping
  public Iterable<Order> getOrders() {
    return orderDao.findAll();
  }

  @GetMapping("/orders/{id}")
  public Order getOrderById(@PathVariable("id") Long id) {
    return orderDao.findById(id).get();
  }

  @PostMapping(value = "/orders/{id}", consumes = "application/json", produces = "application/json")
  public Order saveOrder(@PathVariable("id") Long id, @RequestBody Order order) {
    System.out.println("Name:" + order.getName());
    order.setId(id);
    return orderDao.save(order);
  }

}
