import java.io.IOException;
import java.util.Scanner;

public class Hotel {
    String name;
    int starLevel, doanhthu;
    Address address;
    List_rooms a = new List_rooms();
    List_dichvu b = new List_dichvu();
    List_staff c = new List_staff();

    List_phieudatphong d = new List_phieudatphong();
    Hoadon f = new Hoadon();
    Scanner sc = new Scanner(System.in);

    public Hotel() {
        name = null;
        starLevel = 0;
        address = new Address();
    }

    public Hotel(String name, int starLevel, Address address) {
        this.name = name;
        this.starLevel = starLevel;
        this.address = address;
        try {
            c.setup();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStarLevel(int starLevel) {
        this.starLevel = starLevel;
    }

    public int getStarLevel() {
        return starLevel;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setTenkhachsan() {
        System.out.print("Ten khach san la : ");
        this.name = sc.nextLine();
    }

    public void setLoai() {
        while (true) {
            try {
                System.out.print("Loai : ");
                this.starLevel = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception ex) {
                System.out.println("Cu phap ko chinh xac moi ban nhap lai !!! \n");
            }
        }
    }

    public void setDiachi() {
        address.nhap_thontin();
    }

    public void nhap_thontin() {
        setTenkhachsan();
        setLoai();
        setDiachi();
    }

    public void xuatthongtin() {
        System.out.println("\n*-----------------------------------------------------------------------------*");
        System.out.println("|                             THONG TIN KHACH SAN                             |");
        System.out.println("|                                                                             |");
        System.out.printf("|%-77s|\n", "  Khach san : " + name);
        System.out.printf("|%-77s|\n", "  La 1 khach san dat chat luong " + starLevel + " sao");
        System.out.printf("|%-77s|\n", "  Nam o dia chi : " + address);
        System.out.println("|                                                                             |");
        System.out.println("*-----------------------------------------------------------------------------*\n");
    }

    public int getDoanhthu(int thang) throws IOException {
        int s, k = 0;
        for (Room room : a.arrRooms) {
            room.dem = 0;
        }
        for (Dichvu dv : b.arrs) {
            dv.dem = 0;
        }
        for (Phieudatphong phieu : d.arrBooked) {
            if (phieu.customer.dayBooking.getMonth() == thang) {
                a.Timkiemphong(phieu.tenphong).dem++;
                for (Dichvu dv1 : phieu.arr_dichvu) {
                    b.Timkiemdichvu(dv1.tendichvu).dem++;
                }
            }
            a.write();
            b.write();
        }
        for (Room room : a.arrRooms) {
            s = room.gia * room.dem * 1000;
            k += s;
            for (Dichvu dv : b.arrs) {
                s = dv.gia * dv.dem * 1000;
                k += s;
            }
        }
        return k;
    }

    public void read_All() throws IOException {
        a.read();
        b.read();
        c.read();
        d.read();
        c.read1();
    }
}
