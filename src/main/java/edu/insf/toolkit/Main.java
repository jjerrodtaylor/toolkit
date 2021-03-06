package edu.insf.toolkit;

import edu.insf.toolkit.HTML.HTMLPage;
import edu.insf.toolkit.Tools.Constants;
import edu.insf.toolkit.Tools.FileHelper;
import edu.insf.toolkit.Tools.TextExtractor;
import edu.insf.toolkit.Tools.TextTokenizer;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 3/21/14
 * Time: 4:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main
{
    public static void main(String args[])
    {
        FileHelper fileHelper = new FileHelper();
        TextExtractor textExtractor = new TextExtractor();
        TextTokenizer textTokenizer = new TextTokenizer();
        HTMLPage html = new HTMLPage();
        Constants constants = new Constants();


        ArrayList<String> combinedText = fileHelper.readFileToMemory(constants.aligned("aligned_l2-l1.txt"));
        ArrayList<ArrayList<String>> seperateTexts = textTokenizer.divideText(combinedText,0,1);

        String page = html.makePage(seperateTexts);
        fileHelper.writeFile(page,"metamorphosis-en-de.html");
    }
}
