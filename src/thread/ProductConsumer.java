package thread;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductConsumer {
  public static void main(String[] args) {
    ShareData shareData = new ShareData();
    new Producer(shareData).start();
    new Thread(new Consumer(shareData)).start();
  }
}

class Consumer implements Runnable {
  ShareData shareData;
  public Consumer(ShareData shareData) {
    this.shareData = shareData;
  }

  @Override
  public void run() {
    while(true){
      shareData.consume();
    }
  }
}

class Producer extends Thread {
  ShareData shareData;

  public Producer(ShareData shareData){
    this.shareData =shareData;
  }
  @Override
  public void run() {
      while(true){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        shareData.produce(number);
      }
  }
}


class  ShareData {
  ArrayList arrayList = new ArrayList();
  boolean produced = false;
  public synchronized void produce(int value) {
    if(produced) {
      try{
        this.wait();
      }catch(InterruptedException ex){}
    }
    arrayList.add(value);
    System.out.println("produce: " + value);
    produced = true;
    notify();
  }
  public synchronized void consume() {
    if(!produced){
      try{
        this.wait();
      }catch(InterruptedException ex){}
    }
    for (Object arr: arrayList) {
      System.out.println("consume: " + arr);
    }
    produced = false;
    notify();
  }
}
