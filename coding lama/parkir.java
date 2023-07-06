import java.util.Scanner;
public class parkir{
    public static void main (String[] args){
        int mobil = 2000;
        int motor = 1000;
        
        Scanner input = new Scanner (System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        
        
        if(a == 1 && b > 0 && b<= 24){
            System.out.println(mobil + (1000*(b-1)));
        }else if(a == 2 && b > 0 && b<= 24){
            System.out.println(motor + (500*(b-1)));
        }
    } 
}