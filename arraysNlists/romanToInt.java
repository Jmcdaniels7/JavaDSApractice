import java.util.Map;

public class romanToInt {

    public static int romToInt(String s)
    {
        //we need to break down the string and analyze each index
        //maybe we utilize a map for roman to integer?
        Map<Character, Integer> mp = Map.of(
            'I', 1, 
            'V', 5, 
            'X', 10,
            'L', 50,
            'C', 100,
             'D', 500,
             'M', 1000 );

        int sum = 0;

        for(int i = 0; i < s.length(); i++)
        {
            int curr = mp.get(s.charAt(i));

            //condition: if i + 1 is less than the length of the string
            //if true we say next is equal to the next roman numeral in the string
            // I think we do this to stay within the bounds of the strings length
            int next = (i + 1 < s.length()) ? mp.get(s.charAt(i + 1)) : 0;

            //edge case for subraction

            //if we can get the integer value we can compare then 
            //decide if we need to add or subract
            if(curr < next)
            {
                sum -= curr;
            }
            else
            {
                sum += curr;
            }
        }

        return sum;

    }

    public static void main(String args[])
    {
        String s = "XVIIX";

        int res = romToInt(s);

        System.out.println(res);


    }
    
}
