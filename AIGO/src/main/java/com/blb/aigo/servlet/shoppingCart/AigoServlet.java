package com.blb.aigo.servlet.shoppingCart;

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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/check.do")
public class AigoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
//        SqlSession sqlSession=MyBatisUtil.createSqlSession();
//        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
//        String username=mapper.selectUsername();
//
//        String password = mapper.selectPassword();
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        //创建会话
        SqlSession sqlSession = factory.openSession();
        //获得映射接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String username1=req.getParameter("username");
        String password1=req.getParameter("password");

        String password=mapper.selectPassword(username1);
        String userId=mapper.selectUserId(username1);
        HttpSession session = req.getSession();

        if(password1.equals(password))
        {
            session.setAttribute("username",username1);
            session.setAttribute("password",password);
            session.setAttribute("userId",userId);
            sqlSession.close();
            req.getRequestDispatcher("index1.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("login.jsp?error=yes");
//            req.getRequestDispatcher("login.jsp").forward(req,resp);
//            resp.getWriter().print(true);
        }


//        req.setAttribute("users",users);
//        req.getRequestDispatcher("pets.jsp").forward(req,resp);
//        String username1=req.getParameter("username");
//        String password1=req.getParameter("password");
//        if(username.equals(username1)||password.equals(password1))
//        {
//            req.getRequestDispatcher("index.jsp").forward(req,resp);
//        }else {
//            resp.getWriter().print(true);
//        }



    }
}
