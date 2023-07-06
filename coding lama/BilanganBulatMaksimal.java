import java.util.Scanner;
public class BilanganBulatMaksimal {
    public static void main(String[] args){
        int angkaPertama, angkaKedua, angkaKetiga, angkaMaksimal;
        Scanner input = new Scanner(System.in);

        //input angka
        angkaPertama = input.nextInt();
        angkaKedua = input.nextInt();
        angkaKetiga = input.nextInt();

        angkaMaksimal = Math.max(angkaPertama, Math.max(angkaKedua, angkaKetiga));
        System.out.print(angkaMaksimal);
    }
}
