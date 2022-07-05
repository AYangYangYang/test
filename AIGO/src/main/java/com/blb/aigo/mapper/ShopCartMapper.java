package com.blb.aigo.mapper;

import com.blb.aigo.entity.ShopCartProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCartMapper {

    //查询是否有该商品记录
    List<ShopCartProduct> selectProductNum(String productId);

    //删除原数据
    void deleteProductNum(String productId);

    String selectCartId(String userId);
//    void insertCart(@Param("id") String uuid, @Param("shopCartId") String cartId, @Param("productId") String productId, @Param("productNum") int productnum);

    void insertCart(ShopCartProduct sp);
}
