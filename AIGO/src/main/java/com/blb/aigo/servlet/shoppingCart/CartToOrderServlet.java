package com.blb.aigo.servlet.shoppingCart;

import com.blb.aigo.entity.OrderProduct;
import com.blb.aigo.entity.ShopCartProduct;
import com.blb.aigo.mapper.CartToOrderMapper;
import com.blb.aigo.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/cto.do")
public class CartToOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        //创建会话
        SqlSession sqlSession = factory.openSession();
        //获得映射接口对象
       CartToOrderMapper mapper1 = sqlSession.getMapper(CartToOrderMapper.class);
        List<ShopCartProduct>carts=mapper1.selectcart();

        CartToOrderMapper mapper2=sqlSession.getMapper(CartToOrderMapper.class);
        for(ShopCartProduct cart:carts){
            String id= UUID.randomUUID().toString().replace("-","");
            String orderId=UUID.randomUUID().toString().replace("-","");

            OrderProduct ord=new OrderProduct(id,orderId,cart.getProductId(),cart.getProductNum());
            mapper2.insertOrder(ord);
        }

        CartToOrderMapper mapper3=sqlSession.getMapper(CartToOrderMapper.class);

        for(ShopCartProduct cart:carts){
            String id=cart.getId();
            mapper3.deleteCart(id);
        }
        sqlSession.commit();
    req.getRequestDispatcher("buyerTrade.jsp").forward(req,resp);
    }
}

