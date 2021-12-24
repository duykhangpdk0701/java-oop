public class VipRoom extends Room {

  public VipRoom() {
    super();
    loai = "Vip";
    boardPackage = "full";
  }

  public VipRoom(String tenphong, int so_giuong, int gia) {
    super(tenphong, so_giuong, gia);
    loai = "Vip";
    boardPackage = "full";
  }

  @Override
  public void xuatthongtin() {
    // TODO Auto-generated method stub
    super.xuatthongtin();
  }
}
