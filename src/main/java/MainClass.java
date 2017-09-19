import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

    /**
     *
     * @author vidushiseth
     *
     */
public class MainClass {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
       String text = urlToString("http://erdani.com/tdpl/hamlet.txt");
       System.out.println(text);
       // System.out.println("The word count is " + wordCount(text) + " words");
       String myTargetWord = "your";
       int numTargetWord = specificWordCount(myTargetWord, text);
       System.out.println("The word " + myTargetWord + " appears " + numTargetWord + " times in the text");
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /**
     *
     * @param text
     * @return the number of words contained in the text
     */
    public static int wordCount(String text) {
        String[] words = text.split(" ");
        return words.length;
    }

    /**
     *
     * @param targetWord
     * @param text
     * @return number of instances of targetWords within text
     */
    public static int specificWordCount(String targetWord, String text) {
        String[] words = text.split(" ");
        int numWords = 0;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equalsIgnoreCase(targetWord)) {
                numWords++;
            }
        }
        return numWords;
    }

}
