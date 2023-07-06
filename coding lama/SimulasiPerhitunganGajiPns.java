import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class SimulasiPerhitunganGajiPns {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String nama, tipeGolongan, statusPernikahan;
        int golonganPangkat, masaKerja, jumlahAnak;

        //Input nama
        do {
            System.out.print("Masukkan Nama: ");
            nama = input.nextLine();
            if(!nama.matches("[a-zA-Z\\s]+")){ 
                System.out.println("Error: Nama harus menggunakan huruf");
            }
        } while (!nama.matches("[a-zA-Z\\s]+"));
        
        //Input golongan pangkat
        do{
           System.out.print("Masukkan Golongan Pangkat: ");
            while (!input.hasNextInt()){
                System.out.println("Error: Wajib diisi dengan angka");
                System.out.print("Masukkan Golongan Pangkat: ");
                input.next();
            }
            golonganPangkat = input.nextInt();
            if(golonganPangkat<1 || golonganPangkat>4){
                System.out.println("Error: Angka yang dimasukkan hanya 1-4");
            }
        } while(golonganPangkat<1 || golonganPangkat>4);

        input.nextLine();
        //Input golongan ruang kerja(tipe golongan)
        do{
           System.out.print("Masukkan Golongan Ruang Kerja: ");
           tipeGolongan= input.nextLine();

           if(tipeGolongan.length() > 1){
                System.out.println("Error: Input hanya boleh 1 huruf");
           }else {
                if((golonganPangkat>=1 && golonganPangkat<=3) && !tipeGolongan.matches("[a-dA-D]+")){
                    System.out.println("Error: Golongan pangkat 1-3 hanya memiliki golongan ruang kerja A-D");
                }else if(golonganPangkat==4 && !tipeGolongan.matches("[a-eA-E]+")){
                    System.out.println("Error: Golongan pangkat 4 hanya memiliki golongan ruang kerja A-E");
           } 
        }
        }while(tipeGolongan.length() > 1 || ((golonganPangkat>=1 && golonganPangkat<=3) && !tipeGolongan.matches("[a-dA-D]+") || (golonganPangkat==4 && !tipeGolongan.matches("[a-eA-E]+"))));

        //Input masa kerja
        do{
           System.out.print("Masukkan Masa Kerja: ");
            while (!input.hasNextInt()){
                System.out.println("Error: Wajib diisi dengan angka");
                System.out.print("Masukkan Masa Kerja: ");
                input.next();
            }
            masaKerja = input.nextInt();
            if(masaKerja<0 || masaKerja>50){
                System.out.println("Error: Angka yang dimasukkan hanya 1-50");
            }
        } while(masaKerja<0 || masaKerja>50);

        input.nextLine();
        //Input status pernikahan
        do {
            System.out.print("Masukkan Status Pernikahan: ");
            statusPernikahan = input.nextLine();
            if(!statusPernikahan.matches("[a-zA-Z\\s]+")){
                System.out.println("Error: Status pernikahan harus menggunakan huruf");
            }else if(!statusPernikahan.equalsIgnoreCase("Kawin") && !statusPernikahan.equalsIgnoreCase("Belum Kawin") && !statusPernikahan.equalsIgnoreCase("Cerai")){
                System.out.println("Status pernikahan yang bisa diisi adalah Kawin, Belum Kawin dan Cerai");
            }
        } while (!statusPernikahan.equalsIgnoreCase("Kawin") && !statusPernikahan.equalsIgnoreCase("Belum Kawin") && !statusPernikahan.equalsIgnoreCase("Cerai"));
        
        //Input jumlah anak
        do{
           System.out.print("Masukkan Jumlah Anak: ");
            while (!input.hasNextInt()){
                System.out.println("Error: Wajib diisi dengan angka");
                System.out.print("Masukkan Jumlah Anak: ");
                input.next();
            }
            jumlahAnak = input.nextInt();

            if(statusPernikahan.equalsIgnoreCase("Belum Kawin")){
                if(jumlahAnak != 0){
                    System.out.println("Error: Jumlah anak harus 0 jika belum kawin");
                }
            }else{
                if (jumlahAnak<0){
                System.out.println("Error: Angka yang dimasukkan hanya minimal 0");
                }
            } 
        } while(jumlahAnak<0 || (statusPernikahan.equalsIgnoreCase("Belum Kawin") && jumlahAnak != 0 ));

        //Menentukan jumlah gaji pokok
        int gajiPokok = kalkulasiGajiPokok(masaKerja, tipeGolongan, golonganPangkat);
        //Menentukan jumlah tunjangan keluarga
        int tunjanganKeluarga = kalkulasiTunjanganKeluarga(statusPernikahan, gajiPokok);
        //Menentukan jumlah tunjangan anak
        int tunjanganAnak = kalkulasiTunjanganAnak(jumlahAnak, gajiPokok);
        //Menentukan jumlah tunjangan beras
        int tunjanganBeras = kalkulasiTunjanganBeras(statusPernikahan, jumlahAnak);
        //Menentukan jumlah tunjangan umum jabatan
        int tunjanganUmumJabatan = kalkulasiTunjanganUmumJabatan(golonganPangkat);
        //Menentukan jumlah gaji kotor
        int gajiKotor = kalkulasiGajiKotor(gajiPokok,tunjanganAnak,tunjanganKeluarga,tunjanganUmumJabatan,tunjanganBeras);
        //Menentukan jumlah potongan Pph
        int potonganPPH = kalkulasiPotonganPPH(gajiPokok, statusPernikahan,gajiKotor,jumlahAnak,tunjanganKeluarga,tunjanganAnak);
        //Menentukan jumlah potongan IWP
        int potonganIWP = kalkulasiPotonganIWP(gajiPokok,tunjanganAnak,tunjanganKeluarga);
        //Menentukan jumlah potongan taperum
        int potonganTaperum = kalkulasiPotonganTaperum(golonganPangkat);
        //Menentukan jumlah gaji bersih
        int gajiBersih = kalkulasiGajiBersih(gajiKotor, potonganPPH, potonganIWP,potonganTaperum); 
        //Menampilkan output
        displayOutput( nama,gajiPokok,tunjanganKeluarga, tunjanganAnak, tunjanganBeras, tunjanganUmumJabatan, gajiKotor, potonganPPH, potonganIWP, potonganTaperum, gajiBersih);        
    }

    // Menentukan jumlah gaji pokok berdasarkan masa kerja, tipe golongan dan golongan pangkat
	public static int kalkulasiGajiPokok(int masaKerja, String tipeGolongan, int golonganPangkat) {
		int result = 0;

		// Array tipe golongan 1
		int[][] golonganPangkat1 = {
            {1560800, 1560800, 1560800, 1560800},
            {1560800, 1560800, 1560800, 1560800},
            {1610000, 1610000, 1610000, 1610000},
            {1610000, 1704500, 1776600, 1851800},
            {1660700, 1704500, 1776600, 1851800},
            {1660700, 1758200, 1832600, 1910100},
            {1713000, 1758200, 1832600, 1910100},
            {1713000, 1813600, 1890300, 1970200},
            {1766900, 1813600, 1890300, 1970200},
            {1766900, 1870700, 1949800, 2032300},
            {1822600, 1870700, 1949800, 2032300},
            {1822600, 1929600, 2011200, 2096300},
            {1880000, 1929600, 2011200, 2096300},
            {1880000, 1990400, 2074600, 2162300},
            {1939200, 1990400, 2074600, 2162300},
            {1939200, 2053100, 2139900, 2230400},
            {2000300, 2053100, 2139900, 2230400},
            {2000300, 2117700, 2207300, 2300700},
            {2063300, 2117700, 2207300, 2300700},
            {2063300, 2184400, 2276800, 2373100},
            {2128300, 2184400, 2276800, 2373100},
            {2128300, 2253200, 2348500, 2447900},
            {2195300, 2253200, 2348500, 2447900},
            {2195300, 2324200, 2422500, 2525000},
            {2264400, 2324200, 2422500, 2525000},
            {2264400, 2397400, 2498800, 2604500},
            {2335800, 2397400, 2498800, 2604500},
            {2335800, 2472900, 2557500, 2686500}
        };

        // Array tipe golongan 2
        int[][] golonganPangkat2 = {
            {2022200, 2022200, 2022200, 2022200},
            {2054100, 2054100, 2054100, 2054100},
            {2054100, 2054100, 2054100, 2054100},
            {2118800, 2208400, 2301800, 2399200},
            {2118800, 2208400, 2301800, 2399200},
            {2185500, 2277900, 2374300, 2474700},
            {2185500, 2277900, 2374300, 2474700},
            {2254300, 2349700, 2449100, 2552700},
            {2254300, 2349700, 2449100, 2552700},
            {2325300, 2423700, 2526200, 2633100},
            {2325300, 2423700, 2526200, 2633100},
            {2398600, 2500000, 2605800, 2716000},
            {2398600, 2500000, 2605800, 2716000},
            {2474100, 2578800, 2687800, 2801500},
            {2474100, 2578800, 2687800, 2801500},
            {2552000, 2660000, 2772500, 2889800},
            {2552000, 2660000, 2772500, 2889800},
            {2632400, 2743800, 2859800, 2980800},
            {2632400, 2743800, 2859800, 2980800},
            {2715300, 2830200, 2949900, 3074700},
            {2715300, 2830200, 2949900, 3074700},
            {2800800, 2919300, 3042800, 3171500},
            {2800800, 2919300, 3042800, 3171500},
            {2889100, 3011200, 3138600, 3271400},
            {2889100, 3011200, 3138600, 3271400},
            {2980000, 3106100, 3237500, 3374400},
            {2980000, 3106100, 3237500, 3374400},
            {3073900, 3203900, 3339400, 3480700},
            {3073900, 3203900, 3339400, 3480700},
            {3170700, 3304800, 3444600, 3590300},
            {3170700, 3304800, 3444600, 3590300},
            {3270600, 3408900, 3553100, 3703400},
            {3270600, 3408900, 3553100, 3703400},
            {3373600, 3516300, 3665000, 3820000},
            {3373600, 3516300, 3665000, 3820000},
            {3484300, 3628800, 3781100, 3941000}
        };

        // Array tipe golongan 3
        int[][] golonganPangkat3 = {
            {2579400, 2688500, 2802300, 2920800},
            {2579400, 2688500, 2802300, 2920800},
            {2660700, 2773200, 2890500, 3012800},
            {2660700, 2773200, 2890500, 3012800},
            {2744500, 2860500, 2981500, 3107700},
            {2744500, 2860500, 2981500, 3107700},
            {2830900, 2950600, 3075500, 3205500},
            {2830900, 2950600, 3075500, 3205500},
            {2920100, 3043600, 3172300, 3306500},
            {2920100, 3043600, 3172300, 3306500},
            {3012000, 3139400, 3272200, 3410600},
            {3012000, 3139400, 3272200, 3410600},
            {3106900, 3238300, 3375300, 3518100},
            {3106900, 3238300, 3375300, 3518100},
            {3204700, 3340300, 3481600, 3628900},
            {3204700, 3340300, 3481600, 3628900},
            {3305700, 3445500, 3591200, 3743100},
            {3305700, 3445500, 3591200, 3743100},
            {3409800, 3554000, 3704300, 3861000},
            {3409800, 3554000, 3704300, 3861000},
            {3517200, 3665900, 3821000, 3982600},
            {3517200, 3665900, 3821000, 3982600},
            {3627900, 3781400, 3941400, 4108100},
            {3627900, 3781400, 3941400, 4108100},
            {3742200, 3900500, 4065500, 4237500},
            {3742200, 3900500, 4065500, 4237500},
            {3860100, 4023300, 4193500, 4370900},
            {3860100, 4023300, 4193500, 4370900},
            {3981600, 4150100, 4325600, 4508600},
            {3981600, 4150100, 4325600, 4508600},
            {4107000, 4280800, 4461800, 4650600},
            {4107000, 4280800, 4461800, 4650600},
            {4236400, 4415600, 4602400, 4797000}
        };

        // Array tipe golongan 4
        int[][] golonganPangkat4 = {
            {3044300, 3173100, 3307300, 3447200, 3593100},
            {3044300, 3173100, 3307300, 3447200, 3593100},
            {3140200, 3272100, 3411500, 3555800, 3706200},
            {3140200, 3272100, 3411500, 3555800, 3706200},
            {3239100, 3376100, 3518900, 3667800, 3822900},
            {3239100, 3376100, 3518900, 3667800, 3822900},
            {3341100, 3482500, 3629800, 3783300, 3943300},
            {3341100, 3482500, 3629800, 3783300, 3943300},
            {3446400, 3592100, 3744100, 3902500, 4067500},
            {3446400, 3592100, 3744100, 3902500, 4067500},
            {3554900, 3705300, 3862000, 4025400, 4195700},
            {3554900, 3705300, 3862000, 4025400, 4195700},
            {3666900, 3822000, 3983600, 4152200, 4327800},
            {3666900, 3822000, 3983600, 4152200, 4327800},
            {3782400, 3942400, 4109100, 4282900, 4456100},
            {3782400, 3942400, 4109100, 4282900, 4456100},
            {3901500, 4066500, 4238500, 4417800, 4594700},
            {3901500, 4066500, 4238500, 4417800, 4594700},
            {4024400, 4194600, 4367200, 4557000, 4749700},
            {4024400, 4194600, 4367200, 4557000, 4749700},
            {4151100, 4326700, 4509700, 4700500, 4899300},
            {4151100, 4326700, 4509700, 4700500, 4899300},
            {4281800, 4463000, 4651800, 4848500, 5053600},
            {4281800, 4463000, 4651800, 4848500, 5053600},
            {4416700, 4603500, 4798300, 5001200, 5212800},
            {4416700, 4603500, 4798300, 5001200, 5212800},
            {4555800, 4748500, 4949400, 5158700, 5377000},
            {4555800, 4748500, 4949400, 5158700, 5377000},
            {4699300, 4898100, 5105300, 5321200, 5546300},
            {4699300, 4898100, 5105300, 5321200, 5546300},
            {4847300, 5042300, 5266100, 5488800, 5721000},
            {4847300, 5042300, 5266100, 5488800, 5721000},
            {5000000, 5211500, 5431900, 5661700, 5901200}
        };

        //Konversi golongan pangkat ke indeks array
        int indeksTipeGolongan = -1;
        if(tipeGolongan.equalsIgnoreCase("A")){
            indeksTipeGolongan = 0;
        }else if(tipeGolongan.equalsIgnoreCase("B")){
            indeksTipeGolongan = 1;
        }else if(tipeGolongan.equalsIgnoreCase("C")){
            indeksTipeGolongan = 2;
        }else if(tipeGolongan.equalsIgnoreCase("D")){
            indeksTipeGolongan = 3;
        }else if(tipeGolongan.equalsIgnoreCase("E")){
            indeksTipeGolongan = 4;
        }

        //Menentukan gaji pokok
        if(golonganPangkat == 1){
            if(masaKerja>27){
                result = golonganPangkat1[27][indeksTipeGolongan];
            }else{
                result = golonganPangkat1[masaKerja][indeksTipeGolongan];
            }  
        }else if(golonganPangkat == 2){
            if(masaKerja>33){
                result = golonganPangkat2[33][indeksTipeGolongan];
            }else{
                result = golonganPangkat2[masaKerja][indeksTipeGolongan];
            }
        }else if(golonganPangkat == 3){
            if(masaKerja>32){
                result = golonganPangkat3[32][indeksTipeGolongan];
            }else{
                result = golonganPangkat3[masaKerja][indeksTipeGolongan];
            }
        }else if(golonganPangkat == 4){
            if(masaKerja>32){
                result = golonganPangkat4[32][indeksTipeGolongan];
            }else{
                result = golonganPangkat4[masaKerja][indeksTipeGolongan];
            }
        }

        return result;
    }

    // Menentukan jumlah tunjangan keluarga berdasarkan status pernikahan dan gaji pokok
    public static int kalkulasiTunjanganKeluarga(String statusPernikahan,int gajiPokok){
        int result = 0;
        
        if(statusPernikahan.equalsIgnoreCase("Kawin")){
            result = gajiPokok * 10 / 100; 
        }else{
            result = 0;
        }
        return result;
    }

    // Menentukan jumlah tunjangan anak berdasarkan jumlah anak dan gaji pokok
    public static int kalkulasiTunjanganAnak(int jumlahAnak, int gajiPokok){
        int result = 0;
        int persentaseTunjanganPerAnak = 2;

        if(jumlahAnak==1){
            result = gajiPokok * persentaseTunjanganPerAnak / 100;
        }else if(jumlahAnak>=2){
            result = gajiPokok * persentaseTunjanganPerAnak * 2 / 100;
        }else{
            result = 0;
        }
        return result;
    }

    // Menentukan jumlah tunjangan beras berdasarkan status pernikahan dan jumlah anak
    public static int kalkulasiTunjanganBeras(String statusPernikahan, int jumlahAnak){
        int result = 0;
        int jumlahBeras = 10;
        int hargaBeras = 15000;

        if(statusPernikahan.equalsIgnoreCase("Kawin")){
            if(jumlahAnak==1){
            result = jumlahBeras * hargaBeras * 3;
            }else if(jumlahAnak>=2){
            result = jumlahBeras * hargaBeras * 4;
            }else{
            result = jumlahBeras * hargaBeras * 2;
            }
        }else if(statusPernikahan.equalsIgnoreCase("Cerai")){
            if(jumlahAnak==1){
            result = jumlahBeras * hargaBeras * 2;
            }else if(jumlahAnak>=2){
            result = jumlahBeras * hargaBeras * 3;
            }else{
            result = jumlahBeras * hargaBeras * 1;
            }
        }else{
            result = jumlahBeras * hargaBeras;
        }

        return result;
    }

    // Menentukan jumlah tunjangan umum jabatan berdasarkan golongan pangkat
    public static int kalkulasiTunjanganUmumJabatan(int golonganPangkat){
        int result = 0;
        switch(golonganPangkat){
            case 1:
            result = 175000;
            break;
            case 2:
            result = 180000;
            break;
            case 3:
            result = 185000;
            break;
            case 4:
            result = 190000;
            break;
        }

        return result;
    }

    //Menentukan jumlah gaji kotor 
    public static int kalkulasiGajiKotor(int gajiPokok,int tunjanganAnak,int tunjanganKeluarga,int tunjanganUmumJabatan,int tunjanganBeras){
        int result = 0;
        result = gajiPokok + tunjanganKeluarga + tunjanganAnak + tunjanganBeras + tunjanganUmumJabatan;
    
        return result;
    }

    //Menentukan jumlah potongan Pph
        public static int kalkulasiPotonganPPH(int gajiPokok,String statusPernikahan,int gajiKotor,int jumlahAnak,int tunjanganKeluarga,int tunjanganAnak){
            int result = 0;

            //Menghitung penghasilan neto
            int biayaJabatan = gajiKotor * 5 / 100;
            double iuranPensiun = (gajiPokok + tunjanganKeluarga + tunjanganAnak) *4.75 / 100;
            int penghasilanNeto = gajiKotor - biayaJabatan - (int)iuranPensiun;
            int penghasilanNetoTahunan = penghasilanNeto * 12;
            

            //Menghitung pajak PTKP
            int pajakSendiri = 36000000;
            int pajakPasangan = 3000000;
            int pajakPerAnak = 3000000;
            int ptkp = 0;
            if(statusPernikahan.equalsIgnoreCase("Kawin")){
                if(jumlahAnak<3 ){
                    ptkp = pajakSendiri + pajakPasangan + (pajakPerAnak * jumlahAnak); 
                }else if(jumlahAnak > 3){
                    ptkp = pajakSendiri + pajakPasangan + (pajakPerAnak * 3);
                }
            }else if(statusPernikahan.equalsIgnoreCase("Cerai")){
            if(jumlahAnak<3 ){
                    ptkp = pajakSendiri + (pajakPerAnak * jumlahAnak); 
                }else if(jumlahAnak > 3){
                    ptkp = pajakSendiri + (pajakPerAnak * 3);
                }
            }else {
                ptkp = pajakSendiri;
            }

            //Menghitung penghasilan kena pajak
            int penghasilanKenaPajak = penghasilanNetoTahunan - ptkp;

            //Menghitung jumlah pajak Pph
            int pajakPph = 5;
            if(gajiKotor >= 4500000){
                result = (penghasilanKenaPajak * pajakPph / 100) / 12;
            }else{
                result = 0;
            }

            return result;
        }

    //Menentukan jumlah potongan IWP
    public static int kalkulasiPotonganIWP(int gajiPokok,int tunjanganAnak,int tunjanganKeluarga){
        int result = 0;
        result = (gajiPokok + tunjanganAnak + tunjanganKeluarga) * 10/100;

        return result;
    }

    //Menentukan jumlah potongan Taperum
    public static int kalkulasiPotonganTaperum(int golonganPangkat){
        int result = 0;
        switch(golonganPangkat){
            case 1:
            result = 3000;
            break;
            case 2:
            result = 5000;
            break;
            case 3:
            result = 7000;
            break;
            case 4:
            result = 10000;
            break;
        }

        return result;
    }

    //Menentukan total gaji bersih
    public static int kalkulasiGajiBersih(int gajiKotor, int potonganPPH, int potonganIWP,int potonganTaperum){
        int result = 0;
        result = gajiKotor - potonganPPH - potonganIWP - potonganTaperum;

        return result;
    }

    public static void displayOutput(String nama, int gajiPokok, int tunjanganKeluarga, int tunjanganAnak, int tunjanganBeras, int tunjanganUmumJabatan, int gajiKotor, int potonganPPH, int potonganIWP, int potonganTaperum, int gajiBersih) {

        //Konversi semua output int ke rupiah
        NumberFormat formatCurrency = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

        String formattedGajiPokok = formatCurrency.format(gajiPokok);
        String formattedTunjanganKeluarga = formatCurrency.format(tunjanganKeluarga);
        String formattedTunjanganAnak = formatCurrency.format(tunjanganAnak);
        String formattedTunjanganBeras = formatCurrency.format(tunjanganBeras);
        String formattedTunjanganUmumJabatan = formatCurrency.format(tunjanganUmumJabatan);
        String formattedGajiKotor = formatCurrency.format(gajiKotor);
        String formattedPotonganPPH = formatCurrency.format(potonganPPH);
        String formattedPotonganIWP = formatCurrency.format(potonganIWP);
        String formattedPotonganTaperum = formatCurrency.format(potonganTaperum);
        String formattedGajiBersih = formatCurrency.format(gajiBersih);

        //Menampilkan output dalam bentuk Rupiah
        System.out.println("Rincian Gaji PNS");
        System.out.println("=======================================================");
        System.out.println("");
        System.out.println("Nama                  : " + nama);
        System.out.println("Gaji Pokok            : " + formattedGajiPokok);
        System.out.println("Tunjangan Keluarga    : " + formattedTunjanganKeluarga);
        System.out.println("Tunjangan Anak        : " + formattedTunjanganAnak);
        System.out.println("Tunjangan Beras       : " + formattedTunjanganBeras);
        System.out.println("Tunjangan Umum Jabatan: " + formattedTunjanganUmumJabatan);
        System.out.println("Gaji Kotor            : " + formattedGajiKotor);
        System.out.println("Potongan PPH          : " + formattedPotonganPPH);
        System.out.println("Potongan IWP          : " + formattedPotonganIWP);
        System.out.println("Potongan Taperum      : " + formattedPotonganTaperum);
        System.out.println("Gaji Bersih           : " + formattedGajiBersih);
        System.out.println("");
        System.out.println("=======================================================");
        
    }
}


