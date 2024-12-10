/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChuKhanhLinh;

/**
 *
 * @author LinhNhi
 */
public class SanPham {
    String ma,ten;
    int sl;
    float dg;

    public SanPham(String ma, String ten, int sl, float dg) {
        this.ma = ma;
        this.ten = ten;
        this.sl = sl;
        this.dg = dg;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public float getDg() {
        return dg;
    }

    public void setDg(float dg) {
        this.dg = dg;
    }
    
}

