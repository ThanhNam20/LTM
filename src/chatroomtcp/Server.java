package chatroomtcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import static chatroomtcp.Server.ListSocket;

public class Server {
  private int port ;
  public static ArrayList<Socket> ListSocket;

  public Server(int port) {
    this.port = port;
  }

  private void execute() throws IOException {
    ServerSocket serverSocket = new ServerSocket(port);
    System.out.println("Listening...");
    while(true){
      Socket socket = serverSocket.accept();
      System.out.println("Da ket noi voi socket" + socket);
      ListSocket.add(socket);
//      WriteServer writeServer = new WriteServer();
//      writeServer.start();
      ReadServer readServer = new ReadServer(socket);
      readServer.start();
    }
  }

  public static void main(String[] args) throws IOException {
    ListSocket = new ArrayList<>();
    Server server = new Server(1234);
    server.execute();
  }
}

class ReadServer extends Thread {
  private Socket socket;

  public ReadServer(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    DataInputStream dis = null;
    try {
      dis = new DataInputStream(socket.getInputStream());
      while(true){
        String sms = dis.readUTF();
        if(sms.contains("exit")){
          Server.ListSocket.remove(socket);
          System.out.println("Ngat ket noi voi "+ socket);
          dis.close();
          socket.close();
          continue;
        }
        for (Socket item: ListSocket) {
          if(item.getPort() != socket.getPort()){ // Ko gui cho client gui tin nhan
            DataOutputStream dos = new DataOutputStream(item.getOutputStream());
            dos.writeUTF(sms);
          }
        }
//        System.out.println(sms);
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

//class WriteServer extends Thread {
//  private Socket socket;
//  @Override
//  public void run() {
//    DataOutputStream dos = null;
//    Scanner sc = new Scanner(System.in);
//    while (true) {
//      String sms = sc.nextLine();	//Đang đợi Server nhập dữ liệu
//      try {
//        for (Socket item : ListSocket) {
//          dos = new DataOutputStream(item.getOutputStream());
//          dos.writeUTF("Server: " + sms);
//        }
//      } catch (IOException e) {
//        e.printStackTrace();
//      }
//
//    }
//  }
//}

