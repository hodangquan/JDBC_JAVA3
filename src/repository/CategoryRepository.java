/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;

/**
 *
 * @author hodangquan
 */
public class CategoryRepository {
    public static List<Category> layDSCategory() throws SQLException{
        List<Category> categorys = new ArrayList();
        Connection con1 =  DBConect.getConnection(); // lấy kết lối dữ liệu
        String sql = "SELECT Id , CategoryName FROM CATEGORY"; // khởi tao truy vâns
        PreparedStatement statement = con1.prepareStatement(sql);
        ResultSet rs = statement.executeQuery(); 
        while(rs.next()){
            Integer id = rs.getInt("Id");
            String categoryName = rs.getString("CategoryName");
            
            
            Category category = new Category(id,categoryName );
            categorys.add(category);
        }
        rs.close();
        statement.close();
        con1.close();
        return  categorys;
    }
    public Category getByCategoryName(String name) throws SQLException{
        Connection con1 =  DBConect.getConnection(); // lấy kết lối dữ liệu
        String sql = "SELECT Id , CategoryName FROM CATEGORY WHERE CategoryName LIKE ?"; // khởi tao truy vâns
        PreparedStatement statement = con1.prepareStatement(sql);
        statement.setString(1, name);
        ResultSet rs = statement.executeQuery(); 
        while(rs.next()){
            Integer id = rs.getInt("Id");
            String categoryName = rs.getString("CategoryName");
            
            Category category = new Category(id, categoryName );
            return category;
        }
        rs.close();
        statement.close();
        con1.close();
        return null;
    }
    
    
}
