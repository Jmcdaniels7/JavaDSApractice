public class binaryStringaddition {
    public static String addBinary(String a, String b) {
        //we need to add the digits in the number seperately

        int carry = 0;
        int i = a.length()-1;
        int j = b.length()-1;
        int result = 0;

        StringBuilder sb = new StringBuilder();

        while(i >= 0 || j >= 0 || carry != 0)
        {
            int dig1 = (i >= 0) ? a.charAt(i) - '0' : 0;
            int dig2 = (j >= 0) ? b.charAt(j) - '0' : 0;

            int sum = dig1 + dig2 + carry;

            //we need binary addition
            // 1+1 = 2 we keep 1 and carry 1
            // 1+0 = no carry and we keep 1
            // 0+0 = no carry and we keep 0

            if(sum == 3)
            {
                carry = 1;
                result = 1;
            }
            else if(sum == 2)
            {
                carry = 1;
                result = 0;

            }
            else if(sum == 1 || sum == 0)
            {
                if(sum == 0)
                {
                    result = 0;
                }
                else
                {
                    carry = 0;
                    result = 1;
                }
                
            }

            sb.append(result);

            i--;
            j--;
        }

        return sb.reverse().toString();
        
    }


    public static void main(String args[])
    {
        String a = "11011";
        String b = "10101";

        String c = addBinary(a,b);

        System.out.println(c);

    }
    
}
