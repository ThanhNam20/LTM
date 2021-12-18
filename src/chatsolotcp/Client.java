package chatsolotcp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
  private String host;
  private int port ;

  public Client(String host, int port) {
    this.host = host;
    this.port = port;
  }

  private void execute () {
    try {
      Socket client = new Socket(host, port);
      ReadThread readThread = new ReadThread(client);
      readThread.start();
      WriteThread writeThread = new WriteThread(client);
      Thread thread = new Thread(writeThread);
      thread.start();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws UnknownHostException {
    Client client = new Client("localhost", 1234);
    client.execute();
  }

}
