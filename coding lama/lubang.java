import java.util.Scanner;

public class lubang {
    public static void main(String []argh)
    {
        Scanner input = new Scanner(System.in);
        String x = input.nextLine();
        
        int lubang =0;
        for(int i = 0; i < x.length(); i++){
        char y = x.charAt(i);
            if(y=='A'||y=='D'||y=='O'||y=='P'||y=='Q'||y=='R'||y=='4'||y=='6'||y=='9'||y=='0') {
                lubang++;
            }
            if (y=='B'||y=='8') {
                int lubang = lubang+2;
            }
        }
    System.out.println(lubang);

    }
}
