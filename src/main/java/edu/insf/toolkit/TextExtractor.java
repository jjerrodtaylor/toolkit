package edu.insf.toolkit;

import com.snowtide.pdf.*;
import com.snowtide.pdf.PDFTextStream;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.*;

public class TextExtractor
{
    private PDFTextStripper stripper = null;
    private PDDocument pdfDocument = null;

    public TextExtractor()
    {
        super();
    }

    public File turnToFile(String fileAddress)
    {
        File file = new File(fileAddress);
        return file;
    }

    public String getPDFTextByPage(File pdfFile)
    {
        StringBuffer sb = new StringBuffer();

        try
        {
            PDFTextStream stream = new PDFTextStream(pdfFile);
            //A string buffer is like a String, but can be modified.
            OutputTarget target = new OutputTarget(sb);
            Page fifthPage = stream.getPage(4);
            fifthPage.pipe(target);
            stream.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public void saveText(File pdfFile, File textFile)
    {
        try
        {
            PDFTextStream stream = new PDFTextStream(pdfFile);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(textFile)));
            OutputTarget target = new OutputTarget(writer);
            stream.pipe(target);
            writer.flush();
            writer.close();
            stream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
