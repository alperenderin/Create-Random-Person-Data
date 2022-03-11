/**
 * @File Name  : Person.java
 * @Author	   : Alperen Derin
 * @Created    : 11.04.2020
 **/

package createRandomPersonsLib;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class Person {
    private String id_number;
    private String telephone_number;
    private String name;
    private int age;
    private String imei_number;

    private Telephone telephone = new Telephone();
    private IdNumber tckn = new IdNumber();
    private IMEINumber imei = new IMEINumber();
    private RandomPerson random_person = new RandomPerson();

    public Person() throws Exception{
        id_number = tckn.getTCKN();
        telephone_number = telephone.getTelephone();
        name= random_person.getName();
        imei_number = imei.getIMEI();

        age = (int)RandomNumber.createRandomValue()/100;
    }

    public void print(){
        System.out.println(id_number + " " + name + " " + age + " " + telephone_number + " ("+ imei_number + ") ");
    }
    
    public static void exportPerson(ArrayList<Person> persons) throws IOException{
        int index = 0;
        File file = new File("kisiler.txt");
        
        if(!file.exists()) {
            file.createNewFile();
        }
        
        FileWriter file_writer = new FileWriter(file, false);
        BufferedWriter buffered_writer = new BufferedWriter(file_writer);
        
        while(persons.size() != index){
	        buffered_writer.write(index + "- " + persons.get(index).id_number + " " + persons.get(index).name + " " + persons.get(index).age + " " + persons.get(index).telephone_number + " ("+ persons.get(index).imei_number + ")\n");
	        index++;
        }
        buffered_writer.close();
    }
    
}
