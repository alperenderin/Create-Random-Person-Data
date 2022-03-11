/**
 * @File Name  : Test.java
 * @Author	   : Alperen Derin
 * @Created    : 11.04.2020
 **/

package createRandomPersonsLib;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test {
    
    public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int user_choice = 0;
		
		do{
			System.out.println("1-Rastgele Kisi Uret\n2-Uretilmis Dosya Kontrol Et\n3-Cikis");
			user_choice = input.nextInt();
			switch (user_choice){
			    case 1:
			    	RandomPerson.generatePerson();
			        break;
			    case 2:
			    	controlFile();
			        break;
			    case 3:
			    	user_choice = 3;
			        break;
			    default:
			        System.out.println("Hatali giris yaptiniz");
			        break;
			}
		} while(user_choice != 3);
         input.close();
    }
    
    public static void controlFile() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("kisiler.txt"), "ISO-8859-9"));
        String row = null;

        System.out.println("TCKN \t\t\tIMEI");                  
        
        while ((row = br.readLine()) != null) {
            String tckn_number = row.substring(3, 14);
            String imei_number[] = row.split("[\\(||//)]");
    
            long imei = Long.parseLong(imei_number[1]);            
            boolean verify_tckn = IdNumber.verifyTCKN(tckn_number);
            boolean verify_imei = IMEINumber.verifyIMEI(imei);
            
            if(verify_tckn == true)
                System.out.print(tckn_number + " Gecerli");  
            else
                System.out.print(tckn_number + " Gecersiz");
            
            if(verify_imei == true)
                System.out.println("\t" + imei + " Gecerli");
            else            
                System.out.println("\t" + imei + " Gecersiz");
        }
        br.close();
    }
}

    


