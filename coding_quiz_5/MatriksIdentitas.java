package coding_quiz_5;

import java.util.Scanner;

public class MatriksIdentitas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ukuranMatriks;
        
        //input ukuran matriks
        ukuranMatriks = input.nextInt();

        //Mendapatkan matriksnya
        for(int i=0; i<ukuranMatriks; i++){
            for(int j=0; j<ukuranMatriks; j++){
                if(i==j){
                    System.out.print(1);
                }else{
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }   
}
