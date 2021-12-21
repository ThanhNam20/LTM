package kiemtra;

//a. Mã hóa : EK(i) = (i+k) mod N b. Giải mã : DK(i) = (i-k) mod N

import static java.lang.Character.isUpperCase;

public class CaesarEncrypt {
  public static void main(String[] args) {
    CaesarEncrypt caesarEncrypt = new CaesarEncrypt();
    String test = "bc";
    System.out.println(caesarEncrypt.Decrypt(test, 1));
  }

  public String Decrypt(String s, int k){
    String result = "";
    for (int i = 0; i < s.length(); i++) {
      if(isUpperCase(s.charAt(i))) {
        result += (char) ('A' + (s.charAt(i) - 'A' + (26-k)) % 26);
      }else {
        result+= (char) ('a' + (s.charAt(i) - 'a' + (26-k)) % 26);
      }
    }
    return result;
  }
}

