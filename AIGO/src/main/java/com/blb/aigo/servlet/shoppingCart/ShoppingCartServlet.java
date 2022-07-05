package com.blb.aigo.servlet.shoppingCart;

import com.blb.aigo.entity.AddressShow;
import com.blb.aigo.entity.Product;
import com.blb.aigo.mapper.ProductMapper;
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
import java.util.Collections;
import java.util.List;

@WebServlet("/shopcart.do")
public class ShoppingCartServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        //创建会话
        SqlSession sqlSession = factory.openSession();
        //获得映射接口对象
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);

        List<AddressShow> addresses=mapper.showAddress();

        req.setAttribute("addresses",addresses);
        String userId=(String) req.getSession().getAttribute("userId");
        List<Product> shops=mapper.selectShop(userId);
        req.setAttribute("shops",shops);

        req.getRequestDispatcher("shoppingCart.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);

    }


}
