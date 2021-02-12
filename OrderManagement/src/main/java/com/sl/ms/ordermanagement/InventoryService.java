package com.sl.ms.ordermanagement;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class InventoryService {

  private final RestTemplate restTemplate;

  public InventoryService(RestTemplate rest) {
  this.restTemplate = rest;
  }

  @HystrixCommand(fallbackMethod = "reliable")
  public String inventoryList() {
  URI uri = URI.create("http://localhost:8888/dev/products");

  return this.restTemplate.getForObject(uri, String.class);
  }

  public String reliable() {
  return "Look like service unavailable. Please try later.";
  }

}