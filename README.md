# java-Simulasi_Perhitungan_Gaji_PNS
Java Tujuh Sembilan, Simulasi Perhitungan Gaji PNS
Java Basic

Final Test

Time : 

480 Minutes



Table of Content : 

Variable, Boolean Expression, IF(IF, Else, Else IF), Switch-Case, Looping (FOR, WHILE, DO-WHILE), Array, Function.

Gaji PNS

Buatlah Aplikasi untuk menghitung Besar Gaji Bersih (Take Home Pay)i PNS golongan I s.d IV tahun 2019. Berdasarkan Ketentuan berikut ini:

1. Gaji Pokok, adalah besaran gaji yang didapat sesuai dengan Golongan dan Juga masa kerja Pegawai pada tahun 2019 Berdasarkan referensi berikut ini:

https://docs.google.com/spreadsheets/d/1ZLP9iglOGpSfr8M4qJkdHJ3hRZSq6yKihLRlvLwBrcI/edit?usp=sharing

Jika masa kerja melebihi masa kerja maksimal yang ada pada tabel data, maka digunakan masa kerja paling akhir (Maksimal).

2. Tunjangan keluarga, 10 % dari Gaji Pokok.

3. Tunjangan  anak, Per anak adalah 2 % dari Gaji Pokok (Max 2 Anak).

4. Tunjangan beras, 10 Kg untuk setiap anggota keluarga (Max 2 Anak, Harga beras Rp. 15.000).

5. Tunjungan Umum Jabatan, tunjangan sesuai dengan Golongan PNS:

Gol I : 175.000

Gol II : 180.000

Gol III : 185.000

Gol IV : 190.000

6. Potongan Pph, besaran pajak yang harus dibayar setiap bulannya sesuai dengan PTKP dan PKP berdasarkan perhitungan Pph 21 berikut ini:

Wajib pajak harus memiliki penghasilan bruto lebih dari 4.500.000 rupiah.

Besarnya Penghasilan Tidak Kena Pajak (PTKP) adalah sebagai berikut:

-Wajib pajak Sendiri sebesar Rp. 36.000.000.

-Wajib pajak Istri/Suami sebesar Rp. 3.000.000

-Wajib pajak per anak sebesar Rp. 3.000.000 (Max 3 Anak).

Contoh Gambaran Perhitungan Pph 21 untuk PNS yang bekerja dari Januari s.d Desember:





-Biaya Jabatan adalah 5% dari Gaji Kotor
-Iuran Pensiun adalah 4.75% dari (Gaji Pokok + Tunj. Keluarga + Tunj. Anak)
Dari contoh diatas untuk PNS dengan Gol III/D, dengan masa kerja 10 Tahun dengan Gaji Pokok Rp. 3.248.300 didapatkan besaran Pph 21 untuk setiap bulannya sebesar Rp. 14.579.

Note: Perhitungan diatas hanya sebagai gambaran atau contoh alur proses perhitungan PPH.

7. Potongan IWP (Iuran Wajib Pajak), 10% dari Gaji Pokok + Tunjangan Anak + Tunjangan Keluarga.

8. Potongan Taperum, potongan sesuai dengan Golongan PNS:

Gol I : 3.000

Gol II : 5.000

Gol III : 7.000

Gol IV : 10.000

9. Function utama yang harus ada:

kalkulasiGajiPokok(int masaKerja, String tipeGolongan,int golonganPangkat);

kalkulasiTunjanganKeluarga(String statusPernikahan,int gajiPokok);

kalkulasiTunjanganAnak(int jumlahAnak,int gajiPokok);

kalkulasiTunjanganBeras(String statusPernikahan, int jumlahAnak);

kalkulasiTunjanganUmumJabatan(int golonganPangkat);

kalkulasiGajiKotor(int gajiPokok,int tunjanganAnak,int tunjanganKeluarga,int tunjanganUmumJabatan,int tunjanganBeras);

kalkulasiPotonganPPH(int gajiPokok,String statusPernikahan,int gajiKotor,int jumlahAnak,int tunjanganKeluarga,int tunjanganAnak);

kalkulasiPotonganIWP(int gajiPokok,int tunjanganAnak,int tunjanganKeluarga);

kalkulasiPotonganTaperum(int golonganPangkat);

kalkulasiGajiBersih(int gajiKotor, int potonganPPH, int potonganIWP,int potonganTaperum);

displayOutput(String nama,int gajiPokok,int tunjanganKeluarga, int tunjanganAnak, int tunjanganBeras, int tunjanganUmumJabatan, int gajiKotor, int potonganPPH, int potonganIWP, int potonganTaperum, int gajiBersih);

Input yang harus tersedia:

1. Input Nama Pegawai

Pastikan untuk inputan ini hanya dapat menerima huruf saja (Alfabet).

2. Input  Golongan Pangkat

Pastikan untuk inputan ini tidak dapat menerima inputan data selain angka, dan hanya boleh diisi sesuai dengan Golongan Pangkat PNS, yaitu 1 s.d 4 saja.

3. Input Golongan Ruang Kerja (Tipe Golongan)

Pastikan untuk inputan ini hanya dapat menerima huruf saja (Alfabet) dan hanya boleh diisi dengan Golongan Ruang Kerja PNS. Perlu diingat kalau Golongan Pangkat 1 s.d 3 terdiri dari 4 Golongan Ruang Kerja, yaitu: A, B, C dan D. Sedangkan untuk Golongan 4 memiliki 5 Golongan Ruang Kerja, yaitu: A, B, C, D, dan E.

4. Inputan Masa Kerja

Pastikan inputan ini tidak dapat menerima inputan data selain angka, dan tidak dapat diisi dengan angka dibawah 0 Serta maksimal 50.

5. Status Pernikahan

Pastikan untuk inputan ini hanya dapat menerima huruf saja (Alfabet), dan hanya boleh diisi dengan Kawin, Belum Kawin dan Cerai.


6. Jumlah Anak

Pastikan inputan ini tidak dapat menerima inputan data selain angka, dan tidak dapat diisi dengan angka dibawah 0.





Output yang harus tersedia:

Gaji Pokok

Tunjangan Keluarga

Tunjangan Anak

Tunjangan Beras

Tunjangan Jabatan

Gaji Bruto

Potongan Pph 21

Potongan IWP

Potongan Taperum

Gaji Neto / Take Home Pay


Tampilan Aplikasi:

Untuk tampilan input maupun output dari Aplikasi disesuaikan dengan kebutuhan dan kreatifitas masing-masing, tetapi harus sesuai dengan ketentuan yang ada. Dibawah ini hanya contoh sebagai gambaran saja:


Gaji Pokok	2,053,100.00
Tunjangan keluarga	205,310.00
Tunjangan anak	41,062.00
Tunjangan beras	450,000.00
Tunjangan umum jabatan	175,000.00
Gaji Bruto	2,924,472.00
Pph	0
Potongan IWP	229,947.00
Potongan taperum	3,000.00
Gaji Take Home Pay	2,691,525.00
