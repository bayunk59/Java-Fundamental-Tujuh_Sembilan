import java.util.Scanner;

class Solution{
    public static void main(String []argh)
    {
        Scanner input = new Scanner(System.in);
        long a = input.nextLong();
        long b = input.nextLong();
        
        long c = a+b;
        long d = a*b;
        System.out.println(c);
        System.out.println(d);
    }
}