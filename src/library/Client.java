package library;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
  private int port;
  private InetAddress address;

  public Client(int port, InetAddress address) {
    this.port = port;
    this.address = address;
  }

  public void execute() throws IOException {
    Socket socket = null;
    DataInputStream dataInputStream = null;
    DataOutputStream dataOutputStream = null;
    ObjectInputStream objectInputStream = null;
    ObjectOutputStream objectOutputStream = null;
    try {
      socket = new Socket(address, port);
      System.out.println("Client is Connect");
      dataInputStream = new DataInputStream(socket.getInputStream());
      dataOutputStream = new DataOutputStream(socket.getOutputStream());
      objectInputStream = new ObjectInputStream(socket.getInputStream());
      objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

      while(true){
        System.out.println("1.Add");
        System.out.println("2.Get Phone");
        System.out.println("3.Get All");
        System.out.println("4.Search");
        System.out.println("Choose one: ");
        double choose = new Scanner(System.in).nextDouble();
        dataOutputStream.writeDouble(choose);

        switch((int) choose) {
          case 1:
            objectOutputStream.writeObject(new Person("Thanh Nam", "0988999889"));
            break;
          case 2:
            break;
          case 3:
            break;
          case 4:
            break;
          default:
            break;
        }
      }

    } catch (IOException e) {
      socket.close();
      dataInputStream.close();
      dataOutputStream.close();
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws IOException {
    calculator.Client client = new calculator.Client(1234, "localhost");
    client.execute();
  }

}
