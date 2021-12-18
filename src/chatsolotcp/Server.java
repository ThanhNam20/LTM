package chatsolotcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  private int port ;

  public Server(int port) {
    this.port = port;
  }

  private void execute() {
    try {
      ServerSocket server = new ServerSocket(port);
      Socket socket = server.accept();
      ReadThread readThread = new ReadThread(socket);
      readThread.start();
      WriteThread writeThread = new WriteThread(socket);
      Thread thread =  new Thread(writeThread);
      thread.start();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Server server = new Server(1234);
    server.execute();
  }
}
