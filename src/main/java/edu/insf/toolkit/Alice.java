package edu.insf.toolkit;
import edu.insf.toolkit.HTML.HTMLPage;
import edu.insf.toolkit.Tools.Constants;
import edu.insf.toolkit.Tools.FileHelper;
import edu.insf.toolkit.Tools.TextExtractor;
import edu.insf.toolkit.Tools.TextTokenizer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;


public class Alice
{
    public static void main(String args[])
    {
        FileHelper fileHelper = new FileHelper();
        TextExtractor textExtractor = new TextExtractor();
        TextTokenizer textTokenizer = new TextTokenizer();
        HTMLPage html = new HTMLPage();
        Constants constants = new Constants();


        ArrayList<String> book = fileHelper.readFileToMemory(constants.books("metamorphosis_aligned.txt"));
        textTokenizer.divideText(book,0,1);
        //fileHelper.writeFile(englishText,constants.books("alice_en.txt"));
        /*Document alice = Jsoup.parse(combinedText.toString());
        ArrayList<String> noNewLines = textTokenizer.replaceNewLines(book);
        ArrayList<String> tokenized = textTokenizer.tokenize(noNewLines.toString(), "spa");
        fileHelper.writeFile(tokenized,constants.tokenized("alicia_es.txt"));*/


    }


}
