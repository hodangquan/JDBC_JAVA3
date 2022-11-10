/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.util.List;
import model.Ghe;
import repository.GheRepository;
import java.sql.*;

/**
 *
 * @author hodangquan
 */
public class GheService {

    private GheRepository gheRepository;

    public GheService() {
        gheRepository = new GheRepository();
    }

    public List<Ghe> layAllXeDaps() {
        try {
            return gheRepository.layDSGhes();
        } catch (Exception e) {
        }
        return null;
    }

    public List<Ghe> layDSXeDapByCategory(Integer id) throws SQLException {
        return gheRepository.layDSGhebyCategoryId(id);
    }

    public boolean nhap(int ProductId, int SoLuong) throws SQLException {
        return gheRepository.nhap(ProductId, SoLuong);
    }

    public boolean xuat(int ProductId, int SoLuong) throws SQLException {
        return gheRepository.xuat(ProductId, SoLuong);
    }

    public boolean checkSL(int ProductId, int SoLuong) throws SQLException {
        List<Ghe> ghes = gheRepository.layDSGhes();
        for (Ghe ghe : ghes) {
            if (ghe.getId() == ProductId) {
                if (ghe.getSoLuong() < SoLuong) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean them(Ghe ghe) throws SQLException {
        return gheRepository.them(ghe);
    }

    public boolean sua(Integer id, Ghe ghe) throws SQLException {
        return gheRepository.sua(id, ghe);
    }

    public boolean xoa(Integer id) throws SQLException {
        return gheRepository.xoa(id);
    }

    public List<Ghe> searchbyCategory(Integer id) throws SQLException {
        return gheRepository.searchbyCategory(id);
    }

    public List<Ghe> searchbyTen(String ten) throws SQLException {
        return gheRepository.searchbyTen(ten);
    }

    public Integer themTTUpdate(Integer Id) {
        return Id;
    }


}
