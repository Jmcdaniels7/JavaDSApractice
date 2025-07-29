public class stringAddition {
    public static String addString(String num1, String num2)
    {
        // we need a carry method to account for carrying over addition
        int carry = 0;
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;

        //practicing utilizing string builder
        StringBuilder sb = new StringBuilder();

        //if first string is empty we return the other integer
        if(num1.isEmpty())
        {
            return num2;
        }

        //if second string is empty we return the other integer
        if(num2.isEmpty())
        {
            return num1;
        }

        //loop until we are at the left side of the numbers
        while( l1 >= 0 || l2 >= 0 || carry != 0 )
        {
            //everytime through the loop we add digits and keep the carry to add
            int dig1 = (l1 >= 0) ? num1.charAt(l1) - '0' : 0;
            int dig2 = (l2 >= 0) ? num2.charAt(l2) - '0' : 0;

            int sum = dig1 + dig2 + carry;

            carry = sum / 10;

            sb.append(sum % 10);
            
            l1--;
            l2--;
        }

        return sb.reverse().toString();
    }
    public static void main(String args[])
    {
        String num1 = "119";
        String num2 = "25";

        String result = addString(num1, num2);

        System.out.println(result);

    }
    
}
