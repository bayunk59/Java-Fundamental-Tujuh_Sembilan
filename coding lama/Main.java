import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int angka1, angka2, angka3;

        System.out.print("Masukkan angka pertama (-30 sampai 30): ");
        angka1 = validasiInput(scanner);

        System.out.print("Masukkan angka kedua (-30 sampai 30): ");
        angka2 = validasiInput(scanner);

        System.out.print("Masukkan angka ketiga (-30 sampai 30): ");
        angka3 = validasiInput(scanner);

        int nilaiMaksimum = Math.max(Math.max(angka1, angka2), angka3);

        System.out.println("Nilai maksimum adalah: " + nilaiMaksimum);

        scanner.close();
    }

    private static int validasiInput(Scanner scanner) {
        int angka;
        do {
            angka = scanner.nextInt();
            if (angka < -30 || angka > 30) {
                System.out.print("Angka tidak valid. Masukkan angka antara -30 dan 30: ");
            }
        } while (angka < -30 || angka > 30);

        return angka;
    }
}