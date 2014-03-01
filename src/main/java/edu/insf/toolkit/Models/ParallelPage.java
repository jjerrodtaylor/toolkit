package edu.insf.toolkit.Models;

import java.util.ArrayList;
import java.util.LinkedList;

public class ParallelPage extends BPage
{
    BPage l1 = new BPage();
    BPage l2 = new BPage();
    ArrayList<LinkedList<String>> undividedTexts = new ArrayList<LinkedList<String>>();

    public ParallelPage()
    {
        super();
    }

    public BPage getL1()
    {
        return l1;
    }

    public void setL1(BPage l1)
    {
        this.l1 = l1;
    }

    public BPage getL2()
    {
        return l2;
    }

    public void setL2(BPage l2)
    {
        this.l2 = l2;
    }

    public ArrayList<LinkedList<String>> getUndividedTexts()
    {
        return undividedTexts;
    }

    public void setUndividedTexts(ArrayList<LinkedList<String>> undividedTexts)
    {
        this.undividedTexts = undividedTexts;
    }

    public LinkedList<LinkedList<String>> divideLadderText(ArrayList<String> combinedText)
    {
        String[] newStrings;
        LinkedList<LinkedList<String>> seperatedTexts = new LinkedList<LinkedList<String>>();
        LinkedList<String> l1Text = new LinkedList<String>();
        LinkedList<String> l2Text = new LinkedList<String>();

        for(String s: combinedText)
        {
            newStrings = s.split("\\t");
            if(newStrings.length == 2 | newStrings.length == 3)
            {
                l1Text.add(newStrings[0]);
                l2Text.add(newStrings[1]);
            }
            else
            {
                l1Text.add(newStrings[0]);
                l2Text.add("");
            }
        }

        this.getL1().setTokenizedPage(l1Text);
        this.getL2().setTokenizedPage(l2Text);
        seperatedTexts.add(l1Text);
        seperatedTexts.add(l2Text);
        return seperatedTexts;
    }
}
