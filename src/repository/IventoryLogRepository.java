/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import model.Ghe;
import model.Iventory;



/**
 *
 * @author hodangquan
 */
public class IventoryLogRepository {
    public List<Iventory> layDSBaoCao(String date) throws SQLException{
        List<Iventory> iventorys = new ArrayList();
        Connection con1 = DBConect.getConnection();
        String sql = "Select baoCao1.ProductId , ? as 'ngay', SUM(SoLuongXuat) as 'soLuongXuat' , SUM(SoLuongXuat * Gia) as 'doanhThu' from baoCao1\n" +
"join GHE on GHE.ProductId = baoCao1.ProductId\n" +
"where MONTH(?) = MONTH(Getdate()) and soLuongXuat > 0\n" +
"GROUP by baoCao1.ProductId \n" +
"ORDER by soLuongXuat asc";
        PreparedStatement statement = con1.prepareStatement(sql);
        statement.setString(1, date);
        statement.setString(2, date);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            Integer ProductId = rs.getInt("ProductId");
            String IEDate = rs.getString("ngay");
            Integer SoLuongXuat = rs.getInt("soLuongXuat");
            BigDecimal doanhThu = rs.getBigDecimal("doanhThu");
            
            Iventory il = new Iventory(ProductId, IEDate, SoLuongXuat, doanhThu);
            iventorys.add(il);
            
        }
        rs.close();
        statement.close();
        con1.close();
        return iventorys;
    }
    
    public boolean themBaoCao(Integer ProductId, String IEDate ,  Integer SoLuongXuat ) throws SQLException{
        Connection con1 = DBConect.getConnection();
        String sql = "INSERT INTO baoCao1 VALUES (?,?,?)";
        PreparedStatement statement = con1.prepareStatement(sql);
        statement.setInt(1, ProductId);
        statement.setString(2, IEDate);
        statement.setInt(3, SoLuongXuat);

        
        
        int index = statement.executeUpdate();
        con1.close();
        statement.close();
        if(index == 0){
            return false;
        }else{
            return true;
        }    
    }
}


