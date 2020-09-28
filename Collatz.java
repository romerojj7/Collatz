import java.util.Scanner;
import java.util.HashMap;
public class Collatz
{
    private static HashMap<Long, Integer> table;

    private static int collatzLength(long x)
    {
        if (x == 1)
        {
            return 1;
        }
        else if (table.containsKey(x))
        {
            return table.get(x);
        }
        else if (x % 2 == 0)
        {
            return collatzLength((x/2)) + 1; 
        }
        else
        {
            return collatzLength((3*x) + 1) + 1;
        }
    }

    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the range: "); 
        int x = kb.nextInt();
        int y = kb.nextInt();
        int cLength = 0;
        long  max = 0;
        table = new HashMap<Long, Integer>(y + 1);

        for (long c = x; c <= y; c++)
        {
                int len = collatzLength(c);
                table.put(c, len);
                if (cLength < len)
                {
                    cLength = len;
                    max = c;
                }
        }

        System.out.println("The number with the maximum Collatz length in the range: " + max);
        System.out.println("Its Collatz length: " + cLength);
    }
}
