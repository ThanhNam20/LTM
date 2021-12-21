package kiemtra;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPObject {
  public static void main(String[] args) throws IOException {
    int port = 1234;
    String address = "3124132123";
    DatagramSocket datagramSocket = new DatagramSocket();
    // Nhan du lieu
    byte[] bytes = new byte[60000];
    DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
    datagramSocket.receive(datagramPacket);

    //String nhan 3 tham so: getData(), index bat dau: 0, do dai chuoi nay
    String dataFromServer = new String(datagramPacket.getData(),0, datagramPacket.getLength());
    System.out.println(dataFromServer);
  }
}
