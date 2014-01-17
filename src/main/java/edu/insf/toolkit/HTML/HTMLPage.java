package edu.insf.toolkit.HTML;


public class HTMLPage
{
    public HTMLPage()
    {
        super();
    }

    private String page = "";

    public String openHtml()
    {
        page = page+"<html>";
        return page;
    }

    public String closeHtml()
    {
        page = page+"</html>";
        return page;
    }

    public String openTable()
    {
        page = page+"<table>";
        return page;
    }

    public String closeTable()
    {
        page = page+"</table>";
        return page;
    }

    public String openBody()
    {
        page = page+"<body>";
        return page;
    }

    public String closeBody()
    {
        page = page+"</body>";
        return page;
    }

    public String openHead()
    {
        page = page+"<head>";
        return page;
    }

    public String closeHead()
    {
        page = page+"</head>";
        return page;
    }

    public String openDiv()
    {
        page = page+"<div>";
        return page;
    }

    public String closeDiv()
    {
        page = page+"</div>";
        return page;
    }

    public String openTD()
    {
        page = page+"<td>";
        return page;
    }

    public String closeTD()
    {
        page = page+"</td>";
        return page;
    }

    public String openTR()
    {
        page = page+"<tr>";
        return page;
    }

    public String closeTR()
    {
        page = page+"</tr>";
        return page;
    }

    public String addContent(String content)
    {
        page = page+content;
        return page;
    }


}
