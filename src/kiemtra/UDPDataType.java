package kiemtra;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class UDPDataType {
  private String address;
  private int port;

  public UDPDataType(String address, int port) {
    this.address = address;
    this.port = port;
  }

  public void execute(){
    try {
      // Add socket
      DatagramSocket datagramSocket = new DatagramSocket();
      //Gui du lieu
      String name = ";B18DCAT166;001";
      byte[] bytes = name.getBytes();
      // DatagramPacket can 4 doi so: Mang byte, Do dai mang Byte, address, port;
      DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(address), port);
      datagramSocket.send(datagramPacket);

      //Nhan du lieu
      byte[] inputByte = new byte[60000];
      // 2 tham so la mang byte va do dai mang byte
      DatagramPacket datagramPacket1 = new DatagramPacket(inputByte, inputByte.length);
      datagramSocket.receive(datagramPacket1);

      // String nhan ve can 3 tham so //
      String dataFromServer = new String(datagramPacket1.getData(), 0, datagramPacket.getLength());
      System.out.println(dataFromServer);

      datagramSocket.close();
//
//
//      // Tim cac phan tu con thieu trong mang
//      String a = ";123123;3,1,10,4,5,6,79";
//      String[] strings = a.split(";");
//      String[] strings1 = strings[2].split(",");
//
//      int[] arrayNumber = Arrays.stream(strings1).mapToInt(Integer::parseInt).toArray(); // mang ki tu sang mang so
//      int[] sortArrayNumber = Arrays.stream(arrayNumber).sorted().toArray();
//      int index = 0;
//      for (int j = sortArrayNumber[0]; j <= sortArrayNumber[sortArrayNumber.length - 1] ; j++) {
//        if(j == sortArrayNumber[index]){
//          index++;
//        }else {
//          System.out.println(j);
//        }
//      }

    }catch (IOException e){
      System.out.println(e);
    }
  }

  public static void main(String[] args) {
    UDPDataType udpDataType = new UDPDataType("localhost", 9876);
    udpDataType.execute();
  }
}
