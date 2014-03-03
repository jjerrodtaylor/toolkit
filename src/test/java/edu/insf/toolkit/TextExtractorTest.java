package edu.insf.toolkit;

import edu.insf.toolkit.Tools.Constants;
import edu.insf.toolkit.Tools.TextExtractor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 1/16/14
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class TextExtractorTest
{

    public TextExtractor textExtractor = new TextExtractor();
    public File testFile = new File(Constants.METAMORPH_ESP);

    @Test
    public void testTurnToFile()
    {
        File file = textExtractor.turnToFile(Constants.METAMORPH_ESP);
        assertEquals(testFile.getAbsolutePath(), file.getAbsolutePath());
    }

    @Test
    public void testGetPDFTextByPage()
    {
        File file = textExtractor.turnToFile(Constants.METAMORPH_ESP);
        String firstPage = textExtractor.getPDFTextByPage(file,0);
        assertTrue(firstPage.contains("Contenidos"));
    }
}
