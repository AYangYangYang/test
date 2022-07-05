package com.blb.aigo.mapper;

import com.blb.aigo.entity.AddressShow;
import com.blb.aigo.entity.Product;

import java.util.List;

public interface ProductMapper {
    List<Product> selectShop(String userId);
    List<AddressShow> showAddress();
}
