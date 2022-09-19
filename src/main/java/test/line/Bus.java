package test.line;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bus {
	public static int bal;
    public static void main(String... args) {
        String input = new Scanner(System.in).nextLine().trim();
        final StringTokenizer tokenizer = new StringTokenizer(input);
        bal=20000;
        while (tokenizer.hasMoreTokens()) {
            int distance = Integer.parseInt(tokenizer.nextToken());
            // @todo Write your code here.
            if(distance<4 || distance>178 || bal<720)
            	break;
            if(distance<=40)
            	bal -= 720;
            else {
            	distance = (distance - 40);
            	int price=0;
            	if(distance % 8 == 0){
            		price = distance/8;
            	}
            	else {
            		price = distance/8+1;
            	}
            	price *= 80;
            	price += 720;
            	if(bal < price)
            		break;
            	else
            		bal -= price;
            }
        }
        System.out.println(bal);
        // @todo Write your code here.
    }
}