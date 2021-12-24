import java.io.IOException;

abstract public class Filehandle {
    final static String file_room = "./list_room.txt";
    final static String file_serv = "./list_dichvu.txt";
    final static String file_staff = "./list_staff.txt";
    final static String file_login = "./login.txt";
    final static String file_customer = "./list_customer.txt";

    public abstract void read() throws Exception;

    public abstract void write() throws IOException;
}