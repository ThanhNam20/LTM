package multichat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientWrite extends Thread{
  private Socket socket;

  public ClientWrite(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
      String data = dataInputStream.readUTF();
      System.out.println(data);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
