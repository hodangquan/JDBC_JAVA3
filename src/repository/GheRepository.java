/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import model.Ghe;
import java.sql.*;

/**
 *
 * @author hodangquan
 */
public class GheRepository {
    public List<Ghe> layDSGhes() throws  SQLException{
        List<Ghe> ghes = new ArrayList();
        Connection con1 = DBConect.getConnection();
        String sql = "SELECT ProductId , CategoryId , ProductName , Gia , SoLuong , KichThuoc , XuatSu , KhaDung FROM GHE ";
        PreparedStatement statement = con1.prepareStatement(sql);
        ResultSet rs = statement.executeQuery(); 
        while (rs.next()){
            Integer id = rs.getInt("ProductId");
            Integer CategoryId = rs.getInt("CategoryId");
            String ProductName = rs.getString("ProductName");
            BigDecimal Gia = rs.getBigDecimal("Gia");
            Integer SoLuong = rs.getInt("SoLuong");
            Integer KichThuoc = rs.getInt("KichThuoc");
            String XuatSu = rs.getString("XuatSu");
            boolean KhaDung = rs.getBoolean("KhaDung");
            
            Ghe ghe = new Ghe(id, CategoryId, ProductName, Gia, SoLuong, KichThuoc, XuatSu, KhaDung);
            ghes.add(ghe);
        }
        con1.close();
        rs.close();
        statement.close();
        return ghes;
    }
    public List<Ghe> layDSGhebyCategoryId(Integer id )throws SQLException{
        List<Ghe> ghes = new ArrayList();
        Connection con1 = DBConect.getConnection();
        String sql = "SELECT ProductId , CategoryId , ProductName , Gia , SoLuong , KichThuoc , XuatSu , KhaDung FROM GHE WHERE CategoryId = ?";
        PreparedStatement statement = con1.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery(); 
        while(rs.next()){
            Integer Productid = rs.getInt("ProductId");
            Integer CategoryId = rs.getInt("CategoryId");
            String ProductName = rs.getString("ProductName");
            BigDecimal Gia = rs.getBigDecimal("Gia");
            Integer SoLuong = rs.getInt("SoLuong");
            Integer KichThuoc = rs.getInt("KichThuoc");
            String XuatSu = rs.getString("XuatSu");
            boolean KhaDung = rs.getBoolean("KhaDung");
            
            Ghe ghe = new Ghe(Productid, CategoryId, ProductName, Gia, SoLuong, KichThuoc, XuatSu, KhaDung);
            ghes.add(ghe);
        }
        con1.close();
        rs.close();
        statement.close();
        return ghes;
    }
    
