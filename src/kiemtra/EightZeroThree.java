package kiemtra;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class EightZeroThree {
  public static void main(String[] args) throws IOException {
    DatagramSocket datagramSocket = new DatagramSocket();
    String address = "localhost";
    String data = ";b18dcat166,123";
    byte[] bytes = data.getBytes(StandardCharsets.UTF_8);

    DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(address), 1234);
    datagramSocket.send(datagramPacket);

    byte[] bytes1 = new byte[60000];

    DatagramPacket datagramPacket1 = new DatagramPacket(bytes1, bytes1.length);

    datagramSocket.receive(datagramPacket1);

    String dataFromServer = new String(datagramPacket1.getData(), 0, datagramPacket1.getLength());

    System.out.println(dataFromServer);

    

  }
}
