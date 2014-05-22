import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.StringEscapeUtils;


public class HBaseByteParser {

  public static void main(String[] args) throws UnsupportedEncodingException {
    // TODO Auto-generated method stub
    String s = "\\xe6\\x9b\\xbe\\xe4\\xbf\\x8a";
    String ab = StringEscapeUtils.escapeJava(s.replace("\\x", ""));
    
    System.out.println(new String(hexStringToBytes(ab), "utf-8"));
    
  }
  
  private static byte[] hexStringToBytes(String hexString) {  
      if (hexString == null || hexString.equals("")) {  
          return null;  
      }  
      hexString = hexString.toUpperCase();  
      int length = hexString.length() / 2;  
      char[] hexChars = hexString.toCharArray();  
      byte[] d = new byte[length];  
      for (int i = 0; i < length; i++) {  
          int pos = i * 2;  
          d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));  
      }  
      return d;  
  }  
  
  private static byte charToByte(char c) {  
      return (byte) "0123456789ABCDEF".indexOf(c);  
  } 
  
}

