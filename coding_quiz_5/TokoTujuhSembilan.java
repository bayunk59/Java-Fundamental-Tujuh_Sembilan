package coding_quiz_5;

import java.util.Scanner;

public class TokoTujuhSembilan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //Memasukkan data
        int jumlahProduk = scanner.nextInt();
        for(int i=0; i<jumlahProduk; i++){
            scanner.nextLine();
            String namaProduk = scanner.nextLine();
            String labelBarang = scanner.nextLine();
            double hargaProduksi = scanner.nextDouble();

            double labaPercentage = getLabaPercentage(labelBarang);
            double hargaJual = kalkulasiHargaJual(labaPercentage, hargaProduksi);


            System.out.println(namaProduk);
            System.out.println((int)hargaJual);
        }
        scanner.close();
    }

    //Menentukan laba dari label barang
    public static double getLabaPercentage(String labelBarang){
        double result = 0;
        switch (labelBarang) {
            case "Good":
                result = 0.15;
                break;
            case "Recommended":
                result = 0.25;
                break;
            case "Best Seller":
                result = 0.35;
                break;
            case "Normal":
                result = 0.10;
                break;
            default:
                break;
        }
        return result;
    }

    //Mendapatkan harga jual
    public static double kalkulasiHargaJual(double labaPercentage, double hargaProduksi){
        double result = 0;
        double laba = hargaProduksi * labaPercentage;
        double hargaJual = hargaProduksi + laba;
        result = hargaJual;

        return result;
    }
}
