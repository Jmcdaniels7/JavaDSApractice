import java.util.*;

class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {

        // so we need a map of strings as keys and 
        //a list of strings as the values
        Map<String, List<String>> res = new HashMap<>();

        // for each string in strs
        for(String s : strs)
        {
            //turn string into a char array
            char[] charArr = s.toCharArray();

            //sort the array
            Arrays.sort(charArr);

            //turn sorted charArray back into string
            String sortS = new String(charArr);

            //if sortS not in map add it with a new array list
            res.putIfAbsent(sortS, new ArrayList<>());

            // I think here is where we find similar
            //sorted and then add the original string
            // to the paired value list of strings
            res.get(sortS).add(s);
        }
        
        //we return the values in the map
        return new ArrayList<>(res.values());
        
    }

    public static void main(String args[])
    {
        //2D array of List of string arrays
        List<String[]> str2D = new ArrayList<String[]>();

        String[] strO = {"act","pots","tops","cat","stop","hat"};
        String[] strT = {"x"};

        str2D.add(strO);
        str2D.add(strT);

        for(int i = 0; i < str2D.size(); i++)
        {
            System.out.println(groupAnagrams(str2D.get(i)));
        }
    }

}