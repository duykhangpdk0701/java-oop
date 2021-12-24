public class RegularRoom extends Room {

  public RegularRoom() {
    super();
    loai = "Thuong";
    boardPackage = "half";
  }

  public RegularRoom(String tenphong, int so_giuong, int gia) {
    super(tenphong, so_giuong, gia);
    loai = "Thuong";
    boardPackage = "half";
  }

  @Override
  public void xuatthongtin() {
    // TODO Auto-generated method stub
    super.xuatthongtin();
  }
}
