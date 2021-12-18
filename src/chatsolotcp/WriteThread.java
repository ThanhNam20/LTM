package chatsolotcp;
import com.google.gson.Gson;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class WriteThread implements Runnable{
  private Socket socket;

  public WriteThread(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    Scanner scanner = new Scanner(System.in);
    try {
      DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
      while(true){
        Gson gson = new Gson();
        String sms = scanner.nextLine();
        ClientRequest clientRequest = new ClientRequest(1, sms);
        String jsonData = gson.toJson(clientRequest);
        dos.writeUTF(jsonData);
        dos.flush();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
