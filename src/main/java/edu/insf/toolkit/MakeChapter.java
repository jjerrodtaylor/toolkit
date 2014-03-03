package edu.insf.toolkit;

import edu.insf.toolkit.HTML.HTMLPage;
import edu.insf.toolkit.Tools.FileHelper;
import edu.insf.toolkit.Tools.TextExtractor;
import edu.insf.toolkit.Tools.TextTokenizer;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MakeChapter
{
    public static void main(String[] args)
    {
        //get all of the variables set up.
        FileHelper fileHelper = new FileHelper();
        TextExtractor textExtractor = new TextExtractor();
        TextTokenizer textTokenizer = new TextTokenizer();
        HTMLPage html = new HTMLPage();
        ArrayList<String> pagesInChapter = new ArrayList<String>();

        //get all of the information that is needed to write the files.
        System.out.println("Enter the path to the pdf:");
        Scanner in = new Scanner(System.in);
        String readPath = in.nextLine();

        System.out.println("Enter the start page:");
        Integer start = in.nextInt();

        System.out.println("Enter the end page:");
        Integer end = in.nextInt();

        System.out.println("Where do you want the file written?:");
        String writePath = in.nextLine();

        System.out.println("What do you want to name the file?:");
        String fileName = in.nextLine();

        //get the pdf file
        File file = fileHelper.turnToFile(readPath);

        //get the start and end page
        pagesInChapter = textExtractor.getChapter(file,start,end);
        fileHelper.writeFile(pagesInChapter,writePath+fileName);

        System.out.println("If you need to make any edits to your file do it now.");
        System.out.println("Do you want to tokenize your text (Y:N)?");
        String tokenizeResponse = in.nextLine();

        //if they want to tokenize the text then continue
        if(tokenizeResponse.equalsIgnoreCase("y"))
        {
            pagesInChapter.clear();
            //read the file back into memory
            pagesInChapter = fileHelper.readFileToMemory(writePath+fileName);
            pagesInChapter.toString();

            System.out.println("Enter a language from the choices below:");
            System.out.println("");
            //textTokenizer.tokenize(pagesInChapter, )
        }
        //System.out.println("")


    }
}
