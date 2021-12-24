import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class List_dichvu extends Filehandle {
    Dichvu[] arrs;
    private int n;
    transient Scanner sc = new Scanner(System.in);

    public List_dichvu() {
        arrs = null;
        n = 0;
    }

    public void read() throws IOException {
        ObjectInputStream oi = null;
        try {
            oi = new ObjectInputStream(new FileInputStream(file_serv));
            arrs = (Dichvu[]) oi.readObject();

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
            oo = new ObjectOutputStream(new FileOutputStream(file_serv));
            oo.writeObject(arrs);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            oo.close();
        }
    }

    public void setup() throws IOException {
        arrs = new Dichvu[8];
        arrs[0] = new Dichvu("Nha hang", 200);
        arrs[1] = new Dichvu("Bar", 200);
        arrs[2] = new Dichvu("Thue phuong tien", 500);
        arrs[3] = new Dichvu("Giat la", 50);
        arrs[4] = new Dichvu("Spa", 300);
        arrs[5] = new Dichvu("Fitness center", 200);
        arrs[6] = new Dichvu("Casino", 200);
        arrs[7] = new Dichvu("Trong tre", 200);
        write();
    }

    public void Nhapdsdichvu() throws IOException {
        while (true) {
            try {
                System.out.print("Nhap vao so luong dich vu : ");
                n = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception ex) {
                System.out.println("Cu phap ko chinh xac moi ban nhap lai !!! \n");
            }
        }
        arrs = new Dichvu[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin dich vu thu " + (i + 1));
            arrs[i] = new Dichvu();
            arrs[i].nhap_thontin();
        }
        write();
    }

    public void Xuatdsdichvu() throws IOException {
        read();
        System.out.println("\n*----------------------------------------------------*");
        System.out.println("|                  DANH SACH DICH VU                 |");
        System.out.println("|                                                    |");
        System.out.printf("| %-30s%20s |\n", " Ten dichvu", "Gia");
        for (Dichvu arr : arrs) {
            arr.xuatthongtin();
        }
        System.out.println("|                                                    |");
        System.out.println("*----------------------------------------------------*\n");
    }

    public Dichvu Timkiemdichvu(String a) throws IOException {
        read();
        for (Dichvu arr : arrs) {
            if (arr.tendichvu.equalsIgnoreCase(a))
                return arr;
        }
        return null;
    }

    public void Them_dv(List_staff staff) throws IOException {
        read();
        Dichvu dv = new Dichvu();
        dv.nhap_thontin();
        arrs = Arrays.copyOf(arrs, arrs.length + 1);
        arrs[arrs.length - 1] = dv;
        System.out.println("Them dich vu thanh cong");
        staff.Tracking("Them dich vu " + dv.tendichvu);
        write();
    }

    public void Xoa_dv(List_staff staff) throws IOException {
        read();
        System.out.print("Nhap ten dich vu can xoa : ");
        String a = sc.nextLine();
        int kt = 0;
        Dichvu[] arr = new Dichvu[arrs.length - 1];
        for (int i = 0; i <= arr.length; i++) {
            if (arrs[i].tendichvu.equalsIgnoreCase(a)) {
                staff.Tracking("Xoa dich vu " + arrs[i].tendichvu);
                for (int j = i; j < arrs.length - 1; j++) {
                    arr[i] = arrs[j + 1];
                    i++;
                }
                kt = 1;
                System.out.println("Dich vu da duoc xoa !");
                break;
            }
            arr[i] = arrs[i];
        }
        if (kt == 0) {
            System.out.println("Ko tim thay phong !");
        } else if (kt == 1) {
            arrs = new Dichvu[arr.length];
            arrs = arr;
        }
        write();
    }

    public void Suaten_dv(List_staff staff) throws IOException {
        read();
        System.out.print("Nhap ten dich vu muon sua : ");
        String a = sc.nextLine();
        System.out.print("Ten moi cua dich vu la : ");
        String b = sc.nextLine();
        int kt = 0;
        for (Dichvu dv : arrs) {
            if (dv.tendichvu.equalsIgnoreCase(a)) {
                dv.settendichvu(b);
                System.out.println("Sua thong tin thanh cong !");
                kt = 1;
                staff.Tracking("Thay doi ten dich vu " + a + " thanh " + b);
                break;
            }
        }
        if (kt == 0) {
            System.out.println("Ko tim thay dich vu !");
        }
        write();
    }

    public void Suagia_dv(List_staff staff) throws IOException {
        read();
        System.out.print("Nhap ten dich vu muon sua : ");
        String a = sc.nextLine();
        System.out.print("Gia moi cua dich vu la : ");
        int b = Integer.parseInt(sc.nextLine());
        int kt = 0;
        for (Dichvu dv : arrs) {
            if (dv.tendichvu.equalsIgnoreCase(a)) {
                dv.setGia(b);
                System.out.println("Sua thong tin thanh cong !");
                kt = 1;
                staff.Tracking("Thay doi gia cua phong " + a + " thanh " + b);
                break;
            }
        }
        if (kt == 0) {
            System.out.println("Ko tim thay dich vu !");
        }
        write();
    }
}
