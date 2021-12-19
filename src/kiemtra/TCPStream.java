package kiemtra;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPStream {
  public static void main(String[] args) throws IOException {
    int port = 2344;
    String address = "1231231232";

    Socket socket = new Socket(address, port);
    DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
    DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());


    dataInputStream.close();
    dataOutputStream.close();
    socket.close();

  }
}
