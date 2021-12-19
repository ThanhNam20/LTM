package kiemtra;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Test {
  public static void main(String[] args) throws IOException {
    DatagramSocket datagramSocket = new DatagramSocket();

    Student student = new Student("12","34", "Khuat tHanh Nha", "1231231");
    String sendData = student.toString();
    byte[] bytes = new byte[sendData.length()];
    System.out.println(sendData);
    // Gui du lieu
//    DatagramPacket datagramPacket = new DatagramPacket(sendData.getBytes(StandardCharsets.UTF_8), sendData.length(), InetAddress.getByName("123123"), 123123);
//    datagramSocket.send(datagramPacket);

  }
}

class Student {
  private String id;
  private String code;
  private String name;
  private String email;
  private static final long serialVersionUID = 20161107;

  public Student(String id, String code, String name, String email) {
    this.id = id;
    this.code = code;
    this.name = name;
    this.email = email;
  }
  public Student(String code) {
    this.code = code;
  }
}
