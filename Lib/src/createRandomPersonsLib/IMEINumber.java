/**
 * @File Name  : IMEINumber.java
 * @Author	   : Alperen Derin
 * @Created    : 11.04.2020
 **/

package createRandomPersonsLib;
import java.io.*; 

public class IMEINumber {
    
    public String imei_number;

    public IMEINumber(){
        createIMEI();
        createLastIMEIDigit();
    }
    
    public static boolean verifyIMEI(long imei) { 
        String s = Long.toString(imei); 
        int len = s.length(); 
        int sum = 0;
        
        if (len != 15) 
            return false; 

        for (int i = len; i >= 1; i--){ 
            int last_digit = (int)(imei % 10);
  
            if (i % 2 == 0) 
                last_digit = 2 * last_digit; 
            
            sum += sumDig(last_digit); 
            imei = imei / 10;
        }
        return (sum % 10 == 0); 
    } 

    private void createIMEI(){
        imei_number = String.valueOf(RandomNumber.createRandomValue()) + String.valueOf(RandomNumber.createRandomValue()) +
        			  String.valueOf(RandomNumber.createRandomValue()) + String.valueOf(RandomNumber.createRandomValue() / 100);
    }

    private void createLastIMEIDigit(){
        int sum = 0;
        boolean alternate = true;

        for (int i = imei_number.length()-1; i >= 0; i--){
            int n = Integer.parseInt(imei_number.substring(i, i + 1));
            if (alternate == true){
                n *= 2;
                if (n > 9)
                    n = (n % 10) + 1;
            }
            sum += n;
            alternate = !alternate;
        }
        if((sum%10) == 0)
            imei_number += 0;
        else
            imei_number += 10 - (sum % 10 );            
    }

    static int sumDig(int n) { 
        int a = 0; 
        while (n > 0){ 
            a = a + n % 10;
            n = n / 10;
        } 
        return a;
    } 

   public String getIMEI(){
       return imei_number;
   }
}
