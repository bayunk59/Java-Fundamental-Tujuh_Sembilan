import java.util.Scanner;

public class diskon {
    public static void main (String[] args){        
        Scanner input = new Scanner (System.in);
        int harBar = input.nextInt();
        int jumBar = input.nextInt();
        double total = harBar * jumBar;
        double diskon = total * 15/100;

        if(harBar >= 10000 && harBar <= 1000000 && jumBar >=1 && jumBar <= 100){
            if(jumBar % 3 == 0 && jumBar % 4 == 0){
                System.out.printf("%.2f",(total - diskon));
            }else{
                System.out.printf("%.2f",total);
            }
        }else{
            System.out.println("Harga tidak tersedia");
        }


    }
}
