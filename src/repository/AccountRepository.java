/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author hodangquan
 */
public class AccountRepository {
    public List<Account> layDSAccounts() throws SQLException{
        List<Account> accounts = new ArrayList();
        Connection con1 =  DBConect.getConnection(); // lấy kết lối dữ liệu
        String sql = "SELECT Username , Password , Role FROM ACCOUNT"; // khởi tao truy vâns
        PreparedStatement statement = con1.prepareStatement(sql);
        ResultSet rs = statement.executeQuery(); 
        while(rs.next()){
            String username = rs.getString("Username");
            String password = rs.getString("Password");
            Integer role = rs.getInt("Role");
            
            Account a = new Account(username, password , role);
            accounts.add(a);
        }
        rs.close();
        statement.close();
        con1.close();
        return accounts;
    }
    
    public static Account getByUsername(String username) throws SQLException{
        Account account = new Account();
         Connection con1 =  DBConect.getConnection(); // lấy kết lối dữ liệu
        String sql = "SELECT Username , Password , Role FROM ACCOUNT where Username like ?"; // khởi tao truy vâns
        PreparedStatement statement = con1.prepareStatement(sql);
        statement.setString(1, username);
        ResultSet rs = statement.executeQuery(); 
        while(rs.next()){
        
        String user = rs.getString("Username");
        String password = rs.getString("Password");
        Integer role = rs.getInt("Role");
            
         account = new Account(user, password , role);
        
    }
        rs.close();
        statement.close();
        con1.close();
        return account;
    }
    
}