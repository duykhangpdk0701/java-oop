import java.util.Scanner;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

public class Phieudatphong implements Serializable {
    List_rooms arrRoom;
    Customer customer;
    String tenphong, tendichvu;
    Staff nv = new Staff();
    Dichvu[] arr_dichvu = new Dichvu[0];;
    int s = 0, x, n = 0;
    transient Scanner sc = new Scanner(System.in);

    public Phieudatphong(List_rooms arrRoom) {
        this.arrRoom = arrRoom;
        customer = new Customer();
        tenphong = null;
        tendichvu = null;
    }

    public Phieudatphong(List_rooms arrRoom, Customer customer, String tenphong, Dichvu a, Dichvu b, Staff nv) {
        this.customer = customer;
        this.tenphong = tenphong;
        this.nv = nv;
        arr_dichvu = new Dichvu[2];
        arr_dichvu[0] = a;
        arr_dichvu[1] = b;
        try {
            arrRoom.Timkiemphong(tenphong).booked = true;
            arrRoom.write();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ThongtinKhachhang() {
        customer.nhap_thontin();
    }

    public void Dat_phong(List_rooms arrRoom, List_dichvu dichvu) throws IOException {
        boolean kt = false;
        arrRoom.Xuatdsphong();
        while (true) {
            System.out.print("Moi ban chon phong : ");
            tenphong = sc.nextLine();
            for (int i = 0; i < arrRoom.arrRooms.length; i++) {
                if (arrRoom.arrRooms[i].tenphong.equalsIgnoreCase(tenphong) && !arrRoom.arrRooms[i].booked) {
                    arrRoom.arrRooms[i].booked = true;
                    arrRoom.write();
                    kt = true;
                    ThongtinKhachhang();
                    Su_dung_dichvu(dichvu);
                    System.out.println("\nDat phong thanh cong !");
                    break;
                }
            }
            if (!kt) {
                System.out.println("Phong khong hop le moi ban nhap lai !");
            } else {
                break;
            }
        }
        this.arrRoom = arrRoom;
    }

    public void Su_dung_dichvu(List_dichvu dichvu) throws IOException {
        boolean kt = false;
        dichvu.Xuatdsdichvu();
        System.out.print("Moi ban chon dich vu : ");
        tendichvu = sc.nextLine();
        while (!tendichvu.isEmpty()) {
            for (Dichvu arr : dichvu.arrs) {
                if (arr.tendichvu.equalsIgnoreCase(tendichvu)) {
                    arr_dichvu = Arrays.copyOf(arr_dichvu, n + 1);
                    arr_dichvu[n] = arr;
                    kt = true;
                    n++;
                }
            }
            if (!kt) {
                System.out.println("Ten dich vu khong dung !");
            }
            sc.nextLine();
            System.out.print("Moi ban chon tiep dich vu : ");
            tendichvu = sc.nextLine();
        }
    }

    public int Tongtien(List_rooms aRooms) throws IOException {
        for (Dichvu dv : arr_dichvu) {
            s += dv.gia;
        }
        s += aRooms.Timkiemphong(tenphong).gia;
        return s;
    }

    public void Xuat_thong_tin_dichvu() {
        for (Dichvu arr : arr_dichvu) {
            arr.xuatthongtin();
        }
    }

    public void Xuat_thong_tin_khachhang() {
        customer.Xuat_thong_tin();
    }

    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }

    public void Xuat_thong_tin() {
        String a = "";
        for (int i = 0; i < arr_dichvu.length; i++) {
            if (i == arr_dichvu.length - 1) {
                a += arr_dichvu[i].tendichvu;
            } else {
                a += arr_dichvu[i].tendichvu + ",";
            }
        }
        System.out.printf("| %-25s%-15s%-60s%-15s%-40s%-15s%-25s%15s |\n", customer.name, customer.cmnd,
                customer.address, tenphong, a, customer.dayBooking, nv.name, nv.id);
    }
}
