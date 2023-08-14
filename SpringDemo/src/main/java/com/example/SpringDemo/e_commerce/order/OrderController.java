package com.example.SpringDemo.e_commerce.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }
    @PostMapping("/orders")
    @ResponseBody
    public Order createOrder(@RequestBody OrderDTO orderDto){
        return orderService.createOrder(orderDto);
    }
    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable Long id){
       return orderService.getOrder(id);
    }
    @GetMapping("/orders/all-orders/{id}")
    public List<Order> getAllOrdersOfUser(@PathVariable Long id){
        return orderService.getAllOrdersOfUser(id);
    }
    @PutMapping("/orders/update/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order){
        orderService.updateOrder(id,order);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return ResponseEntity.notFound().build();
    }
}
