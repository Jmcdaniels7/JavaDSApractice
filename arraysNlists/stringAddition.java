public class stringAddition {
    public static String addStrings(String num1, String num2) {

        //we need a carry variable
        // we need two variables that start at the end of each string
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        //we also need a string builder which will be printed reversed 
        //until we reverse it

        StringBuilder sb = new StringBuilder();

        //we want to loop until we are at the beginning of one of the strings or 
        //while carry != 0
        while(i >= 0 || j >= 0 || carry != 0)
        {
            //now we need to get each digit so we can do elementary math 
            //one column at a time

            //what happens here is we get ascii subtraction with to get each digit
            int dig1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int dig2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            //we do this first to catch carry over after each time through the loop
            int sum = dig1 + dig2 + carry;

            // if the sum is greater than or equal to ten we will get carry = 1
            carry = sum / 10;

            //here we need to append the remainder of the sum / 10
            sb.append(sum % 10);

            i--;
            j--;
        }

        //here we need to reverse the string builder to get the number in proper order
        return sb.reverse().toString();
        
    }
    public static void main(String args[])
    {
        //edge cases

        //carrying over

        //differing string sizes
        String num1 = "119";
        String num2 = "25";

        //same string sizes
        String n3 = "21";
        String n4 = "99";

        //long string sizes
        String n5 = "114560000009";
        String n6 = "121150000001";

        String result = addStrings(num1, num2);
        String res2 = addStrings(n3, n4);
        String res3 = addStrings(n5, n6);

        System.out.println(result);
        System.out.println(res2);
        System.out.println(res3);

    }
    
}
