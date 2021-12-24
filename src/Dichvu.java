import java.io.Serializable;
import java.util.Scanner;

public class Dichvu implements Serializable {
    String tendichvu;
    int gia, dem;
    boolean booked = false;
    transient Scanner sc = new Scanner(System.in);

    public Dichvu() {
        tendichvu = null;
        gia = 0;
    }

    public Dichvu(String tendichvu, int gia) {
        this.tendichvu = tendichvu;
        this.gia = gia;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String gettendichvu() {
        return tendichvu;
    }

    public void settendichvu(String tendichvu) {
        this.tendichvu = tendichvu;
    }

    public void settendichvu() {
        System.out.print("Ten dich vu : ");
        this.tendichvu = sc.nextLine();
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

    public void nhap_thontin() {
        settendichvu();
        setGia();
    }

    public void xuatthongtin() {
        System.out.printf("|  %-30s%18dd |\n", tendichvu, gia * 1000);
    }
}
