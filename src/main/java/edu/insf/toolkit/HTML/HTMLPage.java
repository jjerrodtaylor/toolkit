package edu.insf.toolkit.HTML;


import java.util.ArrayList;

public class HTMLPage
{
    public HTMLPage()
    {
        super();
    }

    private String page = "";

    public HTMLPage openHtml()
    {
        page = page+"<html>" + System.getProperty("line.separator");
        return this;
    }

    public HTMLPage closeHtml()
    {
        page = page+"</html>" + System.getProperty("line.separator");
        return this;
    }

    public HTMLPage openTable()
    {
        page = page+"<table>" + System.getProperty("line.separator");
        return this;
    }

    public HTMLPage closeTable()
    {
        page = page+"</table>" + System.getProperty("line.separator");
        return this;
    }

    public HTMLPage openBody()
    {
        page = page+"<body>" + System.getProperty("line.separator");
        return this;
    }

    public HTMLPage closeBody()
    {
        page = page+"</body>" + System.getProperty("line.separator");
        return this;
    }

    public HTMLPage openHead()
    {
        page = page+"<head>" + System.getProperty("line.separator");
        return this;
    }

    public HTMLPage closeHead()
    {
        page = page+"</head>" + System.getProperty("line.separator");
        return this;
    }

    public HTMLPage openDiv()
    {
        page = page+"<div>" + System.getProperty("line.separator");
        return this;
    }

    public HTMLPage closeDiv()
    {
        page = page+"</div>" + System.getProperty("line.separator");
        return this;
    }

    public HTMLPage openTD()
    {
        page = page+"<td>" + System.getProperty("line.separator");
        return this;
    }

    public HTMLPage closeTD()
    {
        page = page+"</td>" + System.getProperty("line.separator");
        return this;
    }

    public HTMLPage openTR()
    {
        page = page+"<tr>" + System.getProperty("line.separator");
        return this;
    }

    public HTMLPage closeTR()
    {
        page = page+"</tr>" + System.getProperty("line.separator");
        return this;
    }

    public HTMLPage openP()
    {
        page = page+"<p>" + System.getProperty("line.separator");
        return this;
    }

    public HTMLPage closeP()
    {
        page = page+"</p>" + System.getProperty("line.separator");
        return this;
    }

    public HTMLPage addContent(String content)
    {
        page = page+content + System.getProperty("line.separator");
        return this;
    }

    public String makePage(ArrayList<ArrayList<String>> content)
    {
        this.openHtml()
                .openBody()
                .openTable();

        for(int i=0;i<content.get(0).size(); i++)
        {
            this.openTR()
                    .openTD()
                    .openP()
                    .addContent(content.get(0).get(i))
                    .closeP()
                    .closeTD()
                    .openTD()
                    .openP()
                    .addContent(content.get(1).get(i))
                    .closeP()
                    .closeTD()
                    .closeTR();
        }
        this.closeTable()
                .closeBody()
                .closeHtml();

        return this.page;
    }


}
