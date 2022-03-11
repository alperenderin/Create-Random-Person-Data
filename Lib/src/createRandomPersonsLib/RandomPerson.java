/**
 * @File Name  : RandomPerson.java
 * @Author	   : Alperen Derin
 * @Created    : 11.04.2020
 **/

package createRandomPersonsLib;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class RandomPerson {

    public String getName() throws Exception{
		RandomNumber rand = new RandomNumber();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("random_isimler.txt"), "ISO-8859-9"));
		String row = null;
		int random;
		
		do {
		      random = rand.createRandomValue();
		} while (random > 3000);
		
		for(int i = 0; i < random; i++) 
		    row = br.readLine();
		
		br.close();
		return row; 
    }
    
    public static void generatePerson() throws Exception{
        System.out.println("Kac Tane Kisi Uretilmesini Istersiniz");
        Scanner input = new Scanner(System.in);
        int person_count = input.nextInt();
  
        int index = 0;
        ArrayList<Person> persons = new ArrayList(); 
        
        while(index != person_count){
	        Person person = new Person();
	        persons.add(person);
	        index++;
        }
        Person.exportPerson(persons);
        input.close();
    }
}
