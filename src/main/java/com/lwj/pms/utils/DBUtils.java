package com.lwj.pms.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.beanutils.BeanUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class DBUtils {

    public static Connection getConnection() throws Exception {
        //读取配置文件
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(in);

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        return dataSource.getConnection();
    }

    public static <T> List<T> getList(Class<T> clazz, String sql, Object...args){

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> userList = null;

        try{
            conn = DBUtils.getConnection();
            System.out.println(sql);
            ps = conn.prepareStatement(sql);
            System.out.println(ps);
            if (args != null && args.length>0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            rs = ps.executeQuery();

            //获取结果集元素据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取当前结果集的列数
            int colnum = rsmd.getColumnCount();
            userList = new ArrayList<T>();

            while(rs.next()){

                //key存放列名 ，value存放列值，for循环完成之后，rowmap存放一条记录
                Map<String,Object> rowMap = new HashMap<String, Object>();
                for (int i = 1; i<=colnum;i++){
                    String columnName = rsmd.getColumnLabel(i);
                    Object columnValue = rs.getObject(columnName);
                    if(columnValue instanceof java.sql.Date){
                        java.sql.Date date = (java.sql.Date)columnValue;
                        columnValue = new java.util.Date(date.getTime());
                    }
                    rowMap.put(columnName,columnValue);
                }

                T bean = clazz.newInstance();

                for (Map.Entry<String,Object> entry : rowMap.entrySet() ) {
                    String propertyName = entry.getKey();
                    Object properValue = entry.getValue();
                    BeanUtils.setProperty(bean,propertyName,properValue);
                }
                System.out.println(bean);
                userList.add(bean);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(conn, ps, rs);
        }
        return userList;
    }


    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //保存对象方法
    public static boolean save(String sql, Object...args){

        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = null;

        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);

            System.out.println(sql);
            if (args != null && args.length>0) {
                for (int i = 0; i < args.length; i++) {
                    System.out.println(i+":"+args[i]);
                    ps.setObject(i + 1, args[i]);
                    System.out.println(args[i]);
                }
            }
            //返回更新的记录数
            count = ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(conn, ps,null);
        }

        return count!=null && count>0;
    }


    public  static <T> T  getSingleObj(Class<T> clazz, String sql, Object...args){
        Connection conn =null;
        PreparedStatement ps =null;
        ResultSet rs =null;
        T bean = null;
      /*  System.out.println("获取getSingleObj");*/
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            /*System.out.println("Conn:"+conn);
            System.out.println("ps:"+ps);*/
            if(args!=null && args.length>0){
                for (int i = 0;i< args.length;i++){
                    ps.setObject(i+1,args[i]);
                    System.out.println(args[i]);
                }
            }
            System.out.println(ps);
            rs = ps.executeQuery();
            System.out.println("rs:"+rs);
            //获取结果集元数据
            ResultSetMetaData rsmd =rs.getMetaData();
        /*    System.out.println("rsmd:"+rsmd);*/
            //获取当前结果集的列数
            int colnum =rsmd.getColumnCount();
         /*   System.out.println("colnum:"+colnum);*/
            while (rs.next()){
                //key存放列名，value存放列值，for循环完成之前，rowMap存放一条记录
                Map<String,Object> rowMap = new HashMap<String,Object>();

                for (int i = 1;i<=colnum;i++){
                    String columnName = rsmd.getColumnLabel(i);
                    Object columValue = rs.getObject(columnName);
                  /*  System.out.println("columnName:"+columnName);
                    System.out.println("columnValue:"+columValue);*/
                    //判断查询出来的类的类型，如果是java.sql.Date就转成java.util.Date
                    if (columValue instanceof java.sql.Date){
                        java.sql.Date date = (java.sql.Date)columValue;
                        columValue = new java.util.Date(date.getTime());
                    }
                    rowMap.put(columnName,columValue);
                }
                //创建一个对象 给它赋值
                bean = clazz.newInstance();
              /*  System.out.println("bean"+bean);*/
                for(Map.Entry<String,Object> entry : rowMap.entrySet()) {
                    String propertyName = entry.getKey();
                    Object propertyValue = entry.getValue();
                    /*System.out.println("entry:"+propertyName+","+propertyValue);*/
                    BeanUtils.setProperty(bean, propertyName, propertyValue);
                   /* System.out.println("--"+bean);*/
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            close(conn, ps, rs);
        }
      /*  System.out.println(bean);*/
        return bean;
    }

    //查询记录数量
    public static Integer getCount(String sql, Object...args) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer count = null;
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);

            if (args != null && args.length>0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            rs = ps.executeQuery();

            while(rs.next()){

                count = rs.getInt(1);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(conn, ps, rs);
        }

        return count;
    }


    //更新操作
    public static boolean update(String sql, Object...args){
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;

        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);

            if (args != null && args.length>0) {
                for (int i = 0; i < args.length; i++) {

                    //判断当前类型，是不是java.util.Date,转换成java.sql.Date
                    if (args[i] instanceof java.util.Date){
                        java.util.Date date = (java.util.Date)args[i];
                        //转换成java.sql.Date
                        args[i] = new java.sql.Date(date.getTime());
                    }
                    ps.setObject(i + 1, args[i]);
                }
            }
            count = ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(conn, ps, null);
        }

        return count>0 ? true : false;
    }

    //更新操作
    public static Integer updateForPrimary(String sql, Object...args){

        Connection conn = null;
        PreparedStatement ps = null;
        Integer primaryKey = null;
        ResultSet rs = null;

        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            if (args != null && args.length>0) {
                for (int i = 0; i < args.length; i++) {

                    //判断当前类型，是不是java.util.Date,转换成java.sql.Date
                    if (args[i] instanceof java.util.Date){
                        java.util.Date date = (java.util.Date)args[i];
                        //转换成java.sql.Date
                        args[i] = new java.sql.Date(date.getTime());
                    }

                    ps.setObject(i + 1, args[i]);
                }
            }
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if (rs.next()){
                primaryKey = rs.getInt(1);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(conn, ps, rs);
        }

        return primaryKey;
    }

}
