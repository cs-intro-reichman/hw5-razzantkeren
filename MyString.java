/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int counter = 0;
        for(int i = 0; i<str.length(); i++){
            if (str.charAt(i)==ch) {
                counter++;
            }
        }
        return counter;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
            if (str1.length() > str2.length()){
               return false;
            }
            if (str1.length()==0){
               return true;
            }
            for (int i = 0; i<str1.length(); i++){
               if (countChar(str2, str1.charAt(i)) == 0){
                return false;
               }
               if(countChar(str2, str1.charAt(i)) < countChar(str1, str1.charAt(i))){
                return false;
               }
            }
           return true;
       }
    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        if (str.length()==0) {
            return "";
        }
        String returnstring = "";
        for(int i =0 ; i<str.length()-1; i++){
            returnstring += str.charAt(i) + " ";
        }
        returnstring += str.charAt(str.length()-1);
        return returnstring;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        int randomchar;
        String rString = "";
        for(int i = 0 ; i<n; i++){
            if(Math.random()>0.5){
                randomchar = 97 + (int)(Math.random()*26);
                rString += (char)randomchar;
            }
            else{
                randomchar = 65 + (int)(Math.random()*26);
                rString += (char)randomchar;
            }
        }
        rString = rString.toLowerCase();
        return rString;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
       for(int i =0; i<str2.length(); i++){
            if (str1.contains((Character.toString(str2.charAt(i))))) {
                int index =  str1.indexOf(Character.toString(str2.charAt(i)));
                str1 = str1.substring(0, index)+str1.substring(index+1);
            }
       }
       return str1;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
