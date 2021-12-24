import java.io.IOException;
import java.util.Scanner;

public class Hoadon {
    int s = 0;
    Scanner sc = new Scanner(System.in);

    public Hoadon() {
        s = 0;
    }

    public void Xuat_hoa_don(List_phieudatphong arrs, List_rooms arrRoom, List_staff staff, Staff nv)
            throws IOException {
        int kt = 0;
        arrs.read();
        arrRoom.read();
        System.out.print("\nMoi ban nhap ten phong muon tra : ");
        String tenphong = sc.nextLine();
        for (int i = arrs.arrBooked.length - 1; i >= 0; i--) {
            if (arrs.arrBooked[i].tenphong.equalsIgnoreCase(tenphong)
                    && arrRoom.Timkiemphong(tenphong).booked == true) {
                System.out.print("\nNhap cmnd de xac nhan : ");
                String cmnd = sc.nextLine();
                if (arrs.arrBooked[i].customer.cmnd.equalsIgnoreCase(cmnd)) {
                    System.out.println("\n*------- -----------------------------------------------------*");
                    System.out.println("|                           HOA DON                           |");
                    System.out.println("|                                                             |");
                    System.out.printf("|%-40s%-20s |\n", " Khach hang : " + arrs.arrBooked[i].customer.name,
                            "cmnd: " + arrs.arrBooked[i].customer.cmnd);
                    System.out.printf("|%-60s |\n", " Dia chi : " + arrs.arrBooked[i].customer.address);
                    System.out.printf("|%-60s |\n", " Da dat phong : " + arrs.arrBooked[i].tenphong);
                    System.out.printf("|%-60s |\n", " Su dung cac dich vu : ");
                    System.out.printf("|%-20s%30s%10s |\n", " Ten dich vu", "Gia", "");
                    arrs.arrBooked[i].Xuat_thong_tin_dichvu();
                    s = arrs.arrBooked[i].Tongtien(arrRoom);
                    System.out.printf("|%-60s |\n", " Tong tien la : " + s + "000 d");
                    System.out.println("|                                                             |");
                    System.out.printf("|%-45s%-15s |\n", " Nhan vien dat phong : " + arrs.arrBooked[i].nv.name,
                            "Id : " + arrs.arrBooked[i].nv.id);
                    System.out.printf("|%-45s%-15s |\n", " Nhan vien tra phong : " + nv.name, "Id : " + nv.id);
                    arrRoom.Timkiemphong(arrs.arrBooked[i].tenphong).booked = false;
                    System.out.println("*----------------------------- -------------------------------*\n");
                    kt = 1;
                    staff.Tracking("Tra phong " + tenphong);
                    break;

                } else {
                    System.out.println("Cmnd khong trung khop !");
                }
            }
        }
        if (kt == 0) {
            System.out.println("Thong tin ko hop le !");

        }
        // for (Phieudatphong arr : arrs.arrBooked) {
        // if (arr.tenphong.equalsIgnoreCase(tenphong)) {
        // System.out.print("\nNhap cmnd de xac nhan : ");
        // String cmnd = sc.nextLine();
        // if (arr.customer.cmnd.equalsIgnoreCase(cmnd)) {
        // System.out.println("\n*-------
        // -----------------------------------------------------*");
        // System.out.println("| HOA DON |");
        // System.out.println("| |");
        // System.out.printf("|%-40s%-20s |\n", " Khach hang : " + arr.customer.name,
        // "cmnd: " + arr.customer.cmnd);
        // System.out.printf("|%-60s |\n", " Dia chi : " + arr.customer.address);
        // System.out.printf("|%-60s |\n", " Da dat phong : " + arr.tenphong);
        // System.out.printf("|%-60s |\n", " Su dung cac dich vu : ");
        // System.out.printf("|%-20s%30s%10s |\n", " Ten dich vu", "Gia", "");
        // arr.Xuat_thong_tin_dichvu();
        // s = arr.Tongtien(arrRoom);
        // System.out.printf("|%-60s |\n", " Tong tien la : " + s + "000 d");
        // System.out.println("| |");
        // System.out.printf("|%-45s%-15s |\n", " Nhan vien dat phong : " + arr.nv.name,
        // "Id : " + arr.nv.id);
        // System.out.printf("|%-45s%-15s |\n", " Nhan vien tra phong : " + nv.name, "Id
        // : " + nv.id);
        // arrRoom.Timkiemphong(arr.tenphong).booked = false;
        // System.out.println("*-----------------------------
        // -------------------------------*\n");
        // kt = 1;
        // } else {
        // System.out.println("Cmnd khong trung khop !");
        // }
        // break;
        // }
        // }
        arrRoom.write();
        arrs.write();
    }
}
