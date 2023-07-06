import java.util.Scanner;
public class ProgramSatpam {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int jenisKasus, jumlahKasus;
        String dendaParkir;

        //input kasus
        jenisKasus = input.nextInt();
        jumlahKasus = input.nextInt();

        dendaParkir = getDendaParkir(jenisKasus, jumlahKasus);
        System.out.print(dendaParkir);


    //Menentukan hukuman
    public static int getDendaParkir(int jenisKasus, int jumlahKasus){
        String result = "Input Error";
        int maksimalKasus = 3;
        int minimalKasus = 1;

        //Menentukan jenis pelanggaran
        if(jenisKasus == 1){
            if(jumlahkasus >= minimalKasus && jumlahKasus <= maksimalKasus){
                result =  "";
            }else if(jumlahKasus > maksimalKasus){
                result = "";
            }
        }else if (jenisKasus == 2){
            result = "";
        }
    }
    return result;
    }
}
