/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;

/**
 *
 * @author hodangquan
 */
public class Ghe {
    private Integer id;
    private Integer CategoryId;
    private String ten;
    private BigDecimal gia;
    private Integer soLuong;
    private Integer kichThuoc;
    private String xuatSu;
    private boolean khaDung;

    public Ghe() {
    }

    public Ghe(Integer id, Integer CategoryId, String ten, BigDecimal gia, Integer soLuong, Integer kichThuoc, String xuatSu, boolean khaDung) {
        this.id = id;
        this.CategoryId = CategoryId;
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
        this.kichThuoc = kichThuoc;
        this.xuatSu = xuatSu;
        this.khaDung = khaDung;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Integer CategoryId) {
        this.CategoryId = CategoryId;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(Integer kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getXuatSu() {
        return xuatSu;
    }

    public void setXuatSu(String xuatSu) {
        this.xuatSu = xuatSu;
    }

    public boolean isKhaDung() {
        return khaDung;
    }

    public void setKhaDung(boolean khaDung) {
        this.khaDung = khaDung;
    }
    
    
}
