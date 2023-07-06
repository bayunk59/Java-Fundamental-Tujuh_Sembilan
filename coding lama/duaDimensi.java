import java.util.Scanner;

public class duaDimensi {
    public static void main(String []argh)
    {
        Scanner input = new Scanner(System.in);
        int[][] arrX = new int[4][4];

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                arrX[i][j] = input.nextInt();
            }
        }
        int ganjil = jumlahGanjil(arrX);
        System.out.println(ganjil);
    }

    public static int jumlahGanjil(int[][] array){
        int ganjil = 0;
        for(int[] baris: array){
            for(int angka: baris){
                if(angka%2 != 0){
                    ganjil++;
                }
            }
        }
    return ganjil;
    }
}
