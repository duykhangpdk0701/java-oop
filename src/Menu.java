import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Hotel hotel = new Hotel("Lotus Cental", 5,
            new Address("102", "Le Thi Hong Gam", "Nguyen Thai Binh", "1", "Tp.HCM"));;
    Scanner sc = new Scanner(System.in);

    public Menu() {
    }

    public void Login() throws IOException {
        hotel.read_All();
        while (true) {
            System.out.println();
            System.out.println("*------------------------------------------------------------*");
            System.out.println("|                         XIN CHAO                           |");
            System.out.println("|                                                            |");
            System.out.println("|     1. Xem thong tin khach san.                            |");
            System.out.println("|     2. Truy cap voi quyen nhan vien.                       |");
            System.out.println("|     3. Truy cap voi quyen quan ly.                         |");
            System.out.println("|     4. Thoat chuong trinh.                                 |");
            System.out.println("|                                                            |");
            System.out.println("*------------------------------------------------------------*");
            int x;
            while (true) {
                try {
                    System.out.print("\n\nLua chon cua ban : ");
                    x = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception ex) {
                    System.out.print("Cu phap ko chinh xac moi ban nhap lai !!! ");
                }
            }
            switch (x) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    hotel.xuatthongtin();
                    break;
                case 2:
                    int kt = 0;
                    System.out.println("\nNhap id va password cua ban ");
                    System.out.print("Id : ");
                    String id = sc.nextLine();
                    System.out.print("Pass : ");
                    String pass = sc.nextLine();
                    for (Staff nv : hotel.c.arrPerson) {
                        if (nv.id.equalsIgnoreCase(id) && nv.manager == false && nv.pass.equals(pass)) {
                            kt = 1;
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            menu(nv);
                            hotel.c.write();
                            break;
                        }
                    }
                    if (kt == 0) {
                        System.out.println("Sai thong tin dang nhap !");

                    }
                    break;
                case 3:
                    int kt1 = 0;
                    System.out.println("\nNhap id va password cua ban ");
                    System.out.print("Id : ");
                    String id1 = sc.nextLine();
                    System.out.print("Pass : ");
                    String pass1 = sc.nextLine();
                    for (Staff ql : hotel.c.arrPerson) {
                        if (ql.id.equalsIgnoreCase(id1) && ql.manager == true && ql.pass.equals(pass1)) {
                            kt1 = 1;
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            menu1(ql);
                            hotel.c.write();
                            break;
                        }
                    }
                    if (kt1 == 0) {
                        System.out.println("Sai thong tin dang nhap !");

                    }
                    break;

                case 4:
                    System.out.println("\nDa thoat chuong trinh\n\n");
                    break;
                default:
                    System.out.println("\nLua chon khong hop le !!!\n");
                    break;
            }
            if (x == 4) {
                break;
            }
        }
    }

    public void menu(Staff nv) throws IOException {
        hotel.c.Lich_su(nv);
        while (true) {
            System.out.println();
            System.out.println("*------------------------------------------------------------*");
            System.out.println("|                         XIN CHAO                           |");
            System.out.println("|                                                            |");
            System.out.println("|     1. Xem thong tin khach san                             |");
            System.out.println("|     2. Dat phong                                           |");
            System.out.println("|     3. Tra phong                                           |");
            System.out.println("|     4. Cai dat tai khoan                                   |");
            System.out.println("|     5. Dang xuat                                           |");
            System.out.println("|                                                            |");
            System.out.println("*------------------------------------------------------------*");
            int x;
            while (true) {
                try {
                    System.out.print("\n\nLua chon cua ban : ");
                    x = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception ex) {
                    System.out.print("Cu phap ko chinh xac moi ban nhap lai !!! ");
                }
            }
            switch (x) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    hotel.xuatthongtin();
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    hotel.d.Dat_phong(hotel.a, hotel.b, hotel.c, nv);
                    break;
                case 3:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    hotel.f.Xuat_hoa_don(hotel.d, hotel.a, hotel.c, nv);
                    break;
                case 4:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    taikhoan(nv);
                    break;

                case 5:
                    System.out.println("\nDang xuat thanh cong !\n\n");
                    break;
                default:
                    System.out.println("\nLua chon khong hop le !!!\n");
                    break;
            }
            if (x == 5) {
                break;
            }
        }
    }

    public void taikhoan(Staff nv) throws IOException {
        while (true) {
            System.out.println();
            System.out.println("*------------------------------------------------------------*");
            System.out.println("|                        TAI KHOAN                           |");
            System.out.println("|                                                            |");
            System.out.println("|     1. Xem thong tin ban than                              |");
            System.out.println("|     2. Sua thong tin                                       |");
            System.out.println("|     3. Xem luong                                           |");
            System.out.println("|     4. Thay doi password                                   |");
            System.out.println("|     5. Quay lai                                            |");
            System.out.println("|                                                            |");
            System.out.println("*------------------------------------------------------------*");
            int x;
            while (true) {
                try {
                    System.out.print("\n\nLua chon cua ban : ");
                    x = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception ex) {
                    System.out.print("Cu phap ko chinh xac moi ban nhap lai !!! ");
                }
            }
            switch (x) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    nv.Xuat_thong_tin_chi_tiet();
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    Change(nv);
                    break;
                case 3:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    hotel.c.Xem_luong(nv, hotel);
                    break;
                case 4:
                    nv.resetPass(hotel.c);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("\nLua chon khong hop le !!!\n");
                    break;
            }
            if (x == 5) {
                break;
            }
        }
    }

    public void Change(Staff nv) throws IOException {
        while (true) {
            System.out.println();
            System.out.println("*------------------------------------------------------------*");
            System.out.println("|                   SUA THONG TIN TAI KHOAN                  |");
            System.out.println("|                                                            |");
            System.out.println("|     1. Thay doi sdt                                        |");
            System.out.println("|     2. Thay doi dia chi                                    |");
            System.out.println("|     3. Quay lai                                            |");
            System.out.println("|                                                            |");
            System.out.println("*------------------------------------------------------------*");
            int x;
            while (true) {
                try {
                    System.out.print("\n\nLua chon cua ban : ");
                    x = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception ex) {
                    System.out.print("Cu phap ko chinh xac moi ban nhap lai !!! ");
                }
            }
            switch (x) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    nv.Xuat_thong_tin_chi_tiet();
                    System.out.println("Nhap sdt moi");
                    nv.setSdt();
                    hotel.c.Tracking("Thay doi sdt");
                    System.out.println("Da luu thay doi !");
                    hotel.c.write();
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    nv.Xuat_thong_tin_chi_tiet();
                    System.out.println("Nhap dia chi moi");
                    nv.setDiachi();
                    hotel.c.Tracking("Thay doi dia chi");
                    System.out.println("Da luu thay doi !");
                    hotel.c.write();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("\nLua chon khong hop le !!!\n");
                    break;
            }
            if (x == 3) {
                break;
            }
        }
    }

    public void menu1(Staff ql) throws IOException {
        hotel.c.Lich_su(ql);
        while (true) {
            System.out.println();
            System.out.println("*------------------------------------------------------------*");
            System.out.println("|                     XIN CHAO QUAN LY                       |");
            System.out.println("|                                                            |");
            System.out.println("|     1. Xem thong tin khach san                             |");
            System.out.println("|     2. Dat phong                                           |");
            System.out.println("|     3. Tra phong                                           |");
            System.out.println("|     4. Quan ly thong tin khach san                         |");
            System.out.println("|     5. Cai dat tai khoan                                   |");
            System.out.println("|     6. Dang xuat                                           |");
            System.out.println("|                                                            |");
            System.out.println("*------------------------------------------------------------*");
            int x;
            while (true) {
                try {
                    System.out.print("\n\nLua chon cua ban : ");
                    x = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception ex) {
                    System.out.print("Cu phap ko chinh xac moi ban nhap lai !!! ");
                }
            }
            switch (x) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    hotel.xuatthongtin();
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    hotel.d.Dat_phong(hotel.a, hotel.b, hotel.c, ql);
                    break;
                case 3:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    hotel.f.Xuat_hoa_don(hotel.d, hotel.a, hotel.c, ql);
                    break;
                case 4:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    menu2(ql);
                    break;
                case 5:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    taikhoan(ql);
                    break;

                case 6:
                    System.out.println("\nDang xuat thanh cong !\n\n");
                    break;
                default:
                    System.out.println("\nLua chon khong hop le !!!\n");
                    break;
            }
            if (x == 6) {
                break;
            }
        }
    }

    public void menu2(Staff ql) throws IOException {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        while (true) {
            System.out.println();
            System.out.println("*------------------------------------------------------------*");
            System.out.println("|                QUAN LY THONG TIN KHACH SAN                 |");
            System.out.println("|                                                            |");
            System.out.println("|     1. Quan ly thong tin phong                             |");
            System.out.println("|     2. Quan ly thong tin dich vu                           |");
            System.out.println("|     3. Quan ly thong tin nhan vien                         |");
            System.out.println("|     4. Quan ly thong tin khach hang                        |");
            System.out.println("|     5. Thong ke khach san                                  |");
            System.out.println("|     6. Xem lich su dang nhap                               |");
            System.out.println("|     7. Quay lai                                            |");
            System.out.println("|                                                            |");
            System.out.println("*------------------------------------------------------------*");
            int x;
            while (true) {
                try {
                    System.out.print("\n\nLua chon cua ban : ");
                    x = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception ex) {
                    System.out.print("Cu phap ko chinh xac moi ban nhap lai !!! ");
                }
            }
            switch (x) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    room();
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    dichvu();
                    break;
                case 3:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    staff();
                    break;
                case 4:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    hotel.d.Xuatdsphieu(hotel.a);
                    break;
                case 5:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    Thong_ke();
                    break;
                case 6:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    hotel.c.Xuat_login();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("\nLua chon khong hop le !!!\n");
                    break;
            }
            if (x == 7) {
                break;
            }
        }
    }

    public void room() throws IOException {
        while (true) {
            System.out.println();
            System.out.println("*------------------------------------------------------------*");
            System.out.println("|                   QUAN LY THONG TIN PHONG                  |");
            System.out.println("|                                                            |");
            System.out.println("|     1. Xuat danh sach phong                                |");
            System.out.println("|     2. Xuat danh sach phong trong                          |");
            System.out.println("|     3. Them phong                                          |");
            System.out.println("|     4. Xoa phong                                           |");
            System.out.println("|     5. Sua thong tin phong                                 |");
            System.out.println("|     6. Quay lai                                            |");
            System.out.println("|                                                            |");
            System.out.println("*------------------------------------------------------------*");
            int x;
            while (true) {
                try {
                    System.out.print("\n\nLua chon cua ban : ");
                    x = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception ex) {
                    System.out.print("Cu phap ko chinh xac moi ban nhap lai !!! ");
                }
            }
            switch (x) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    hotel.a.Xuatdsphong();
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    hotel.a.Xuatdsphongtrong();
                    break;
                case 3:
                    hotel.a.Them_room(hotel.c);
                    break;
                case 4:
                    hotel.a.Xoa_room(hotel.c);
                    break;
                case 5:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    room1();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("\nLua chon khong hop le !!!\n");
                    break;
            }
            if (x == 6) {
                break;
            }
        }
    }

    public void room1() throws IOException {
        while (true) {
            System.out.println();
            System.out.println("*------------------------------------------------------------*");
            System.out.println("|                     SUA THONG TIN PHONG                    |");
            System.out.println("|                                                            |");
            System.out.println("|     1. Thay doi ten phong                                  |");
            System.out.println("|     2. Thay doi loai phong                                 |");
            System.out.println("|     3. Thay doi so giuong                                  |");
            System.out.println("|     4. Thay doi so gia                                     |");
            System.out.println("|     5. Quay lai                                            |");
            System.out.println("|                                                            |");
            System.out.println("*------------------------------------------------------------*");
            int x;
            while (true) {
                try {
                    System.out.print("\n\nLua chon cua ban : ");
                    x = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception ex) {
                    System.out.print("Cu phap ko chinh xac moi ban nhap lai !!! ");
                }
            }
            switch (x) {
                case 1:
                    hotel.a.Suaten_phong(hotel.c);
                    break;
                case 2:
                    hotel.a.Sualoai_phong(hotel.c);
                    break;
                case 3:
                    hotel.a.Suasogiuong_phong(hotel.c);
                    break;
                case 4:
                    hotel.a.Suagia_phong(hotel.c);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("\nLua chon khong hop le !!!\n");
                    break;
            }
            if (x == 5) {
                break;
            }
        }
    }

    public void staff() throws IOException {
        while (true) {
            System.out.println();
            System.out.println("*------------------------------------------------------------*");
            System.out.println("|                 QUAN LY THONG TIN NHAN VIEN                |");
            System.out.println("|                                                            |");
            System.out.println("|     1. Xuat danh sach nhan vien                            |");
            System.out.println("|     2. Tim thong tin nhan vien                             |");
            System.out.println("|     3. Them nhan vien                                      |");
            System.out.println("|     4. Xoa nhan vien                                       |");
            System.out.println("|     5. Thang cap                                           |");
            System.out.println("|     6. Giang cap                                           |");
            System.out.println("|     7. Quay lai                                            |");
            System.out.println("|                                                            |");
            System.out.println("*------------------------------------------------------------*");
            int x;
            while (true) {
                try {
                    System.out.print("\n\nLua chon cua ban : ");
                    x = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception ex) {
                    System.out.print("Cu phap ko chinh xac moi ban nhap lai !!! ");
                }
            }
            switch (x) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    hotel.c.Xuat_ds_nv();
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    Tim_nv();
                    break;
                case 3:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    Them_nv();
                    break;
                case 4:
                    hotel.c.Xoa_nv_id();
                    break;
                case 5:
                    hotel.c.Thangcap_nv();
                    break;
                case 6:
                    hotel.c.Giangcap_nv();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("\nLua chon khong hop le !!!\n");
                    break;
            }
            if (x == 7) {
                break;
            }
        }
    }

    public void dichvu() throws IOException {
        while (true) {
            System.out.println();
            System.out.println("*------------------------------------------------------------*");
            System.out.println("|                 QUAN LY THONG TIN DICH VU                  |");
            System.out.println("|                                                            |");
            System.out.println("|     1. Xuat danh sach dich vu                              |");
            System.out.println("|     2. Them dich vu                                        |");
            System.out.println("|     3. Xoa dich vu                                         |");
            System.out.println("|     4. Sua thong tin dich vu                               |");
            System.out.println("|     5. Quay lai                                            |");
            System.out.println("|                                                            |");
            System.out.println("*------------------------------------------------------------*");
            int x;
            while (true) {
                try {
                    System.out.print("\n\nLua chon cua ban : ");
                    x = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception ex) {
                    System.out.print("Cu phap ko chinh xac moi ban nhap lai !!! ");
                }
            }
            switch (x) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    hotel.b.Xuatdsdichvu();
                    break;
                case 2:
                    hotel.b.Them_dv(hotel.c);
                    break;
                case 3:
                    hotel.b.Xoa_dv(hotel.c);
                    break;
                case 4:
                    dichvu1();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("\nLua chon khong hop le !!!\n");
                    break;
            }
            if (x == 5) {
                break;
            }
        }
    }

    public void dichvu1() throws IOException {
        while (true) {
            System.out.println();
            System.out.println("*------------------------------------------------------------*");
            System.out.println("|                    SUA THONG TIN DICH VU                   |");
            System.out.println("|                                                            |");
            System.out.println("|     1. Thay doi ten dich vu                                |");
            System.out.println("|     2. Thay doi so gia                                     |");
            System.out.println("|     3. Quay lai                                            |");
            System.out.println("|                                                            |");
            System.out.println("*------------------------------------------------------------*");
            int x;
            while (true) {
                try {
                    System.out.print("\n\nLua chon cua ban : ");
                    x = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception ex) {
                    System.out.print("Cu phap ko chinh xac moi ban nhap lai !!! ");
                }
            }
            switch (x) {
                case 1:
                    hotel.b.Suaten_dv(hotel.c);
                    break;
                case 2:
                    hotel.b.Suagia_dv(hotel.c);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("\nLua chon khong hop le !!!\n");
                    break;
            }
            if (x == 3) {
                break;
            }
        }
    }

    public void Tim_nv() throws IOException {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        while (true) {
            System.out.println();
            System.out.println("*------------------------------------------------------------*");
            System.out.println("|                  TIM THONG TIN NHAN VIEN                   |");
            System.out.println("|                                                            |");
            System.out.println("|     1. Tim bang id                                         |");
            System.out.println("|     2. Tim bang ten                                        |");
            System.out.println("|     3. Quay lai                                            |");
            System.out.println("|                                                            |");
            System.out.println("*------------------------------------------------------------*");
            int x;
            while (true) {
                try {
                    System.out.print("\n\nLua chon cua ban : ");
                    x = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception ex) {
                    System.out.print("Cu phap ko chinh xac moi ban nhap lai !!! ");
                }
            }
            switch (x) {
                case 1:
                    hotel.c.Tim_nv_id();
                    break;
                case 2:
                    hotel.c.Tim_nv_name();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("\nLua chon khong hop le !!!\n");
                    break;
            }
            if (x == 3) {
                break;
            }
        }
    }

    public void Them_nv() throws IOException {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        while (true) {
            System.out.println();
            System.out.println("*------------------------------------------------------------*");
            System.out.println("|                        THEM NHAN VIEN                      |");
            System.out.println("|                                                            |");
            System.out.println("|     1. Them quan ly                                        |");
            System.out.println("|     2. Them nhan vien                                      |");
            System.out.println("|     3. Quay lai                                            |");
            System.out.println("|                                                            |");
            System.out.println("*------------------------------------------------------------*");
            int x;
            while (true) {
                try {
                    System.out.print("\n\nLua chon cua ban : ");
                    x = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception ex) {
                    System.out.print("Cu phap ko chinh xac moi ban nhap lai !!! ");
                }
            }
            switch (x) {
                case 1:
                    System.out.println("Nhap thong tin quan ly  ");
                    hotel.c.Them_quanly();
                    break;
                case 2:
                    System.out.println("Nhap thong tin nhan vien  ");
                    hotel.c.Them_nv();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("\nLua chon khong hop le !!!\n");
                    break;
            }
            if (x == 3) {
                break;
            }
        }
    }

    public void Sua_dv() throws IOException {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        while (true) {
            System.out.println();
            System.out.println("*------------------------------------------------------------*");
            System.out.println("|                    SUA THONG TIN DUCH VU                   |");
            System.out.println("|                                                            |");
            System.out.println("|     1. Sua ten dich vu                                     |");
            System.out.println("|     2. Sua gia dich vu                                     |");
            System.out.println("|     3. Quay lai                                            |");
            System.out.println("|                                                            |");
            System.out.println("*------------------------------------------------------------*");
            int x;
            while (true) {
                try {
                    System.out.print("\n\nLua chon cua ban : ");
                    x = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception ex) {
                    System.out.print("Cu phap ko chinh xac moi ban nhap lai !!! ");
                }
            }
            switch (x) {
                case 1:
                    hotel.b.Suaten_dv(hotel.c);
                    break;
                case 2:
                    hotel.b.Suagia_dv(hotel.c);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("\nLua chon khong hop le !!!\n");
                    break;
            }
            if (x == 3) {
                break;
            }
        }
    }

    public void setup() throws IOException {
        hotel.a.setup();
        hotel.b.setup();
        hotel.c.setup();
        hotel.d.setup(hotel.a, hotel.b, hotel.c);
    }

    public void Thong_ke() throws IOException {
        int s, k;
        System.out.println("\n*--------------------------------------------------------------*");
        System.out.println("|                         THONG KE                             |");
        for (int i = 11; i <= 12; i++) {
            k = 0;
            System.out.println("|                                                              |");
            System.out.printf("| %-60s |\n", "Thang " + i + " :");
            for (Room room : hotel.a.arrRooms) {
                room.dem = 0;
            }
            for (Dichvu dv : hotel.b.arrs) {
                dv.dem = 0;
            }
            for (Phieudatphong phieu : hotel.d.arrBooked) {
                if (phieu.customer.dayBooking.getMonth() == i) {
                    hotel.a.Timkiemphong(phieu.tenphong).dem++;
                    for (Dichvu dv1 : phieu.arr_dichvu) {
                        hotel.b.Timkiemdichvu(dv1.tendichvu).dem++;
                        hotel.b.write();
                    }
                }
                hotel.a.write();
                hotel.b.write();
            }
            System.out.println("|                                                              |");
            System.out.printf("| %-20s%20s%20s |\n", "Ten phong", "So lan duoc dat", "Doanh thu");
            hotel.a.read();
            for (Room room : hotel.a.arrRooms) {
                s = room.gia * room.dem * 1000;
                k += s;
                System.out.printf("| %-30s%10d%19dd |\n", room.tenphong, room.dem, s);
            }
            System.out.println("|                                                              |");
            System.out.printf("| %-20s%20s%20s |\n", "Ten dich vu", "So lan duoc su dung", "Doanh thu");
            hotel.b.read();
            for (Dichvu dv : hotel.b.arrs) {
                s = dv.gia * dv.dem * 1000;
                k += s;
                System.out.printf("| %-30s%10d%19dd |\n", dv.tendichvu, dv.dem, s);
            }
            System.out.println("|                                                              |");
            System.out.printf("| %-60s |\n", "Tong doanh thu : " + k + "d");

        }
        System.out.println("|                                                              |");
        System.out.println("*--------------------------------------------------------------*\n");
    }
}