import java.util.Scanner;
public class eva {
    public static void main(String []argh)
    {
        Scanner input = new Scanner(System.in);
        double uang = input.nextDouble();
        double saldo = input.nextDouble();
        double uangX = uang + 0.5;

        if(uang%5==0 && saldo > uangX){
            System.out.printf("%.2f",saldo-uang-0.5);
        }else{
            System.out.printf("%.2f",saldo);
        }

    }
}
