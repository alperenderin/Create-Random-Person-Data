/**
 * @File Name  : CreateRandomPersonsLib.java
 * @Author	   : Alperen Derin
 * @Created    : 11.04.2020
 **/

package createRandomPersonsLib;

public class Telephone {

    private String telephone_number;
    private String[] turkish_gsm_codes = {"0501", "0505", "0506", "0507", "0551 ", "0552", "0553", "0554", "0555","0559",
                            "0530", "0531", "0532", "0533", "0534", "0535","0536", "0537", "0538", "0539", "0561",
                            "0540", "0541", "0542", "0543", "0544","0545", "0546", "0547", "0548", "0549" }; 

    public Telephone(){
        setTelephoneNumber();
    }

    private void setTelephoneNumber(){
        int temp;
        do{
        	temp = RandomNumber.createRandomValue() / 100;
        } while(temp > 31);
       
        telephone_number = turkish_gsm_codes[temp] + RandomNumber.createRandomValue() + RandomNumber.createRandomValue() / 10;
    }

    public String getTelephone(){
        return telephone_number;
    }
}
