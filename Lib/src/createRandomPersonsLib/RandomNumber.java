/**
 * @File Name  : RandomNumber.java
 * @Description: The purpose of this code is to generate a random number without using a random library
 * @Author	   : Alperen Derin
 * @Created    : 11.04.2020
 **/

package createRandomPersonsLib;
//import java.util.concurrent.TimeUnit;

public class RandomNumber {
    
	public static int createRandomValue(){

	int units_digit, tens_digit, hundreds_digit, thousands_digit, number;
	
	do {
		long startTime = System.nanoTime(); // generates a 15 digit number
		long end = startTime % 1000000;
		number = (int) end/100;
		
		units_digit = number % 10;
		tens_digit = (number % 100 - number % 10) / 10;			// for example: 124...4387%100=87 and 124...4387%10=7 from 87-7=80 and as the last step 80/10=8 is the tens digit
		hundreds_digit = (number % 1000 - number % 100) / 100;
		thousands_digit = (number % 10000 - number % 1000) / 1000;
	}while ((hundreds_digit == 0) || (units_digit==0 && thousands_digit==0));
	
	int number_pair = (number%1000)/10;
	int random_value;
	
	if (!(units_digit == 0)){
		random_value = (int)Math.pow(number_pair, 2);
	
	do {
		if (!(random_value<10000 && random_value>1000)){ // i want to generate a 4 digit random value       
		        random_value = random_value * units_digit;
		        if (units_digit == 1)
		            units_digit = 3;
		}
		}while (!(random_value<10000 && random_value>1000));
	
	}
	else {
		random_value=(int)Math.pow(number_pair, 2);
		do {
			if (!(random_value<10000 && random_value>1000)){
			    if (thousands_digit == 1){
			        thousands_digit = 3;
			    }
			    random_value = random_value * thousands_digit;
			}
		}while (!(random_value<10000 && random_value>1000));
	}
	return random_value;
	}
    
}
