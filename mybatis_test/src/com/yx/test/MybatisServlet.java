package com.yx.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yx.mapper.DepartmentMapper;
import com.yx.po.Department;
import com.yx.po.CriteriaExample;

public class MybatisServlet {

    private SqlSessionFactory ssf;

    public MybatisServlet() {

        InputStream is = null;
        try {
            // 获取路径
            String resource = "mybatis-config.xml";

            // 获取信息流
            is = Resources.getResourceAsStream(resource);

            // 创建会话工厂
            ssf = new SqlSessionFactoryBuilder().build(is);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void excute() {

        // 获取sqlsession
         SqlSession ss = ssf.openSession();
         DepartmentMapper departmentmapper = ss.getMapper(DepartmentMapper.class);
         CriteriaExample criteriaexample = new CriteriaExample();
         criteriaexample.createCriteria().andIsNull("abateTime");
         List<Department> ds = departmentmapper.selectByExample(criteriaexample);
         System.out.println(ds.size());
         ss.close();
    };

    public static void main(String[] args) throws Exception {
        MybatisServlet ms = new MybatisServlet();
        ms.excute();
    }
}
