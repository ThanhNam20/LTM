package chatsolotcp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ReadThread extends Thread{
  private Socket socket;

  public ReadThread(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      DataInputStream dis = new DataInputStream(socket.getInputStream());
      while(true) {
        String sms = dis.readUTF();
        System.out.println(sms);
        String sms2 = dis.readUTF();
        System.out.println(sms2);

//        Gson gson = new Gson();
//        Type type = new TypeToken<ArrayList<Topic>>(){}.getType();
//        ArrayList<Topic> topic = gson.fromJson(sms, type);
//        System.out.println(topic);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
