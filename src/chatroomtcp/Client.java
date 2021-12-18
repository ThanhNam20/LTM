package chatroomtcp;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
  private int port ;
  private String address;

  public Client(int port, String address) {
    this.port = port;
    this.address = address;
  }

  private void execute() throws IOException {
    Socket socket = new Socket(address, port);
    ReadClient readClient = new ReadClient(socket);
    readClient.start();
    WriteCLient writeCLient = new WriteCLient(socket);
    writeCLient.start();
  }

  public static void main(String[] args) throws IOException {
    Client client = new Client(1234, "localhost");
    client.execute();
  }

}

class ReadClient extends Thread {
    private Socket socket;

  public ReadClient(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    DataInputStream dis = null;
    try {
      dis = new DataInputStream(socket.getInputStream());
      while(true){
        String sms = dis.readUTF();
        System.out.println(sms);
      }

    } catch (IOException e) {
      e.printStackTrace();
      try {
        dis.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      try {
        socket.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }
}

class WriteCLient extends Thread {
  private Socket socket;

  public WriteCLient(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    DataOutputStream dos = null;
    Scanner scanner = null;

    try {
      dos = new DataOutputStream(socket.getOutputStream());
      scanner = new Scanner(System.in);
      while(true){
        String line = scanner.nextLine();
        dos.writeUTF(line);
        dos.flush();
      }
    } catch (IOException e) {
      try {
        dos.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      try {
        socket.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      e.printStackTrace();
    }
  }
}
