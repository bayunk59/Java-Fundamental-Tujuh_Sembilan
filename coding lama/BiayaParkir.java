import java.util.Scanner;

public class BiayaParkir {

	public static void main(String[] args) {
		int tarifPertama, tarifPerJam, maksimalTarif, tarifParkir, jenisKendaraan, lamaParkir;
        String  namaKendaraan;
		Scanner input = new Scanner(System.in);

		// Input User
		// Input Kenis kendaraan
		namaKendaraan = input.nextLine();
        if(namaKendaraan.equalsIgnoreCase("mobil")){
                jenisKendaraan = 1;
        } else if (namaKendaraan.equalsIgnoreCase("motor")) {
            jenisKendaraan = 2;
        } else if (namaKendaraan.equalsIgnoreCase("box")) {
            jenisKendaraan = 3;
        } else if (namaKendaraan.equalsIgnoreCase("bus")) {
            jenisKendaraan = 4;
        } else if (namaKendaraan.equalsIgnoreCase("sepeda")) {
            jenisKendaraan = 5;
        } else {
            jenisKendaraan = 0;
        }


		// Input Lama Parkir
		lamaParkir = Integer.valueOf(input.nextLine());


		// Menentukan Tarif Pertama berdasarkan Jenis Kendaraan.
		tarifPertama = getTarifPertama(jenisKendaraan);

//		// Menentukan Tarif Per Jam berdasarkan Jenis Kendaraan.
		tarifPerJam = getTarifPerjam(jenisKendaraan);
		

//		// Menentukan Maksimal tarif parkir berdasarkan Jenis Kendaraan.
		maksimalTarif = getMaksimalTarif(jenisKendaraan);

//		// Kalkulasi Tarif Parkir
		tarifParkir = calculateTarifParkir(tarifPertama, tarifPerJam, maksimalTarif, lamaParkir);

//		// print out hasil
		if (tarifParkir == 0) {
			System.out.println("Input Error!!!");
		} else {
			System.out.println(tarifParkir);
		}
	}

	// Menentukan Tarif Pertama berdasarkan Jenis Kendaraan.
	public static int getTarifPertama(int jenisKendaraan) {
		// Tarif pertama berdasarkan Jenis Kendaraan dan Member

		int result = 0;

		// Looping & Array
		int[] tarifParkirKendaraan = { 5000, 2000, 10000 , 20000, 500};
		result = tarifParkirKendaraan[jenisKendaraan - 1];

		return result;
	}

	// Menentukan Tarif Per Jam Box 3
	public static int getTarifPerjam(int jenisKendaraan) {
		int result = 0;
		int[] tarifPerjamKendaraan = { 2000, 1000, 5000 , 10000, 200};
		result = tarifPerjamKendaraan[jenisKendaraan - 1];
		
		return result;
	}

	// Menentukan Maksimal tarif parkir berdasarkan Jenis Kendaraan.
	public static int getMaksimalTarif(int jenisKendaraan) {
		int result = 0;

		int[] tarifMaksimalPerKendaraan = { 25000, 10000, 50000 , 100000, 5000};
		result = tarifMaksimalPerKendaraan[jenisKendaraan - 1];

		return result;
	}

	// Kalkulasi Tarif Parkir
	public static int calculateTarifParkir(int tarifPertama, int tarifPerjam, int maksimalParkir, int lamaParkir) {
		int result = 0;
		int minimalJam = 1;
		int maksimalJam = 24;

		// menghitung Tarif Parkir
		if (minimalJam < lamaParkir && lamaParkir <= maksimalJam) {
			result = tarifPertama + ((lamaParkir - 1) * tarifPerjam);
		}

		// Validasi Tarif Maksimal
		if (result > maksimalParkir) {
			result = maksimalParkir;
		}

		return result;
	}
}
