package com.papps.shopping.service;

import com.papps.shopping.dto.request.OrderProductRequestDto;
import com.papps.shopping.dto.response.OrderProductResponseDto;
import com.papps.shopping.entity.OrderProduct;
import com.papps.shopping.entity.User;
import com.papps.shopping.exception.ApiRequestException;
import com.papps.shopping.repository.OrderProductRepository;
import com.papps.shopping.security.UserContext;
import com.sun.security.auth.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderProductServiceImpl implements OrderProductService {
    private final OrderProductRepository orderProductRepository;
    // private final OrderService orderService;
    private final ProductInfoService productInfoService;
    private final UserService userService;

    @Override
    public OrderProduct findById(long id) {
        Optional<OrderProduct> orderProduct = orderProductRepository.findById(id);
        return orderProduct.orElseThrow(() -> new ApiRequestException("OrderProduct is not found!"));
    }

    @Override
    public List<OrderProduct> findByIds(List<Long> ids) {
        return orderProductRepository.findAllById(ids);
    }


    @Override
    public OrderProduct save(OrderProductRequestDto input) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setPrice(input.getPrice());
        orderProduct.setStatus(input.getStatus());
 /*       var result = input.getOrderId();
        var order = orderService.findById(result);
        orderProduct.setOrder(order);*/
        var result2 = input.getProductInfoId();
        var productInfo = productInfoService.findById(result2);
        orderProduct.setProductInfo(productInfo);

        UserPrincipal currentUser = UserContext.getCurrentUser();
        User user = userService.findByEmail(currentUser.getName());
        orderProduct.setUser(user);

        return orderProductRepository.save(orderProduct);
    }

    @Override
    public OrderProductResponseDto view(long id) {
        var result = findById(id);
        UserPrincipal currentUser = UserContext.getCurrentUser();//id kullanmadan nasil buluyoruz??
        if (!result.getUser().getName().equals(currentUser.getName())) {
            throw new ApiRequestException("you can only view your own Order product");
        }
        return new OrderProductResponseDto(result);
    }

    @Override
    public OrderProduct delete(long id) {
        var result = findById(id);
        UserPrincipal currentUser = UserContext.getCurrentUser();//id kullanmadan nasil buluyoruz??
        if (!result.getUser().getName().equals(currentUser.getName())) {
            throw new ApiRequestException("you can only delete your own Order product");
        }
        orderProductRepository.delete(result);
        return result;
    }

    @Override
    public OrderProduct update(long id, OrderProductRequestDto input) {
        var orderProduct = findById(id);
        UserPrincipal currentUser = UserContext.getCurrentUser();
        if (!orderProduct.getUser().getName().equals(currentUser.getName())) {
            throw new ApiRequestException("You're only updated your own order product");
        }
        orderProduct.setPrice(input.getPrice());
        orderProduct.setStatus(input.getStatus());
      /*  var result = input.getOrderId();
        var order = orderService.findById(result);
        orderProduct.setOrder(order);*/
        var result2 = input.getProductInfoId();
        var productInfo = productInfoService.findById(result2);
        orderProduct.setProductInfo(productInfo);
        return orderProductRepository.save(orderProduct);
    }
}
