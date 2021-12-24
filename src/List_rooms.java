import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class List_rooms extends Filehandle implements Serializable {
    Room[] arrRooms;
    private int n;
    transient Scanner sc = new Scanner(System.in);

    public List_rooms() {
        arrRooms = null;
        n = 0;
    }

    public void read() throws IOException {
        ObjectInputStream oi = null;
        try {
            oi = new ObjectInputStream(new FileInputStream(file_room));
            arrRooms = (Room[]) oi.readObject();

        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } finally {
            oi.close();
        }
    }

    public void write() throws IOException {
        ObjectOutputStream oo = null;
        try {
            oo = new ObjectOutputStream(new FileOutputStream(file_room));
            oo.writeObject(arrRooms);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            oo.close();
        }
    }

    public void setup() throws IOException {
        arrRooms = new Room[9];
        arrRooms[0] = new RegularRoom("101", 1, 200);
        arrRooms[1] = new RegularRoom("102", 2, 250);
        arrRooms[2] = new RegularRoom("103", 3, 300);
        arrRooms[3] = new RegularRoom("201", 1, 300);
        arrRooms[4] = new RegularRoom("202", 2, 350);
        arrRooms[5] = new RegularRoom("203", 3, 400);
        arrRooms[6] = new VipRoom("301", 1, 400);
        arrRooms[7] = new VipRoom("302", 2, 450);
        arrRooms[8] = new VipRoom("303", 3, 500);
        write();
    }

    public void Nhapdsphong() throws IOException {
        while (true) {
            try {
                System.out.print("Nhap vao so luong phong : ");
                n = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception ex) {
                System.out.println("Cu phap ko chinh xac moi ban nhap lai !!! \n");
            }
        }
        arrRooms = new Room[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin phong thu " + (i + 1));
            arrRooms[i] = new Room();
            arrRooms[i].nhap_thontin(ArrayOfRoomName(arrRooms));
        }
        write();
    }

    public void Xuatdsphong() throws IOException {
        read();
        System.out.println(
                "\n*----------------------------------------------------------------------------------------------------------*");
        System.out.println(
                "|                                           DANH SACH PHONG                                                |");
        System.out.println(
                "|                                                                                                          |");
        System.out.printf("| %-20s%-20s%-15s%-15s%19s%15s |\n", "Ten phong", "Loai", "So giuong", "Phuc vu an uong",
                "Gia", "Trang thai");
        for (Room room : arrRooms) {
            room.xuatthongtin();
        }
        System.out.println(
                "|                                                                                                          |");
        System.out.println(
                "*----------------------------------------------------------------------------------------------------------*\n");
    }

    public void Xuatdsphongtrong() throws IOException {
        read();
        System.out.println(
                "\n*----------------------------------------------------------------------------------------------------------*");
        System.out.println(
                "|                                           DANH SACH PHONG TRONG                                          |");
        System.out.println(
                "|                                                                                                          |");
        System.out.printf("| %-20s%-20s%-15s%-15s%19s%15s |\n", "Ten phong", "Loai", "So giuong", "Phuc vu an uong",
                "Gia", "Trang thai");
        for (Room room : arrRooms) {
            if (!room.booked)
                room.xuatthongtin();
        }
        System.out.println(
                "|                                                                                                          |");
        System.out.println(
                "*----------------------------------------------------------------------------------------------------------*\n");
    }

    public Room Timkiemphong(String a) throws IOException {
        read();
        for (Room room : arrRooms) {
            if (room.tenphong.equalsIgnoreCase(a)) {
                return room;
            }
        }
        return null;
    }

    public static String[] ArrayOfRoomName(Room[] arr) {
        String[] arr2 = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i].tenphong;
        }
        return arr2;
    }

    public void Them_room(List_staff staff) throws IOException {
        read();
        Room a = new Room();
        int x;
        while (true) {
            try {
                System.out.print(
                        "Nhap thong tin phong (Nhan 1 de them phong vip, nhan lon hon 2 de them phong thuong): ");
                x = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception ex) {
                System.out.println("Cu phap ko chinh xac moi ban nhap lai !!! \n");
            }
        }
        if (x == 1) {
            a = new VipRoom();
            a.nhap_thontin(ArrayOfRoomName(arrRooms));
            arrRooms = Arrays.copyOf(arrRooms, arrRooms.length + 1);
            arrRooms[arrRooms.length - 1] = a;
            staff.Tracking("Them phong vip " + a.tenphong);
            System.out.println("Them phong thanh cong !");
        } else if (x == 2) {
            a = new RegularRoom();
            a.nhap_thontin(ArrayOfRoomName(arrRooms));
            arrRooms = Arrays.copyOf(arrRooms, arrRooms.length + 1);
            arrRooms[arrRooms.length - 1] = a;
            staff.Tracking("Them phong thuong " + a.tenphong);
            System.out.println("Them phong thanh cong !");
        } else {
            System.out.println("Lua chon ko hop le !");
        }
        write();
    }

    public void Xoa_room(List_staff staff) throws IOException {
        read();
        System.out.print("Nhap ten phong can xoa : ");
        String a = sc.nextLine();
        int kt = 0;
        Room[] arr = new Room[arrRooms.length - 1];
        for (int i = 0; i <= arr.length; i++) {
            if (arrRooms[i].tenphong.equalsIgnoreCase(a)) {
                for (int j = i; j < arrRooms.length - 1; j++) {
                    arr[i] = arrRooms[j + 1];
                    i++;
                }
                kt = 1;
                staff.Tracking("Xoa phong " + a);
                System.out.println("Phong da duoc xoa !");
                break;
            }
            arr[i] = arrRooms[i];
        }
        if (kt == 0) {
            System.out.println("Ko tim thay phong !");
        } else if (kt == 1) {
            arrRooms = new Room[arr.length];
            arrRooms = arr;
        }
        write();
    }

    public void Suaten_phong(List_staff staff) throws IOException {
        read();
        System.out.print("Nhap ten phong muon sua : ");
        String a = sc.nextLine();
        System.out.print("Ten moi cua phong la : ");
        String b = sc.nextLine();
        int kt = 0;
        for (Room dv : arrRooms) {
            if (dv.tenphong.equalsIgnoreCase(a)) {
                dv.setTenphong(b);
                staff.Tracking("Thay doi ten phong " + a + " thanh " + b);
                System.out.println("Sua thong tin thanh cong !");
                kt = 1;
                break;
            }
        }
        if (kt == 0) {
            System.out.println("Ko tim thay phong !");
        }
        write();
    }

    public void Suasogiuong_phong(List_staff staff) throws IOException {
        read();
        System.out.print("Nhap ten phong muon sua : ");
        String a = sc.nextLine();
        int b;
        while (true) {
            try {
                System.out.print("So giuong cua phong la : ");
                b = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception ex) {
                System.out.print("Cu phap ko chinh xac moi ban nhap lai !!! ");
            }
        }
        int kt = 0;
        for (Room dv : arrRooms) {
            if (dv.tenphong.equalsIgnoreCase(a)) {
                dv.setSo_giuong(b);
                staff.Tracking("Thay doi so giuong cua phong " + a + " thanh " + b);
                System.out.println("Sua thong tin thanh cong !");
                kt = 1;
                break;
            }
        }
        if (kt == 0) {
            System.out.println("Ko tim thay phong !");
        }
        write();
    }

    public void Suagia_phong(List_staff staff) throws IOException {
        read();
        System.out.print("Nhap ten phong muon sua : ");
        String a = sc.nextLine();
        int b;
        while (true) {
            try {
                System.out.print("Gia moi cua phong la : ");
                b = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception ex) {
                System.out.print("Cu phap ko chinh xac moi ban nhap lai !!! ");
            }
        }
        int kt = 0;
        for (Room dv : arrRooms) {
            if (dv.tenphong.equalsIgnoreCase(a)) {
                dv.setGia(b);
                staff.Tracking("Thay doi gia cua phong " + a + " thanh " + b);
                System.out.println("Sua thong tin thanh cong !");
                kt = 1;
                break;
            }
        }
        if (kt == 0) {
            System.out.println("Ko tim thay phong !");
        }
        write();
    }

    public void Sualoai_phong(List_staff staff) throws IOException {
        read();
        System.out.print("Nhap ten phong muon sua : ");
        String a = sc.nextLine();
        int b;
        while (true) {
            try {
                System.out.print("Loai moi cua phong (Nhan 1 de sua thanh vip, nhan 2 de sua thanh thuong) ");
                b = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception ex) {
                System.out.print("Cu phap ko chinh xac moi ban nhap lai !!! ");
            }
        }
        int kt = 0;
        for (Room dv : arrRooms) {
            if (dv.tenphong.equalsIgnoreCase(a)) {
                switch (b) {
                    case 1:
                        dv.loai = "Vip";
                        dv.boardPackage = "full";
                        staff.Tracking("Thay doi phong " + dv.tenphong + " thanh phong vip");
                        break;
                    case 2:
                        dv.loai = "Thuong";
                        dv.boardPackage = "half";
                        staff.Tracking("Thay doi phong " + dv.tenphong + " thanh phong thuong");
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("\nLua chon khong hop le !!!\n");
                        break;
                }
                if (b == 5) {
                    break;
                }
                System.out.println("Sua thong tin thanh cong !");
                kt = 1;
                break;
            }
        }
        if (kt == 0) {
            System.out.println("Ko tim thay phong !");
        }
        write();
    }
}