    public boolean nhap(int ProductId, int SoLuong) throws SQLException{
        Integer soLuongUpdate = null;
        List<Ghe> ghes = layDSGhes();
        for(Ghe ghe : ghes){
            if(ProductId == ghe.getId()){
                soLuongUpdate = ghe.getSoLuong() + SoLuong;
            }
        }
        Connection con1 = DBConect.getConnection();
        String sql = "UPDATE GHE SET SoLuong = ? WHERE ProductId = ?";
        PreparedStatement statement = con1.prepareStatement(sql);
        statement.setInt(1, soLuongUpdate);
        statement.setInt(2, ProductId);
        
        int index = statement.executeUpdate();
        con1.close();
        statement.close();
        if(index == 0){
            return false;
        }else{
            return true;
        }    
    }
    public boolean xuat(int ProductId, int SoLuong) throws SQLException{
        Integer soLuongUpdate = null;
        List<Ghe> ghes = layDSGhes();
        for(Ghe ghe : ghes){
            if(ProductId == ghe.getId()){
                soLuongUpdate = ghe.getSoLuong() - SoLuong;
            }
        }
        Connection con1 = DBConect.getConnection();
        String sql = "UPDATE GHE SET SoLuong = ? WHERE ProductId = ?";
        PreparedStatement statement = con1.prepareStatement(sql);
        statement.setInt(1, soLuongUpdate);
        statement.setInt(2, ProductId);
        
        int index = statement.executeUpdate();
        con1.close();
        statement.close();
        if(index == 0){
            return false;
        }else{
            return true;
        }    
    }
    public boolean them(Ghe ghe) throws SQLException{
        Connection con1 = DBConect.getConnection();
        String sql = "INSERT INTO GHE VALUES (?,?,?,?,?,?,1)";
        PreparedStatement statement = con1.prepareStatement(sql);
        statement.setInt(1, ghe.getCategoryId());
        statement.setString(2, ghe.getTen());
        statement.setBigDecimal(3, ghe.getGia());
        statement.setInt(4, ghe.getSoLuong());
        statement.setInt(5, ghe.getKichThuoc());
        statement.setString(6, ghe.getXuatSu());
        int index = statement.executeUpdate();
        
        con1.close();
        statement.close();
        
        if(index == 0){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean sua(Integer id ,Ghe ghe) throws SQLException{
        Connection con1 = DBConect.getConnection();
        String sql = "UPDATE GHE SET CategoryId = ? , ProductName = ? , Gia = ? , SoLuong = ? , KichThuoc = ? , XuatSu = ? WHERE ProductId = ?";
        PreparedStatement statement = con1.prepareStatement(sql);
        statement.setInt(1, ghe.getCategoryId());
        statement.setString(2, ghe.getTen());
        statement.setBigDecimal(3, ghe.getGia());
        statement.setInt(4, ghe.getSoLuong());
        statement.setInt(5, ghe.getKichThuoc());
        statement.setString(6, ghe.getXuatSu());
        statement.setInt(7, id);
        int index = statement.executeUpdate();
        
        con1.close();
        statement.close();
        
        if(index == 0){
            return false;
        }else{
            return true;
        }
    }
    public boolean xoa(Integer id) throws SQLException{
        Connection con1 = DBConect.getConnection();
        String sql = "UPDATE GHE SET KhaDung = 0 WHERE ProductId = ?";
        PreparedStatement statement = con1.prepareStatement(sql);
        statement.setInt(1, id);
        
        int index = statement.executeUpdate();
        
        con1.close();
        statement.close();
        
        if(index == 0){
            return false;
        }else{
            return true;
        }
    }
    public List<Ghe> searchbyTen(String name )throws SQLException{
        List<Ghe> ghes = new ArrayList();
        Connection con1 = DBConect.getConnection();
        String sql = "SELECT ProductId , CategoryId , ProductName , Gia , SoLuong , KichThuoc , XuatSu , KhaDung FROM GHE WHERE ProductName LIKE ? AND KhaDung = 1";
        PreparedStatement statement = con1.prepareStatement(sql);
        statement.setString(1, "%"+name+"%");
        ResultSet rs = statement.executeQuery(); 
        while(rs.next()){
            Integer productid = rs.getInt("ProductId");
            Integer CategoryId = rs.getInt("CategoryId");
            String ProductName = rs.getString("ProductName");
            BigDecimal Gia = rs.getBigDecimal("Gia");
            Integer SoLuong = rs.getInt("SoLuong");
            Integer KichThuoc = rs.getInt("KichThuoc");
            String XuatSu = rs.getString("XuatSu");
            boolean KhaDung = rs.getBoolean("KhaDung");
            
            Ghe ghe = new Ghe(productid, CategoryId, ProductName, Gia, SoLuong, KichThuoc, XuatSu, KhaDung);
            ghes.add(ghe);
            
        }
        con1.close();
        rs.close();
        statement.close();
        return ghes;
    }
    
    public List<Ghe> searchbyCategory(Integer id )throws SQLException{
        List<Ghe> ghes = new ArrayList();
        Connection con1 = DBConect.getConnection();
        String sql = "SELECT ProductId , CategoryId , ProductName , Gia , SoLuong , KichThuoc , XuatSu , KhaDung FROM GHE WHERE CategoryId LIKE ? AND KhaDung = 1";
        PreparedStatement statement = con1.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery(); 
        while(rs.next()){
            Integer productId = rs.getInt("ProductId");
            Integer CategoryId = rs.getInt("CategoryId");
            String ProductName = rs.getString("ProductName");
            BigDecimal Gia = rs.getBigDecimal("Gia");
            Integer SoLuong = rs.getInt("SoLuong");
            Integer KichThuoc = rs.getInt("KichThuoc");
            String XuatSu = rs.getString("XuatSu");
            boolean KhaDung = rs.getBoolean("KhaDung");
            
            Ghe ghe = new Ghe(productId, CategoryId, ProductName, Gia, SoLuong, KichThuoc, XuatSu, KhaDung);
            ghes.add(ghe);
            
        }
        con1.close();
        rs.close();
        statement.close();
        return ghes;
    }
}

