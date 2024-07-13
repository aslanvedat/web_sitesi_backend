package com.papps.shopping.service;

import com.papps.shopping.dto.request.OrderRequestDto;
import com.papps.shopping.dto.response.OrderResponseDto;
import com.papps.shopping.entity.Order;
import com.papps.shopping.entity.User;
import com.papps.shopping.exception.ApiRequestException;
import com.papps.shopping.repository.OrderRepository;
import com.papps.shopping.security.UserContext;
import com.sun.security.auth.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepostitory;
    private final ContactInfoService contactInfoService;
    private final OrderProductService orderProductService;
    private final UserService userService;

    @Override
    public Order findById(long id) {
        Optional<Order> order = orderRepostitory.findById(id);
        return order.orElseThrow(() -> new ApiRequestException("order is not found"));
    }

    @Override
    public Order save(OrderRequestDto input) {
        Order order = new Order();
        order.setAmaount(input.getAmaount());
        var contactInfo = contactInfoService.findById(input.getContactId());
        order.setContact(contactInfo);
        var result = input.getOrderProductIds().stream().map(Long::parseLong).toList();
        var products = orderProductService.findByIds(result);
        order.setOrderProducts(products);

        UserPrincipal currentUser = UserContext.getCurrentUser();
        User user = userService.findByEmail(currentUser.getName());
        order.setUser(user);


        return orderRepostitory.save(order);
    }

    @Override
    public OrderResponseDto view(long id) {
        var result = findById(id);
        UserPrincipal currentUser = UserContext.getCurrentUser();
        if (!result.getUser().getName().equals(currentUser.getName())) {
            throw new ApiRequestException("you can only view your own Order");
        }

        return new OrderResponseDto(result);
    }

    @Override
    public Order delete(long id) {
        var result = findById(id);

        UserPrincipal currentUser = UserContext.getCurrentUser();
        if (!result.getUser().getName().equals(currentUser.getName())) {
            throw new ApiRequestException("you can only delete your own Order");
        }
        orderRepostitory.delete(result);
        return result;
    }

    @Override
    public Order update(long id, OrderRequestDto input) {
        Order order = findById(id);
        UserPrincipal currentUser = UserContext.getCurrentUser();
        if (!order.getUser().getName().equals(currentUser.getName())) {
            throw new ApiRequestException("You're only updated your own order");
        }
        order.setAmaount(input.getAmaount());
        var contactInfo = contactInfoService.findById(input.getContactId());
        order.setContact(contactInfo);
        var result = input.getOrderProductIds().stream().map(Long::parseLong).toList();
        var products = orderProductService.findByIds(result);
        order.setOrderProducts(products);
        return orderRepostitory.save(order);
    }

}
