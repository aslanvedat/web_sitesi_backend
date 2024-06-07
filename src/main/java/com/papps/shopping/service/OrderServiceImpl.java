package com.papps.shopping.service;

import com.papps.shopping.dto.request.OrderRequestDto;
import com.papps.shopping.dto.response.OrderResponseDto;
import com.papps.shopping.entity.Order;
import com.papps.shopping.entity.Product;
import com.papps.shopping.exception.ApiRequestException;
import com.papps.shopping.repostory.OrderRepostitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepostitory orderRepostitory;
    private final ProductService productService;

    @Override
    public Order findById(long id) {
        Optional<Order> order = orderRepostitory.findById(id);
        return order.orElseThrow(() -> new ApiRequestException("order is not found"));
    }

    @Override
    public Order save(OrderRequestDto input) {
        Order order = new Order();
        order.setAmaount(input.getAmaount());
        order.setContact(input.getContact());
        var result = input.getProductIds().stream().map(Long::parseLong).toList();
        var products = productService.findByIds(result);
        order.setProducts((List<Product>) products);//todo burada bi degisiklik olabilir!!
        return orderRepostitory.save(order);
    }

    @Override
    public OrderResponseDto view(long id) {
        var result = findById(id);
        return new OrderResponseDto(result);
    }

    @Override
    public Order delete(long id) {
        var result = findById(id);
        orderRepostitory.delete(result);
        return result;
    }

    @Override
    public Order update(long id, OrderRequestDto input) {
        Order order = findById(id);
        order.setAmaount(input.getAmaount());
        order.setContact(input.getContact());
        var result = input.getProductIds().stream().map(Long::parseLong).toList();
        var products = productService.findByIds(result);
        order.setProducts((List<Product>) products);//todo burasi duzenlenecek
        return orderRepostitory.save(order);
    }
}
