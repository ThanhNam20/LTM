package DatagramSocket;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) throws IOException {
    DatagramSocket datagramSocket = new DatagramSocket();
    // Gui 1 chuoi
    String data = "thanh nam hahahaha";

    DatagramPacket datagramPacket = new DatagramPacket(data.getBytes(StandardCharsets.UTF_8), data.length(), InetAddress.getByName("localhost"), 2207); // For sending package
    datagramSocket.send(datagramPacket);
    // Tiep nhan chuoi da dao nguoc
  }
}
