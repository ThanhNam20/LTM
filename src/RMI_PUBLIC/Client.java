package RMI_PUBLIC;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
  public static void main(String[] args) throws NotBoundException,MalformedURLException, RemoteException {
    CalInf cal = (CalInf)Naming.lookup("rmi://203.162.10.117/cal1");
    int sum = cal.add(1,2);
    System.out.println("sum: "+sum);
  }
}
