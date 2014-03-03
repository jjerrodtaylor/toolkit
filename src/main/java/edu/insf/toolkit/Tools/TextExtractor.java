package edu.insf.toolkit.Tools;

import com.snowtide.pdf.*;
import com.snowtide.pdf.PDFTextStream;
import edu.insf.toolkit.Tools.FileHelper;

import java.io.*;
import java.util.ArrayList;

public class TextExtractor
{

    public FileHelper fHelper = new FileHelper();
    private OutputTarget target = null;

    public TextExtractor()
    {
        super();
    }

    public OutputTarget getOutputTarget(BufferedWriter writer)
    {
        if(target == null)
        {
            target = new OutputTarget(writer);
        }
        return target;
    }

    public File turnToFile(String fileAddress)
    {
        File file = new File(fileAddress);
        return file;
    }

    public String getPDFTextByPage(File pdfFile, int pageNumber)
    {
        StringBuffer sb = new StringBuffer();

        try
        {
            PDFTextStream stream = new PDFTextStream(pdfFile);
            //A string buffer is like a String, but can be modified.
            OutputTarget target = new OutputTarget(sb);
            Page page = stream.getPage(pageNumber);
            page.pipe(target);
            stream.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public ArrayList<String> getChapter(File pdfFile, int startPage, int endPage)
    {
        StringBuffer sb = new StringBuffer();
        ArrayList<String> chapter = new ArrayList<String>();
        String page = null;

        for(int i=startPage; i<endPage;i++)
        {
            page = this.getPDFTextByPage(pdfFile,i);
            chapter.add(page);
        }

        return chapter;
    }
}
