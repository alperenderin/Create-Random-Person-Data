/**
 * @File Name  : IdNumber.java
 * @Author	   : Alperen Derin
 * @Created    : 11.04.2020
 **/

package createRandomPersonsLib;

public class IdNumber {
    
    public String tckn;

    public IdNumber(){
        assignTCKN();
        assginTCKN10Digits();
        assignTCKNLastDigit();
    }

    private void assignTCKN(){
        tckn =  String.valueOf(RandomNumber.createRandomValue()) + String.valueOf(RandomNumber.createRandomValue()) + String.valueOf(RandomNumber.createRandomValue()/1000);
    }

    private void assginTCKN10Digits(){
        int total = 0;
        boolean odd_number = true;

        for(int i = tckn.length()-1; i >= 0; i--){
	        int n = Integer.parseInt(tckn.substring(i, i + 1));
	        if (odd_number == true) {
	            total += n*7;
	        }
	        else{
	            total -= n;
	        }
	        odd_number =! odd_number;
        }
        tckn += total % 10; // the first digit of the total number is the 10th element
    }
    
    private void assignTCKNLastDigit(){
		int toplam=0;
		for(int i = tckn.length() -1; i >= 0; i--){
		    int n = Integer.parseInt(tckn.substring(i, i + 1));
		    toplam +=n;
		}
		tckn += toplam % 10; // the first digit of the total number is the 10th element
    }

   public String getTCKN(){
       return tckn;
   }
   
   public static boolean verifyTCKN(String tcNo){
       int first_digit =  Integer.parseInt(tcNo.substring(0, 1));
       int second_digit =  Integer.parseInt(tcNo.substring(1, 2));
       
       int third_digit =  Integer.parseInt(tcNo.substring(2, 3));
       int fourth_digit =  Integer.parseInt(tcNo.substring(3, 4));
       int fifth_digit =  Integer.parseInt(tcNo.substring(4, 5));
       int sixth_digit =  Integer.parseInt(tcNo.substring(5, 6));
       int seventh_digit =  Integer.parseInt(tcNo.substring(6, 7));
       int eight_digit =  Integer.parseInt(tcNo.substring(7, 8));
       int nineth_digit =  Integer.parseInt(tcNo.substring(8, 9));
       
       int tenth_digit =  Integer.parseInt(tcNo.substring(9, 10));
       int eleventh_digit =  Integer.parseInt(tcNo.substring(10, 11));       
       
       int calculated_tenth_digit = ((first_digit + third_digit + fifth_digit + seventh_digit + nineth_digit) * 7 - (second_digit + fourth_digit + sixth_digit + eight_digit)) % 10;
       int calculated_eleventh_digit = (first_digit + second_digit + third_digit + fourth_digit + fifth_digit + sixth_digit + seventh_digit + eight_digit + nineth_digit + calculated_tenth_digit) % 10;
       
       if(calculated_tenth_digit == tenth_digit && calculated_eleventh_digit == eleventh_digit)
           return true;
       
       return false;
   }    
}
