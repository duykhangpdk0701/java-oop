import java.io.Serializable;
import java.util.Scanner;

public class Address implements Serializable {
    private String so_nha;
    private String duong;
    private String phuong;
    private String quan;
    private String tinh;
    transient Scanner sc = new Scanner(System.in);

    public Address() {
        so_nha = null;
        duong = null;
        phuong = null;
        quan = null;
        tinh = null;
    }

    public Address(String so_nha, String duong, String phuong, String quan, String tinh) {
        this.so_nha = so_nha;
        this.duong = duong;
        this.phuong = phuong;
        this.quan = quan;
        this.tinh = tinh;
    }

    public String getDuong() {
        return duong;
    }

    public void setDuong(String duong) {
        this.duong = duong;
    }

    public String getPhuong() {
        return phuong;
    }

    public void setPhuong(String phuong) {
        this.phuong = phuong;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public String getSo_nha() {
        return so_nha;
    }

    public void setSo_nha(String so_nha) {
        this.so_nha = so_nha;
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    public void setDuong() {
        System.out.print("Duong : ");
        duong = sc.nextLine();
    }

    public void setPhuong() {
        System.out.print("Phuong : ");
        phuong = sc.nextLine();
    }

    public void setQuan() {
        System.out.print("Quan : ");
        quan = sc.nextLine();
    }

    public void setSo_nha() {
        System.out.print("So nha : ");
        so_nha = sc.nextLine();
    }

    public void setTinh() {
        System.out.print("Tinh : ");
        tinh = sc.nextLine();
    }

    public void nhap_thontin() {
        System.out.println("Moi ban nhap dia chi :");
        setSo_nha();
        setDuong();
        setPhuong();
        setQuan();
        setTinh();
    }

    public String toString() {
        return so_nha + " " + duong + ",Phuong " + phuong + ",Quan " + quan + "," + tinh;
    }
}