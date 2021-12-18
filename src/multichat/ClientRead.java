package multichat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientRead extends Thread{
  private Socket socket;

  public ClientRead(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
      Scanner scanner = new Scanner(System.in);
      String data = scanner.nextLine();
      dataOutputStream.writeUTF(data);
      dataOutputStream.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
