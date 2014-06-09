package edu.insf.toolkit.HTML;

import java.util.ArrayList;

public class HTMLPage
{
    public HTMLPage()
    {
        super();
    }

    private String page = "";

    public HTMLPage linkStyleSheet(String path)
    {
        page = page+"<link rel=\"stylesheet\" type=\"text/css\" href=\""+path+"\" />"+System.getProperty("line.separator");
        return this;
    }


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
    public HTMLPage openStyle()
    {
        page = page+"<style>"+System.getProperty("line.separator");
        return this;
    }

    public HTMLPage closeStyle()
    {
        page = page+"</style>"+System.getProperty("line.separator");
        return this;
    }

    public HTMLPage addStyle(String klass, String attribute, String value)
    {
        page = page+"."+klass+": {"+attribute+": "+value+"; }"+System.getProperty("line.separator");
        return this;
    }

    public HTMLPage openHead()
    {
        page = page+"<head>"+ System.getProperty("line.separator")+"<meta charset=\"utf-8\"/>";
        return this;
    }

    public HTMLPage closeHead()
    {
        page = page+"</head>" + System.getProperty("line.separator");
        return this;
    }

    public HTMLPage openDiv()
    {
        page = page+"<div>"+ System.getProperty("line.separator");
        return this;
    }

    public HTMLPage openDiv(String id, String klass)
    {
        page = page+"<div id="+id+" class="+klass+">" + System.getProperty("line.separator");
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
    public HTMLPage openTBody()
    {
        page = page+"<tbody>"+System.getProperty("line.separator");
        return this;
    }

    public HTMLPage closeTBody()
    {
        page = page+"</tbody>"+System.getProperty("line.separator");
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

    public HTMLPage openA()
    {
        page = page+"<a href= >"+System.getProperty("line.separator");
        return this;
    }

    public HTMLPage closeA()
    {
        page = page+"</a>";
        return this;
    }

    public HTMLPage openSpan()
    {
        page = page+"<span>"+System.getProperty("line.separator");
        return this;
    }

    public HTMLPage closeSpan()
    {
        page = page+"</span>"+System.getProperty("line.separator");
        return this;
    }

    public HTMLPage addContent(String content)
    {
        page = page+content + System.getProperty("line.separator");
        return this;
    }

    public String makeFrontParalelPage(ArrayList<String> content, String number, String paragraph)
    {
        this.openTable()
                .openTBody()
                    .openTR()
                        .openTD()
                            .openP()
                            .openA()
                            .addContent(number)
                            .closeA()
                            .openA()
                            .closeA()
                            .addContent(".")
                            .closeP()
                        .closeTD()
                        .openTD()
                            .openP()
                            .addContent(paragraph)
                            .closeP()
                        .closeTD()
                    .closeTR()
                .closeTBody()
        .closeTable();

    return this.page;
    }

    public String makePage(ArrayList<ArrayList<String>> content)
    {
        this.openHtml()
                .openHead()
                .closeHead()
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
