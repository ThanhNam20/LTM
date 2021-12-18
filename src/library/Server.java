package library;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Registry_itf{
  private ArrayList<Person> arrayList = new ArrayList<>();
  private int port;

  public Server(ArrayList<Person> arrayList, int port) {
    this.arrayList = arrayList;
    this.port = port;
  }

  public void execute(){
    try {
      ServerSocket serverSocket = new ServerSocket(port);
      System.out.println("Server is connecting....");
      Socket socket = serverSocket.accept();
      System.out.println("Server is connect");

      DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
      DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
      ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

      while(true){
        double choose = dataInputStream.readDouble();
        switch((int) choose) {
          case 1:
            System.out.println(objectInputStream.readObject());
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

    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    ArrayList<Person> arrayList = new ArrayList<>();
    Server server = new Server(arrayList, 1234);
    server.execute();
  }

  @Override
  public void add(Person person) {
      arrayList.add(person);
  }

  @Override
  public String getPhone(String name) {
    for(Person person : arrayList) {
      if(person.getName().equals(name)) {
        return person.getPhone();
      }
    }
    return null;
  }

//
//  @Override
//  public Iterable<Person> getAll() {
//    return;
//  }
//
//  @Override
//  public Person search(String name) {
//    for(Person person : arrayList) {
//    }
//    return null;
//  }
}
