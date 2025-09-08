package com.kh.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProductInsertRun {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        int result = 0;

        Scanner sc = new Scanner(System.in);

        System.out.print("제품 ID를 입력해주세요 > ");
        int productNo = sc.nextInt();
        sc.nextLine();

        System.out.print("제품명을 입력해주세요 > ");
        String productName = sc.nextLine();

        System.out.print("SKU(고유값)를 입력해주세요 > ");
        String sku = sc.nextLine();

        System.out.print("카테고리를 입력해주세요 > ");
        String category = sc.nextLine();

        System.out.print("가격을 입력해주세요 > ");
        double price = sc.nextDouble();

        System.out.print("재고 수량을 입력해주세요 > ");
        int quantity = sc.nextInt();

        String sql = "INSERT INTO TB_PRODUCTS VALUES(" 
                   + productNo + ", '" 
                   + productName + "', '" 
                   + sku + "', '" 
                   + category + "', " 
                   + price + ", " 
                   + quantity + ", SYSDATE)";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@115.90.212.20:10000:XE",
                "SSG13", "SSG131234"
            );

            conn.setAutoCommit(false);

            stmt = conn.createStatement();

            result = stmt.executeUpdate(sql);

            if(result > 0) {
                conn.commit();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("OJDBC 라이브러리 누락");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("접속정보 또는 SQL 문법 확인 필요");
        } finally {
            try {
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
