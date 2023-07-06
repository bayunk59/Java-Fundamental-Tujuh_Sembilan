package coding_quiz_5;
import java.util.Scanner;

public class DesimalToRomawi {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int angkaDesimal;
        //input angka
        angkaDesimal = input.nextInt();
        
        String angkaRomawi = convertDesimalToRomawi(angkaDesimal);
        //output error
        if(angkaDesimal<1 || angkaDesimal >3999){
            System.out.print("Error");
        } else{
            System.out.print(angkaRomawi);
        }
    }    

    //angka di atas 1000
    public static String convertDesimalToRomawi(int angkaDesimal) {
        String angkaRomawi = "";
        
        //ubah angka ribuan
        while (angkaDesimal >= 1000){
            angkaRomawi += "M";
            angkaDesimal -= 1000;
        }

        //ubah angka ratusan
        while (angkaDesimal >= 900){
            angkaRomawi += "CM";
            angkaDesimal -= 900;
        }

        while (angkaDesimal >= 500){
            angkaRomawi += "D";
            angkaDesimal -= 500;
        }

        while (angkaDesimal >= 400){
            angkaRomawi += "CD";
            angkaDesimal -= 400;
        }

        while (angkaDesimal >= 100){
            angkaRomawi += "C";
            angkaDesimal -= 100;
        }

        //ubah angka puluhan
        while (angkaDesimal >= 90){
            angkaRomawi += "XC";
            angkaDesimal -= 90;
        }

        while (angkaDesimal >= 50){
            angkaRomawi += "L";
            angkaDesimal -= 50;
        }

        while (angkaDesimal >= 40){
            angkaRomawi += "XL";
            angkaDesimal -= 40;
        }

        while (angkaDesimal >= 10){
            angkaRomawi += "X";
            angkaDesimal -= 10;
        }

        //ubah angka satuan
        while (angkaDesimal >= 9){
            angkaRomawi += "IX";
            angkaDesimal -= 9;
        }

        while (angkaDesimal >= 5){
            angkaRomawi += "V";
            angkaDesimal -= 5;
        }

        while (angkaDesimal >= 4){
            angkaRomawi += "IV";
            angkaDesimal -= 4;
        }

        while (angkaDesimal >= 1){
            angkaRomawi += "I";
            angkaDesimal -= 1;
        }

        return angkaRomawi;
    }    
}
