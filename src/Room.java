import java.io.Serializable;
import java.util.Scanner;

public class Room implements Serializable {
    String tenphong;
    String loai;
    int so_giuong, gia, dem;
    boolean booked = false;
    String boardPackage;
    transient Scanner sc = new Scanner(System.in);

    public Room() {
        tenphong = null;
        so_giuong = 0;
        gia = 0;
    }

    public Room(String tenphong, int so_giuong, int gia) {
        this.tenphong = tenphong;
        this.so_giuong = so_giuong;
        this.gia = gia;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public int getSo_giuong() {
        return so_giuong;
    }

    public void setSo_giuong(int so_giuong) {
        this.so_giuong = so_giuong;
    }

    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }

    public boolean checkTenPhong(String[] arrayOfRoomName) {

        for (String item : arrayOfRoomName) {
            if (this.tenphong.equalsIgnoreCase(item)) {
                return false;
            }
        }
        return true;
    }

    public void setTenphong(String[] arrayOfRoomName) {
        while (true) {
            System.out.print("Ten phong : ");
            this.tenphong = sc.nextLine();
            if (tenphong.isEmpty()) {
                System.out.println("xin vui long khong bo trong");
            } else if (!checkTenPhong(arrayOfRoomName)) {
                System.out.println("ten phong da bi trung xin vui long chon ten phong khac");
            } else {
                break;
            }
        }
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setSo_giuong() {
        while (true) {
            try {
                System.out.print("So giuong : ");
                this.so_giuong = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception ex) {
                System.out.println("Cu phap ko chinh xac moi ban nhap lai !!! \n");
            }
        }
    }

    public void setGia() {
        while (true) {
            try {
                System.out.print("Gia : ");
                this.gia = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception ex) {
                System.out.println("Cu phap ko chinh xac moi ban nhap lai !!! \n");
            }
        }
    }

    public void nhap_thontin(String[] arrayOfRoomName) {
        setTenphong(arrayOfRoomName);
        setSo_giuong();
        setGia();
    }

    public void xuatthongtin() {
        System.out.printf("| %-20s%-20s%-15s%-15s%15d000d%15s |\n", tenphong, loai, so_giuong, boardPackage, gia,
                booked == true ? "da dat" : "con trong");
    }

}
