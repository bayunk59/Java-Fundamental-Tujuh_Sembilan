import java.util.Scanner;
public class promo {
    public static void main(String []argh)
    {
        Scanner input = new Scanner(System.in);
        double harga = input.nextDouble();
        double tanggal = input.nextDouble();
        double diskon = harga - ((0.02) * (tanggal * harga));

        if(harga>= 50000){
            System.out.printf("%.2f", diskon);
        }else {
            System.out.printf("%.2f", harga);
        }

    }
}
