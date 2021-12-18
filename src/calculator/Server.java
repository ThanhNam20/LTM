package calculator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server implements Calculator_itf{
  private int port;

  public Server(int port) {
    this.port = port;
  }

  public void execute(){
    try {
      ServerSocket serverSocket = new ServerSocket(port);
      System.out.println("Server is connecting....");
      Socket socket = serverSocket.accept();
      System.out.println("Server is connect");

      DataInputStream inputStream = new DataInputStream(socket.getInputStream());
      DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

      while (true) {
        double choose = inputStream.readDouble();
        double number1 = inputStream.readDouble();
        double number2 = inputStream.readDouble();
        System.out.println(" Numbers are: "+ number1+ " " +number2);
        switch((int) choose) {
          case 1:
            double sum = plus(number1, number2);
            outputStream.writeDouble(sum);
            outputStream.flush();
            System.out.println("Sum: "+ sum);
            break;

          case 2:
            double minus = minus(number1, number2);
            outputStream.writeDouble(minus);
            outputStream.flush();
            System.out.println("Minus: "+ minus);
            break;
          case 3:
            double mul = multiply(number1, number2);
            outputStream.writeDouble(mul);
            outputStream.flush();
            System.out.println("Multiply: "+ mul);
            break;
          case 4:
            double devide = divide(number1, number2);
            outputStream.writeDouble(devide);
            outputStream.flush();
            System.out.println("Devide: "+ devide);
            break;
          default:
            break;
        }
      }
    } catch (IOException ex) {
      Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public static void main(String[] args) {
    Server server = new Server(1234);
    server.execute();
  }

  @Override
  public double plus(double a, double b) {
    return a+b;
  }

  @Override
  public double minus(double a, double b) {
    return a-b;
  }

  @Override
  public double multiply(double a, double b) {
    return a*b;
  }

  @Override
  public double divide(double a, double b) {
    return a/b;
  }

}
