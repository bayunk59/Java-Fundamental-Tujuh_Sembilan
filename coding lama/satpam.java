import java.util.Scanner;

public class satpam {
     public static void main (String[] args){        
        Scanner input = new Scanner (System.in);
        int a = input.nextInt();
        int b = input.nextInt();

        if(a == 1){
            if(b < 4){
                System.out.println("Serahkan KTP anda !!!");
            }else if(b>=4){
                System.out.println("Bayar Denda 10000 !!!");
            }
        }else if(a == 2){
            System.out.println("Ambil STNK dulu !!!");
        }
    }
}
