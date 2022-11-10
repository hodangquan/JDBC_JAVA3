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
public class Iventory {
    private Integer productId;
    private String date;
    private Integer soLuongXuat;
    private BigDecimal doanhThu ;

    public Iventory() {
    }

    public Iventory(Integer productId, String date, Integer soLuongXuat, BigDecimal doanhThu) {
        this.productId = productId;
        this.date = date;
        this.soLuongXuat = soLuongXuat;
        this.doanhThu = doanhThu;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getSoLuongXuat() {
        return soLuongXuat;
    }

    public void setSoLuongXuat(Integer soLuongXuat) {
        this.soLuongXuat = soLuongXuat;
    }

    public BigDecimal getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(BigDecimal doanhThu) {
        this.doanhThu = doanhThu;
    }

    

    
    
}
