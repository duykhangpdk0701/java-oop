import java.util.Scanner;
import java.util.Arrays;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class List_phieudatphong extends Filehandle {
    Phieudatphong[] arrBooked;
    transient Scanner sc = new Scanner(System.in);
    Phieudatphong a;

    public List_phieudatphong() {
        arrBooked = new Phieudatphong[0];
    }

    @Override
    public void read() throws IOException {
        ObjectInputStream oi = null;
        try {
            oi = new ObjectInputStream(new FileInputStream(file_customer));
            try {
                arrBooked = (Phieudatphong[]) oi.readObject();

            } catch (Exception e) {
                arrBooked = new Phieudatphong[0];
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } finally {
            oi.close();
        }
    }

    @Override
    public void write() throws IOException {
        ObjectOutputStream oo = null;
        try {
            oo = new ObjectOutputStream(new FileOutputStream(file_customer));
            oo.writeObject(arrBooked);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            oo.close();
        }
    }

    public void Dat_phong(List_rooms arrRoom, List_dichvu dichvu, List_staff staff, Staff nv) throws IOException {
        read();
        a = new Phieudatphong(arrRoom);
        a.Dat_phong(arrRoom, dichvu);
        a.nv = nv;
        arrBooked = Arrays.copyOf(arrBooked, arrBooked.length + 1);
        arrBooked[arrBooked.length - 1] = a;
        staff.Tracking("Dat phong " + a.tenphong);
        write();
    }

    public void Xuatdsphieu(List_rooms arrRoom) throws IOException {
        read();
        System.out.println(
                "\n*--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
        System.out.println(
                "|                                                                                                 DANH SACH KHACH HANG                                                                                               |");
        System.out.println(
                "|                                                                                                                                                                                                                    |");
        System.out.printf("| %-25s%-15s%-60s%-15s%-40s%-15s%-25s%15s |\n", "Ho ten", "Cmnd", "Dia chi", "Phong dat",
                "Dich vu su dung", "Thoi diem", "Nhan vien dat phong", "Id nhan vien");
        for (Phieudatphong booked : arrBooked) {
            booked.Xuat_thong_tin();
        }
        System.out.println(
                "|                                                                                                                                                                                                                    |");
        System.out.println(
                "*--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*\n");
    }

    public void setup(List_rooms a, List_dichvu b, List_staff c) throws IOException {
        arrBooked = new Phieudatphong[9];
        arrBooked[0] = new Phieudatphong(a, new Customer("Nguyen Van A", "0969696969", "123456789101", "27", "Au co",
                "1", "Tan Phu", "Tp.HCM", new Time(1, 11, 2020)), "101", b.arrs[3], b.arrs[5], c.arrPerson[1]);
        arrBooked[1] = new Phieudatphong(a, new Customer("Le Thi B", "0969696969", "123456789102", "25", "Au co", "1",
                "Tan Phu", "Tp.HCM", new Time(3, 11, 2020)), "102", b.arrs[1], b.arrs[2], c.arrPerson[2]);
        arrBooked[2] = new Phieudatphong(a, new Customer("Phung Duy C", "0969696969", "123456789103", "29", "Au co",
                "1", "Tan Phu", "Tp.HCM", new Time(4, 11, 2020)), "103", b.arrs[4], b.arrs[6], c.arrPerson[3]);
        arrBooked[3] = new Phieudatphong(a, new Customer("Phung Duy A", "0969696969", "123456789104", "29", "Au co",
                "1", "Tan Phu", "Tp.HCM", new Time(5, 11, 2020)), "201", b.arrs[4], b.arrs[6], c.arrPerson[1]);
        arrBooked[4] = new Phieudatphong(a, new Customer("Phung Duy K", "0969696969", "123456789105", "29", "Au co",
                "1", "Tan Phu", "Tp.HCM", new Time(6, 11, 2020)), "202", b.arrs[7], b.arrs[6], c.arrPerson[2]);
        arrBooked[5] = new Phieudatphong(a, new Customer("Nguyen Van B", "0969696969", "123456789106", "29", "Au co",
                "1", "Tan Phu", "Tp.HCM", new Time(7, 11, 2020)), "203", b.arrs[3], b.arrs[5], c.arrPerson[3]);
        arrBooked[6] = new Phieudatphong(a, new Customer("Huynh Lam Khanh Duyen", "0969696969", "123456789107", "29",
                "Au co", "1", "Tan Phu", "Tp.HCM", new Time(8, 11, 2020)), "301", b.arrs[1], b.arrs[5], c.arrPerson[3]);
        arrBooked[7] = new Phieudatphong(a, new Customer("Nguyen Van H", "0969696969", "123456789108", "29", "Au co",
                "1", "Tan Phu", "Tp.HCM", new Time(9, 11, 2020)), "302", b.arrs[4], b.arrs[6], c.arrPerson[2]);
        arrBooked[8] = new Phieudatphong(a, new Customer("Huynh Lam Khanh D", "0969696969", "123456789109", "29",
                "Au co", "1", "Tan Phu", "Tp.HCM", new Time(10, 11, 2020)), "303", b.arrs[2], b.arrs[5],
                c.arrPerson[1]);
        write();
    }
}