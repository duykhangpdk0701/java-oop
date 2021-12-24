import java.io.Serializable;
import java.util.Scanner;

public class Person implements Serializable {
  String name;
  String sdt, cmnd;
  Address address;
  transient Scanner sc = new Scanner(System.in);

  public Person() {
    name = null;
    sdt = null;
    cmnd = null;
    address = new Address();
  }

  public Person(String name, String sdt, String cmnd, String so_nha, String duong, String phuong, String quan,
      String tinh) {
    this.name = name;
    this.sdt = sdt;
    this.cmnd = cmnd;
    address = new Address(so_nha, duong, phuong, quan, tinh);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCmnd() {
    return cmnd;
  }

  public void setCmnd(String cmnd) {
    this.cmnd = cmnd;
  }

  public String getSdt() {
    return sdt;
  }

  public void setSdt(String sdt) {
    this.sdt = sdt;
  }

  public void setName() {
    while (true) {

      System.out.print("Ho ten : ");
      this.name = sc.nextLine();
      if (!this.name.isEmpty()) {
        break;
      } else {
        System.out.println("xin vui long khong de trong!");
      }
    }
  }

  public boolean checkSdt(String sdt) {
    String regexStr = "^[0-9]{10,11}$";
    if (sdt.matches(regexStr)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean checkCmnd(String sdt) {
    String regexStr = "^[0-9]{12}|^[0-9]{9}$";
    if (sdt.matches(regexStr)) {
      return true;
    } else {
      return false;
    }
  }

  // ! them rang buoc 10 so vs sdt vs cmnd
  public void setSdt() {
    while (true) {
      System.out.print("sdt : ");
      String input = sc.nextLine();
      long inputValue = 0;
      try {
        inputValue = Long.parseLong(input);
        this.sdt = input;
        if (checkSdt(sdt)) {
          break;
        } else {
          System.out.println("ban hay nhap du 11 hoac 10 so nhe!");
        }

      } catch (NumberFormatException e) {
        System.out.println("ban nhap sai cu phap xin moi ban nhap lai!");
      }
    }
  }

  public void setCmnd() {
    while (true) {
      System.out.print("Cmnd : ");
      String input = sc.nextLine();
      long inputValue = 0;
      try {
        inputValue = Long.parseLong(input);
        this.cmnd = input;
        if (checkCmnd(cmnd)) {
          break;
        } else {
          System.out.println("ban hay nhap du 9 hoac 12 so nhe!");
        }
      } catch (NumberFormatException e) {
        System.out.println("ban nhap sai cu phap xin moi ban nhap lai!");
      }
    }
  }

  public void setDiachi() {
    address.nhap_thontin();
  }

  public void nhap_thontin() {
    System.out.println("Moi ban nhap thong tin : ");
    setName();
    setSdt();
    setCmnd();
    setDiachi();
  }

  public void xuatthongtin() {
    System.out.printf("%-25s%-20s%-20s%-45s\n", name, sdt, cmnd, address);
  }
}
