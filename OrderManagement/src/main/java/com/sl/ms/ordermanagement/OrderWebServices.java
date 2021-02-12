package com.sl.ms.ordermanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@EnableCircuitBreaker
@RestController
public class OrderWebServices {

  private static Logger LOGGER = LoggerFactory.getLogger(OrderWebServices.class);

  OrderDAO orderDao;

  @Autowired
  private InventoryService inventoryService;

  public OrderWebServices(OrderDAO orderDao) {
    super();
    this.orderDao = orderDao;
  }

  @GetMapping("/orders")
  public Iterable<Order> getOrders() {
    LOGGER.info("info- {getOrders}");
    LOGGER.trace("trace- {getOrders}");
    LOGGER.debug("debug- {getOrders}");
    LOGGER.error("error- {getOrders}");
    return orderDao.findAll();
  }

  @GetMapping("/orders/{id}")
  public Order getOrderById(@PathVariable("id") Long id) {
    LOGGER.info("Entering getOrderById with Id:" + id);
    return orderDao.findById(id).get();
  }

  @PostMapping(value = "/orders/{id}", consumes = "application/json", produces = "application/json")
  public Order saveOrder(@PathVariable("id") Long id, @RequestBody Order order) {
    LOGGER.info("Your log - {saveOrder}", order.getName());
    try {
      order.setId(id);
      return orderDao.save(order);
    } catch(Exception e) {
      LOGGER.error("Exception in POST order by id:" + e);
      return new Order();
    }
  }

  @GetMapping("orders/inventory")
  public String getInventory() {
    LOGGER.info("info- {getInventory}");
    return inventoryService.inventoryList();
  }

}
