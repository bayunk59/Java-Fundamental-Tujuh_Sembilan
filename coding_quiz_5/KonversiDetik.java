package coding_quiz_5;

import java.util.Scanner;

public class KonversiDetik {
    public static void main(String []argh){
        Scanner scanner = new Scanner(System.in);
        int inputDetik;

        inputDetik = scanner.nextInt();

        int jumlahHari = getHari(inputDetik);
        int sisaDetikDariHari = inputDetik %(24*60*60);
        int jumlahJam = getJam(sisaDetikDariHari);
        int sisaDetikDariJam = sisaDetikDariHari %(60*60);
        int jumlahMenit = getMenit(sisaDetikDariJam);
        int sisaDetikDariMenit = sisaDetikDariJam % 60;
        int jumlahDetik = getDetik(sisaDetikDariMenit);

        System.out.println(jumlahHari);
        System.out.println(jumlahJam);
        System.out.println(jumlahMenit);
        System.out.print(jumlahDetik);
    }

    //Mendapatkan jumlah hari
    public static int getHari(int inputDetik) {
        int result = 0;
        int jumlahHari = inputDetik/(24*60*60);
        result = jumlahHari;
        
        return result;
        
    }
    
    //Mendapatkan jumlah jam
    public static int getJam(int sisaDetikDariHari) {
        int result = 0;
        int jumlahJam = sisaDetikDariHari / (60*60);
        result = jumlahJam;
        
        return result;
        
    }

    //Mendapatkan jumlah Menit
    public static int getMenit(int sisaDetikDariJam) {
        int result = 0;
        int jumlahMenit = sisaDetikDariJam / (60);
        result = jumlahMenit;
        
        return result;
        
    }

    //Mendapatkan jumlah Menit
    public static int getDetik(int sisaDetikDariMenit) {
        int result = 0;
        int jumlahDetik = sisaDetikDariMenit;
        result = jumlahDetik;
        
        return result;
        
    }
}
