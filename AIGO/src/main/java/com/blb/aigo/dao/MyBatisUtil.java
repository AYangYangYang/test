package com.blb.aigo.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class MyBatisUtil {
    //创建会话工厂创建器
    private static SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    private static SqlSessionFactory factory = null;
    static{
        // 创建工厂
        try {
            factory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //创建会话
    public static SqlSession createSqlSession(){
        return factory.openSession();
    }

}