package com.example.SpringDemo.e_commerce.order;

import com.example.SpringDemo.e_commerce.customer.Customer;
import com.example.SpringDemo.e_commerce.customer.CustomerRepository;
import com.example.SpringDemo.e_commerce.product.Product;
import com.example.SpringDemo.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    OrderRepository orderRepository;


    CustomerRepository customerRepository;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository){
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public Order createOrder(OrderDTO orderDTO){
//        Optional<User> user = userRepository.findById(orderDTO.getCustomerId());
        Optional<Customer> customer = customerRepository.findById(orderDTO.getCustomerId());
//        if (user.get() instanceof Customer){
//        Customer customer = (Customer) user.get();
        Order order = new Order();
        order.setCustomer(customer.get());
        order.setOrderDescription(orderDTO.getOrderDescription());
        return orderRepository.save(order);
    }

    public Order getOrder(Long id){
        if(orderRepository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("Order not found");
        }
        return orderRepository.findByOrderId(id);
    }

    public List<Order> getAllOrdersOfUser(Long customer_id){
        return orderRepository.findByCustomer_UserId(customer_id);
    }

    public Order updateOrder(Long id, Order orderDetails){
        if(orderRepository.findByOrderId(id) == null){
            throw new ResourceNotFoundException("Order not Found");
        }
        Order updated = orderRepository.findByOrderId(id);
        updated.setOrderDescription(orderDetails.getOrderDescription());
        return orderRepository.save(updated);
    }

    public ResponseEntity<Order> deleteOrder(Long id){
        if(orderRepository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("Order not Found");
        }
        orderRepository.deleteById(id);
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Order> addProductToOrder(Long id, Product product){
        if (orderRepository.findByOrderId(id) == null){
            throw new ResourceNotFoundException("Order not found");
        }
        Order order = orderRepository.findByOrderId(id);
        order.addProduct(product);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Order> addProductsToOrder(Long id, List<Product> products){
        if (orderRepository.findByOrderId(id) == null){
            throw new ResourceNotFoundException("Order not found");
        }
        Order order = orderRepository.findByOrderId(id);
        order.addProducts(products);
        return ResponseEntity.ok().build();
    }
}
