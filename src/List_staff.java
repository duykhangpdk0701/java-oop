import java.util.Scanner;
import java.util.Arrays;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class List_staff extends Filehandle {
    int n;
    Staff[] arrPerson;
    Staff[] arrLogin = new Staff[1];

    transient Scanner sc = new Scanner(System.in);

    public List_staff() {
        n = 0;
        arrPerson = null;
    }

    @Override
    public void read() throws IOException {
        ObjectInputStream oi = null;
        try {
            oi = new ObjectInputStream(new FileInputStream(file_staff));
            arrPerson = (Staff[]) oi.readObject();

        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } finally {
            oi.close();
        }
    }

    @Override
    public void write() throws IOException {
        ObjectOutputStream oo = null;
        try {
            oo = new ObjectOutputStream(new FileOutputStream(file_staff));
            oo.writeObject(arrPerson);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            oo.close();
        }
    }

    public void read1() throws IOException {
        ObjectInputStream oi = null;
        try {
            oi = new ObjectInputStream(new FileInputStream(file_login));
            arrLogin = (Staff[]) oi.readObject();

        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } finally {
            oi.close();
        }
    }

    public void write1() throws IOException {
        ObjectOutputStream oo = null;
        try {
            oo = new ObjectOutputStream(new FileOutputStream(file_login));
            oo.writeObject(arrLogin);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            oo.close();
        }
    }

    public void Nhap_ds_nv() throws IOException {
        while (true) {
            try {
                System.out.print("Nhap so luong nhan vien : ");
                n = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception ex) {
                System.out.println("Cu phap ko chinh xac moi ban nhap lai !!! \n");
            }
        }
        arrPerson = new Staff[n];
        for (int i = 0; i < n; i++) {
            int x;
            while (true) {
                try {
                    System.out.print("Nhap thong tin nhan vien thu " + (i + 1)
                            + " (Nhan  nho hon 1 de them quan ly, nhan lon hon 2 de them nhan vien) : ");
                    x = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception ex) {
                    System.out.println("Cu phap ko chinh xac moi ban nhap lai !!! \n");
                }
            }
            if (x <= 1) {
                arrPerson[i] = new Manager();
                arrPerson[i].Nhapthongtin(shortArr(arrPerson));
            } else if (x >= 2) {
                arrPerson[i] = new Service_staff();
                arrPerson[i].Nhapthongtin(shortArr(arrPerson));
            }
        }
        write();
    }

    public void Xuat_ds_nv() throws IOException {
        read();
        System.out.println(
                "\n*--------------------------------------------------------------------------------------------------------------------*");
        System.out.println(
                "|                                              DANH SACH NHAN VIEN                                                   |");
        System.out.println(
                "|                                                                                                                    |");
        System.out.printf("| %-15s%-15s%-25s%-25s%-15s%19s |\n", "Chuc vu", "Id", "Ho ten", "Cong viec", "Ngay vao lam",
                "Luong");
        for (int i = 0; i < arrPerson.length; i++) {
            arrPerson[i].Xuat_thong_tin();
        }
        System.out.println(
                "|                                                                                                                    |");
        System.out.println(
                "*--------------------------------------------------------------------------------------------------------------------*\n");
    }

    public void Tim_nv_name() throws IOException {
        read();
        System.out.print("Nhap ten nhan vien ban can tim : ");
        String name = sc.nextLine();
        int kt = 0;
        for (int i = 0; i < arrPerson.length; i++) {
            if (arrPerson[i].getName().equalsIgnoreCase(name)) {
                kt = 1;
            }
        }
        if (kt == 1) {
            System.out.println("\n*------------------------------------------------------------*");
            System.out.println("|                   THONG TIN NHAN VIEN                      |");
            for (int i = 0; i < arrPerson.length; i++) {
                if (arrPerson[i].getName().equalsIgnoreCase(name)) {
                    arrPerson[i].Xuat_thong_tin_chi_tiet();
                }
            }
            System.out.println("*------------------------------------------------------------*\n");
        } else if (kt == 0) {
            System.out.println("Khong tim thay nhan vien !");
        }
    }

    public boolean timNv(String id) {
        for (Staff person : arrPerson) {
            if (person.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public void Tim_nv_id() throws IOException {
        read();
        System.out.print("Nhap id nhan vien ban can tim : ");
        String id = sc.nextLine();
        int kt = 0;
        for (int i = 0; i < arrPerson.length; i++) {
            if (arrPerson[i].getId().equalsIgnoreCase(id)) {
                kt = 1;
            }
        }
        if (kt == 1) {
            for (int i = 0; i < arrPerson.length; i++) {
                if (arrPerson[i].getId().equalsIgnoreCase(id)) {
                    arrPerson[i].Xuat_thong_tin_chi_tiet();
                }
            }
        } else if (kt == 0) {
            System.out.println("Khong tim thay nhan vien !");
        }
    }

    public static String[] shortArr(Staff[] arr) {
        String[] arr2 = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i].id;
        }
        return arr2;
    }

    public void Them_nv() throws IOException {
        read();
        Staff nv = new Service_staff();
        nv.Nhapthongtin(shortArr(arrPerson));
        arrPerson = Arrays.copyOf(arrPerson, arrPerson.length + 1);
        arrPerson[arrPerson.length - 1] = nv;
        Tracking("Them nhan vien " + nv.name);
        write();
    }

    public void Them_quanly() throws IOException {
        read();
        Staff nv = new Manager();
        nv.Nhapthongtin(shortArr(arrPerson));
        arrPerson = Arrays.copyOf(arrPerson, arrPerson.length + 1);
        arrPerson[arrPerson.length - 1] = nv;
        Tracking("Them quan ly " + nv.name);
        write();
    }

    public void Xoa_nv_id() throws IOException {
        read();
        System.out.print("Id nhan vien can xoa : ");
        String a = sc.nextLine();
        int kt = 0;
        Staff[] arr = new Staff[arrPerson.length - 1];
        for (int i = 0; i <= arr.length; i++) {
            if (arrPerson[i].id.equalsIgnoreCase(a)) {
                Tracking("Xoa nhan vien " + arrPerson[i].name);
                for (int j = i; j < arrPerson.length - 1; j++) {
                    arr[i] = arrPerson[j + 1];
                    i++;
                }
                kt = 1;
                System.out.println("Nhan vien da duoc xoa !");
                break;
            }
            arr[i] = arrPerson[i];
        }
        if (kt == 0) {
            System.out.println("Ko tim thay nhan vien !");
        } else if (kt == 1) {
            arrPerson = new Staff[arr.length];
            arrPerson = arr;
        }
        write();
    }

    public void setup() throws IOException {
        arrPerson = new Staff[7];
        arrPerson[0] = new Manager("Phung Duy Khang", "0793607376", "241826875", "07", "tan quy", "tan quy",
                "Tan Phu", "Tp.HCM", "3119560029", "pdk073101", new Time(1, 11, 2021), 50000);
        arrPerson[1] = new Manager("Ngo Thanh Hiep", "0123456789", "123456789", "08", "tan quy",
                "Tan Phu", "Tan Phu", "Tp.HCM", "3120410166", "12345", new Time(1, 11, 2021), 30000);
        arrPerson[2] = new Manager("Ho Nhat Minh", "0123456788", "0123456788", "25/27", "Son Ky", "Son Ky",
                "Tan Phu", "Tp.HCM", "3120410319", "12345", new Time(1, 11, 2021), 30000);
        arrPerson[3] = new Manager("Diep Bao Thanh Phong", "0123456787", "12345677", "25/27", "Son Ky",
                "Son Ky", "Tan Phu", "Tp.HCM", "3119410304", "12345", new Time(1, 11, 2021), 30000);
        arrPerson[4] = new Manager("Vuong Truong Chung", "0123456785", "12345677", "25/27", "Son Ky",
                "Son Ky", "Tan Phu", "Tp.HCM", "3120410068", "12345", new Time(1, 11, 2021), 30000);
        arrPerson[5] = new Service_staff("Khang clone", "0123456786", "12345677", "25/27", "Son Ky",
                "Son Ky", "Tan Phu", "Tp.HCM", "3119560002", "pdk073101", new Time(1, 11, 2021), 30000, "Tiep Tan");
        arrPerson[6] = new Service_staff("staff AI", "0123456785", "12345676", "25/27", "Son Ky",
                "Son Ky", "Tan Phu", "Tp.HCM", "3119560001", "12345", new Time(1, 11, 2021), 30000, "Tiep Tan");
        write();
    }

    public void Giangcap_nv() throws IOException {
        read();
        System.out.print("Nhap id nhan vien muon giang cap : ");
        String a = sc.nextLine();
        int kt = 0;
        for (Staff dv : arrPerson) {
            if (dv.id.equalsIgnoreCase(a)) {
                if (dv instanceof Manager) {
                    dv.manager = false;
                    System.out.print("Cong viec moi : ");
                    dv.posision = sc.nextLine();
                    dv.chucvu = "Nhan vien";
                    System.out.println("Sua thong tin thanh cong !");
                    kt = 1;
                    Tracking("Giang cap nhan vien " + dv.name);
                    break;
                } else {
                    System.out.println("Da la nhan vien khong the giang cap !");
                }
            }
        }
        if (kt == 0) {
            System.out.println("Ko tim thay nhan vien !");
        }
        write();
    }

    public void Thangcap_nv() throws IOException {
        read();
        System.out.print("Nhap id nhan vien muon thang cap : ");
        String a = sc.nextLine();
        int kt = 0;
        for (Staff dv : arrPerson) {
            if (dv.id.equalsIgnoreCase(a)) {
                if (dv instanceof Service_staff) {
                    dv.manager = true;
                    dv.chucvu = "Quan ly";
                    dv.posision = "Quan ly khach san";
                    System.out.println("Sua thong tin thanh cong !");
                    kt = 1;
                    Tracking("Thang cap nhan vien " + dv.name);
                    break;
                } else {
                    System.out.println("Da la quan lyn khong the thang cap !");
                }
            }
        }
        if (kt == 0) {
            System.out.println("Ko tim thay nhan vien !");
        }
        write();
    }

    public void Xem_luong(Staff nv, Hotel hotel) throws IOException {
        System.out.println("\n*------------------------------------------*");
        System.out.println("|               LUONG CUA BAN              |");
        System.out.println("|                                          |");
        for (Staff staff : arrPerson) {
            if (staff == nv) {
                for (int i = nv.dayBegin.getMonth(); i <= 12; i++) {
                    System.out.printf("| %-40s |\n", "Thang " + i + " : " + nv.tinh_luong(i, hotel) * 1000 + "d");
                }
            }
        }
        System.out.println("|                                          |");
        System.out.println("*------------------------------------------*\n");
    }

    public void Lich_su(Staff nv) throws IOException {
        arrLogin[0] = arrPerson[0];
        write1();
        read1();
        nv.thaotac = "";
        arrLogin = Arrays.copyOf(arrLogin, arrLogin.length + 1);
        arrLogin[arrLogin.length - 1] = nv;
        write1();
    }

    public void Tracking(String a) throws IOException {
        arrLogin[arrLogin.length - 1].thaotac += a + ",";
        write1();
    }

    public void Xuat_login() throws IOException {
        read1();
        System.out.println(
                "\n*--------------------------------------------------------------------------------------------------------------------------*");
        System.out.println(
                "|                                                      LICH SU DANG NHAP                                                   |");
        System.out.println(
                "|                                                                                                                          |");
        System.out.printf("| %-30s%-30s%-60s |\n", "Id", "Ten nhan vien", "Cac hanh dong");
        for (Staff staff : arrLogin) {
            System.out.printf("| %-30s%-30s%-60s |\n", staff.id, staff.name, staff.thaotac);
        }
        System.out.println(
                "|                                                                                                                          |");
        System.out.println(
                "*--------------------------------------------------------------------------------------------------------------------------*\n");
    }
}
