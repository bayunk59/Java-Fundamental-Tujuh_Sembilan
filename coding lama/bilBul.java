import java.util.Scanner;
public class bilBul {
    public static void main (String[] args){        
        Scanner input = new Scanner (System.in);
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = Math.max(a,Math.max(b,c));

        if(a >= -30 && a <= 30 && b >= -30 && b <= 30 && c >= -30 && c <= 30){
            System.out.println((int)d);
        }else{
            System.out.println("Angka yang dimasukkan tidak sesuai");
        }
    }
}
