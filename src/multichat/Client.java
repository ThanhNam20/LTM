package multichat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
  private int port;
  private InetAddress address;

  public Client(int port, InetAddress address) {
    this.port = port;
    this.address = address;
  }

  public void execute() {
    try {
      Socket socket = new Socket(address, port);
      while(true){
        ClientWrite clientWrite = new ClientWrite(socket);
        clientWrite.start();
        ClientRead clientRead = new ClientRead(socket);
        clientRead.start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    try {
      Client client = new Client(1234, InetAddress.getLocalHost());
      client.execute();
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }

}
