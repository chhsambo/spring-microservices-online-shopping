package com.sambochhay.simpleonlineshopping.orderservice.services;

import com.sambochhay.simpleonlineshopping.orderservice.dto.OrderLineitemDto;
import com.sambochhay.simpleonlineshopping.orderservice.dto.OrderRequest;
import com.sambochhay.simpleonlineshopping.orderservice.models.Order;
import com.sambochhay.simpleonlineshopping.orderservice.models.OrderLineItem;
import com.sambochhay.simpleonlineshopping.orderservice.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

         List<OrderLineItem> orderLineItems = orderRequest.getOrderLineitemDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

         order.setOrderLineItemsList(orderLineItems);
         orderRepository.save(order);
    }

    private OrderLineItem mapToDto(OrderLineitemDto orderLineitemDto) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setPrice(orderLineitemDto.getPrice());
        orderLineItem.setQuantity(orderLineitemDto.getQuantity());
        orderLineItem.setSkuCode(orderLineitemDto.getSkuCode());
        return orderLineItem;
    }
}
