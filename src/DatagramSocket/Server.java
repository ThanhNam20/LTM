package DatagramSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
  public static void main(String[] args) throws IOException {
    DatagramSocket datagramSocket = new DatagramSocket(2207);
    System.out.println("UDP Server started");
    while(true){
      byte[] buf = new byte[1024];
      //Tiep nhan chuoi
      DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
      datagramSocket.receive(datagramPacket);
      // dao nguoc chuoi
      String request = new String(datagramPacket.getData()).trim();
      String reverseString= new StringBuffer(request).reverse().toString();
      // gui chuoi dao nguoc

    }
  }
}
