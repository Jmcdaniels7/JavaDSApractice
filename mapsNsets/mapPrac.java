import java.util.*;

class mapPrac {

    public static boolean isValid(String s, Map<Character, Character> nmp) {
        //we have a stack of characters
        Stack<Character> stack = new Stack<>();

        //now we loop through the string of chracters by converting
        // to a char array
        for(char c : s.toCharArray())
        {
            //we ask if the array has a key },],)
            //we set up the map so that the keys are closing brackets/parentheses
            // starting brakcets/parentheses get pushed into the stack
            // the stack helps use with the way closing brackets work
            //the last starting bracket should have a closing bracket come first next
            if(nmp.containsKey(c))
            {
                System.out.println(c + "contains");
                
                // if the stack is not empty and the top of the stack is equal to our current key
                if(!stack.isEmpty() && stack.peek() == nmp.get(c))
                {
                    stack.pop();
                }
                else
                {
                    return false;
                }
            }
            else
            {
                stack.push(c);
                System.out.println(c + "doesn't contain");
            }
        }
        return stack.isEmpty();
        
    }

    public static void main(String args[])
    {
        //we have a map of character keys to character values
        Map<Character, Character> nmp = new HashMap<>();

        // we then put into the map the key value pairs of
        //a closed bracket/parenthesis
        nmp.put(')', '(');

        nmp.put(']', '[');

        nmp.put('}', '{');

        String s = "[{()}]";

        boolean strB = isValid(s, nmp);

        System.out.println(strB);

    }

}
