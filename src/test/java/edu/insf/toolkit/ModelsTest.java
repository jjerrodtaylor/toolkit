package edu.insf.toolkit;

import edu.insf.toolkit.Models.*;
import edu.insf.toolkit.Tools.Languages;
import org.junit.Before;
import org.junit.Test;
import edu.insf.toolkit.Tools.Constants;
import edu.insf.toolkit.Tools.FileHelper;
import org.odftoolkit.odfdom.type.Language;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ModelsTest
{
    public BPage page = new BPage();
    public ParallelPage parallelPage = new ParallelPage();
    public Chapter chapter = new Chapter();
    public Book book = new Book();
    public FileHelper fileHelper = new FileHelper();
    public File file;

    @Before
    public void setUp()
    {
        file = fileHelper.turnToFile(Constants.METAMORPH_ENG);
    }

    @Test
    public void testBPage()
    {
        LinkedList<String> testList = new LinkedList<String>();

        //make sure everything is null to start
        assertEquals(null,page.getUnTokenizedPage());
        assertEquals(0, page.getTokenizedPage().size());

        //get the text
        page.getPDFTextByPage(file,0);
        assertNotNull(page.getUnTokenizedPage());

        //tokenize
        page.tokenize(Languages.ENGLISH);
        assertEquals(46,page.getTokenizedPage().size());
        assertTrue(page.getTokenizedPage().get(0).contains("\n"));

        //remove the new line characters
        page.replaceNewLines();
        assertEquals(46,page.getTokenizedPage().size());
        assertFalse(page.getTokenizedPage().get(0).contains("\n"));

        testList = page.getTokenizedPage();
        assertEquals(testList,page.getTokenizedPage());

        testList = null;
        page.setTokenizedPage(testList);
        assertNull(page.getTokenizedPage());

    }

    @Test
    public void testChapter()
    {
        //chapter
    }
}
