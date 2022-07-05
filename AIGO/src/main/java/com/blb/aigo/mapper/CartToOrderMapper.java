package com.blb.aigo.mapper;

import com.blb.aigo.entity.OrderProduct;
import com.blb.aigo.entity.ShopCartProduct;
import java.util.List;


public interface CartToOrderMapper {
    List<ShopCartProduct> selectcart();
    void insertOrder(OrderProduct orderProduct);
    void deleteCart(String id);
}
