package edu.insf.toolkit.Models;

import java.io.File;
import java.util.ArrayList;
import edu.insf.toolkit.Models.BPage;
import edu.insf.toolkit.Tools.FileHelper;

public class Chapter
{
    ArrayList<BPage> chapter = new ArrayList<BPage>();
    ArrayList<ParallelPage> parallelChapter = new ArrayList<ParallelPage>();
    FileHelper fileHelper = new FileHelper();

    public Chapter()
    {
        super();
    }

    public ArrayList<BPage> getChapter() {
        return chapter;
    }

    public void setChapter(ArrayList<BPage> chapter) {
        this.chapter = chapter;
    }

    public ArrayList<ParallelPage> getParallelChapter() {
        return parallelChapter;
    }

    public void setParallelChapter(ArrayList<ParallelPage> parallelChapter) {
        this.parallelChapter = parallelChapter;
    }

    public Chapter getPDFTextByChapter(File pdfFile, int startPage, int endPage)
    {
        StringBuffer sb = new StringBuffer();
        Chapter chapter = new Chapter();
        BPage page = new BPage();

        for(int i=startPage; i<endPage;i++)
        {
            page.getPDFTextByPage(pdfFile, i);
            chapter.getChapter().add(page);
        }

        return chapter;
    }

    public ArrayList<BPage> combineTextsForWriting()
    {
        ArrayList<ParallelPage> parallelPages = this.getParallelChapter();
        ArrayList<BPage> pages = new ArrayList<BPage>();

        for(int i = 0; i<parallelPages.size();i++)
        {
            pages.add(parallelPages.get(i).getL1());
            pages.add(parallelPages.get(i).getL2());
        }

        return pages;
    }



    public void writeChapter(ArrayList<ParallelPage> pages, int chapterNumber)
    {
        for(double i=0;i<pages.size();i=i+.5)
        {
            String name = "chapter"+String.valueOf(chapterNumber)+"_page_"+String.valueOf(i)+".txt";
            if(i%1==0)
            {
                fileHelper.writeFile(pages.get((int)i).getL1().getTokenizedPage(),name);
            }
            else
            {
                fileHelper.writeFile(pages.get((int)i).getL2().getTokenizedPage(),name);
            }
        }
    }

}
