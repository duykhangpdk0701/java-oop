import java.io.IOException;

public interface Filehandle {
    final static String file_room = "./list_room.txt";
    final static String file_serv = "./list_dichvu.txt";
    final static String file_staff = "./list_staff.txt";
    final static String file_login = "./login.txt";
    final static String file_customer = "./list_customer.txt";

    public void read() throws Exception;

    public void write() throws IOException;
}