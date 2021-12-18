package multichat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
  private int port;
  public static ArrayList<Socket> socketArrayList = new ArrayList<>();
  public Server(int port) {
    this.port = port;
  }

  public void execute(){
    try {
      ServerSocket serverSocket = new ServerSocket(port);
      System.out.println("Listening..");
      while(true){
        Socket socket = serverSocket.accept();
        socketArrayList.add(socket);
        System.out.println(socket);
        ServerThread serverThread = new ServerThread(socket);
        serverThread.start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Server server = new Server(1234);
    server.execute();
  }
}
