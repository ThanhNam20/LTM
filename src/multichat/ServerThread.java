package multichat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread extends Thread{
  private Socket socket;

  public ServerThread(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
      String data = dataInputStream.readUTF();
      System.out.println(data);
      for (Socket item :Server.socketArrayList) {
        DataOutputStream dataOutputStream = new DataOutputStream(item.getOutputStream());
        dataOutputStream.writeUTF(data);
        dataOutputStream.flush();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
