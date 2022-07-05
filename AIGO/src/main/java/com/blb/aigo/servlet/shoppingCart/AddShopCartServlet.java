package com.blb.aigo.servlet.shoppingCart;


import com.blb.aigo.entity.ShopCartProduct;
import com.blb.aigo.mapper.ShopCartMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/addCart.do")
public class AddShopCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        //创建会话
        SqlSession sqlSession = factory.openSession();
        //获得映射接口对象
        ShopCartMapper mapper = sqlSession.getMapper(ShopCartMapper.class);
        String productId="0b50b6781c1e453e93b0cb2def378158";
        List<ShopCartProduct> shopCartProducts=mapper.selectProductNum(productId);
        HttpSession session = req.getSession();
        String userId=(String) session.getAttribute("userId");
        System.out.println(userId);
        String cartId=mapper.selectCartId(userId);
        System.out.println(cartId);


        String addProductId = req.getParameter("productID");
       if(userId==null)
       {
           req.getRequestDispatcher("/login.jsp").forward(req,resp);
       }else {

           String uuid= UUID.randomUUID().toString().replace("-","");
           System.out.println(uuid);
           if(shopCartProducts.size()==0){
               int productnum=1;
               ShopCartProduct sp=new ShopCartProduct(uuid,cartId,productId,productnum);
               mapper.insertCart(sp);
           }else{
               mapper.deleteProductNum(productId);
               int productnum=shopCartProducts.get(0).getProductNum()+1;
               System.out.println(productnum);
               String uuid1= UUID.randomUUID().toString().replace("-","");
               ShopCartProduct sp1=new ShopCartProduct(uuid1,cartId,productId,productnum);
               mapper.insertCart(sp1);
           }


           System.out.println("添加成功");
           sqlSession.commit();
           sqlSession.close();
           req.getRequestDispatcher("goodsDetail.jsp").forward(req,resp);
       }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
