package kiemtra;

import java.io.*;
import java.net.Socket;

public class TCPDataType {
    private int port;
    private String address;

    public TCPDataType(int port, String address) {
        this.port = port;
        this.address = address;
    }

    private void execute() throws IOException {
        Socket socket = new Socket(address, port);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String msv = "B18DCAT166;721";
        bufferedWriter.write(msv);

        String data = bufferedReader.readLine();
        System.out.println(data);

        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
    }
    public static void main(String[] args) throws IOException {
        TCPDataType TCPDataType = new TCPDataType(2208, "203.162.10.109");
        TCPDataType.execute();
    }

}