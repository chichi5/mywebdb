package com.chi.mywebdb.Data;
import com.chi.mywebdb.model.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//這裡是工具背起來
public class DBProvider {
    // 載入驅動
    // 建立連線
    // 執行查詢
    // 處理結果

    public DBProvider(){
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("驅動載入失敗，請確認 Mariadb-Java-Controller 是否載入");
        }
    }

    public List<Orders> getOrderData(String sql ) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<Orders> orders = new ArrayList<>();
        try {
            con = DriverManager.getConnection("jdbc:mariadb://localhost/classicmodels","root","12345");
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Orders o = new Orders();
                o.setOrderNumber( rs.getInt("orderNumber"));
                o.setOrderDate( rs.getDate("orderDate"));
                o.setRequiredDate(rs.getDate("requiredDate"));
                o.setComments( rs.getString("comments"));
                o.setCompanyName( rs.getString("customerName"));
                orders.add(o);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch( SQLException e) {
            System.out.println("連線異常" +  e.getMessage());
            return null;
        }
        return orders;
    }
}
