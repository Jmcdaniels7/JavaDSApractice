public class validPlaindrome {
    public static boolean isPalindrome(String s) {

        int j = s.length() -1;
        int i = 0;

        if(s.isEmpty())
        {
            return true;
        }

        while(i <= j)
        {
            if(!Character.isLetterOrDigit(s.charAt(j)))
            {
                j--;

            }
            else if (!Character.isLetterOrDigit(s.charAt(i)))
            {
                i++;
            }
            else 
            {
                if(Character.toLowerCase(s.charAt(j)) != Character.toLowerCase(s.charAt(i)))
                {
                    return false;
                }
                j--;
                i++;
            }
            
        }

        return true;
        
    }

    public static void main(String args[])
    {
        String s = "A man, a plan, a canal: Panama";


        boolean tf = isPalindrome(s);

        System.out.println(tf);
    }
    
}
