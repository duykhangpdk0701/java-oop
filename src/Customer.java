import java.util.Scanner;

public class Customer extends Person {
    Time dayBooking;
    transient Scanner sc = new Scanner(System.in);

    public Customer() {
        super();
        dayBooking = new Time();
    }

    public Customer(String name, String sdt, String cmnd, String so_nha, String duong, String phuong, String quan,
            String tinh, Time dayBooking) {
        super(name, sdt, cmnd, so_nha, duong, phuong, quan, tinh);
        this.dayBooking = dayBooking;
    }

    public void setdayBooking() {
        System.out.println("Thoi diem dat phong : ");
        dayBooking.setTime();
    }

    public void setdayBooking(Time dayBooking) {
        this.dayBooking = dayBooking;
    }

    public Time getdayBooking() {
        return dayBooking;
    }

    public void nhap_thontin() {
        System.out.println("Nhap thong tin thue phong : ");
        setName();
        setSdt();
        setCmnd();
        setDiachi();
        setdayBooking();
    }

    public void Xuat_thong_tin() {
        System.out.printf("%-25s%-20s%-20s%-45s%-15s\n", name, sdt, cmnd, address, dayBooking);
    }
}
