package calculator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
  private int port;
  private String address;

  public Client(int port, String address) {
    this.port = port;
    this.address = address;
  }

  public void execute() throws IOException {
    Socket socket = null;
    DataInputStream dataInputStream = null;
    DataOutputStream dataOutputStream = null;
    try {
      socket = new Socket(address, port);
      System.out.println("Client is Connect");
      dataInputStream = new DataInputStream(socket.getInputStream());
      dataOutputStream = new DataOutputStream(socket.getOutputStream());

      while(true){
//        System.out.println("1.Add");
//        System.out.println("2.Minus");
//        System.out.println("3.Multiply");
//        System.out.println("4.Devide");
//        System.out.println("Choose one: ");
//        dataOutputStream.writeDouble(new Scanner(System.in).nextDouble());
//        System.out.println("First Number: ");
//        dataOutputStream.writeDouble(new Scanner(System.in).nextDouble());
//        dataOutputStream.flush();
//        System.out.println("Second Number: ");
        dataOutputStream.writeDouble(new Scanner(System.in).nextDouble());
        dataOutputStream.flush();
//        System.out.println("Addition: "+ dataInputStream.readDouble());
      }


    } catch (IOException e) {
      socket.close();
      dataInputStream.close();
      dataOutputStream.close();
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws IOException {
    Client client = new Client(1234, "localhost");
    client.execute();
  }

}
