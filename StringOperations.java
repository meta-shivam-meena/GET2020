package scf.assignment2;

/**
 * A utility class for various operations on strings.
 * @author Shivam Kumar Meena
 * create on 16th January, 2020
 */
public class StringOperations {
    
    /**
     * It checks whether two strings are equal. It returns 1, if both
     * strings are equal(same content) and 0 otherwise.
     * @param string1 First string operand.
     * @param string2 Second string operand.
     * @return 1 if inputs string have same content and 0 otherwise.
     */
    public static int areEqual(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return 0;
        }
        for (int i = 0; i < string1.length(); i++) {
            if (string1.charAt(i) != string2.charAt(i)) {
                return 0;
            }
        }
        return 1;
    }
    
    /**
     * It returns the reverse of the given string.
     * @param string String to be reversed.
     * @return reverse of given string.
     */
    public static String reverseString(String string) {
        StringBuilder stringReversed = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            stringReversed.append(string.charAt(i));
        }
        return stringReversed.toString();
    }
    
    /**
     * It converts lower case letter to upper case and
     * upper case letters to lower case and returns the
     * resultant string.
     * @param string String whose alphabets' case needs to be toggled
     * @return string with cases of alphabets toggled.
     */
    public static String toggleCases(String string) {
        StringBuilder stringToggled = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            if (letter >= 'a' && letter <= 'z') {
                letter += ('A' - 'a'); // convert lower to upper case
            } else if (letter >= 'A' && letter <= 'Z') {
                letter += ('a' - 'A'); // convert upper to lower case
            }
            stringToggled.append(letter);
        }
        return stringToggled.toString();
    }
    
    /**
     * It finds and returns the largest word available in the 
     * given string. Words are assumed to be seprated by whitespace
     * character, comma and dot.
     * @param string String from which largest word to be found.
     * @return largest word in the given string.
     */
    public static String getLargestWord(String string) {
        int startIndex = -1;
        int wordLength = 0;
        int maxStartIndex = -1;
        int maxEndIndex = -1;
        int maxWordLength = 0;
        
        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            if (letter == ' ' || letter == '\t' || letter == '\n'
                    || letter == ',' || letter == '.') {
                if (wordLength >= maxWordLength) {
                    maxWordLength = wordLength;
                    maxStartIndex = startIndex;
                }
                wordLength = 0;
            } else {
                if (wordLength == 0) {
                    startIndex = i;
                }
                wordLength++;
            }
        }
        if (wordLength >= maxWordLength) {
            maxWordLength = wordLength;
            maxStartIndex = startIndex;
        }
        
        if (maxWordLength == 0) {
            return "";
        }
        maxEndIndex = maxStartIndex + maxWordLength;
        return string.substring(maxStartIndex, maxEndIndex);
    }
}
