package edu.insf.toolkit.Models;

import java.util.ArrayList;

public class ParallelPage extends BPage
{
    BPage l1 = new BPage();
    BPage l2 = new BPage();
    ArrayList<ArrayList<String>> undividedTexts = new ArrayList<ArrayList<String>>();

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

    public ArrayList<ArrayList<String>> getUndividedTexts()
    {
        return undividedTexts;
    }

    public void setUndividedTexts(ArrayList<ArrayList<String>> undividedTexts)
    {
        this.undividedTexts = undividedTexts;
    }

    public void divideLadderText(ArrayList<String> combinedText)
    {
        String[] newStrings;
        ArrayList<ArrayList<String>> seperatedTexts = new ArrayList<ArrayList<String>>();
        ArrayList<String> l1Text = new ArrayList<String>();
        ArrayList<String> l2Text = new ArrayList<String>();

        for(String s: combinedText)
        {
            newStrings = s.split("\\t");
            if(newStrings.length == 2)
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
    }
}
