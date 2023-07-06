import java.util.Scanner;

public class parkirMalming {
    public static void main(String []argh)
    {
        Scanner input = new Scanner(System.in);
        int kendaraan = input.nextInt();
        int waktu = input.nextInt();
        
        if(kendaraan == 1){
            if(waktu <=5){
                System.out.println(1500*waktu);
            }else if(waktu>5 && waktu <=8){
                System.out.println((1500*5)+(2000*(waktu-5)));
            }else{
                System.out.println("disegel");
            }
        }else if(kendaraan == 2){
            if(waktu <=5){
                System.out.println(1000*waktu);
            }else if(waktu>5 && waktu <=8){
                System.out.println((1000*5)+(1500*(waktu-5)));
            }else{
                System.out.println("disegel");
            }
        }

       
    }
}
