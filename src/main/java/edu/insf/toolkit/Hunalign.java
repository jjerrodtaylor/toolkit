package edu.insf.toolkit;
import edu.insf.toolkit.Tools.Constants;
import java.io.*;

/*
    * Every Java application has a single instance of class Runtime that allows the application
    * to interface with the environment in which the application is running. The current runtime
    * can be obtained from the getRuntime method. An application cannot create its own instance
    * of this class.
    *
    * http://docs.oracle.com/javase/7/docs/api/java/lang/Runtime.html
    * */
public class Hunalign
{
    private String cmd = null;

    public Hunalign()
    {
        super();
    }

    public void runProcess()
    {
        try
        {
            Runtime rt = Runtime.getRuntime();
            Process pr = null;

            BufferedReader  processOutput = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            BufferedReader errorOutput = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            BufferedWriter  processInput = new BufferedWriter(new OutputStreamWriter(pr.getOutputStream()));

            String command = Constants.makeFilePath("/src/main/java/resources/hunalign");
            pr = rt.exec(command);

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    /*
    * The functions below are functions for command line arguments that hunalign can take
    * */


    public Hunalign text()
    {
        cmd = " -text";
        return this;
    }

    public Hunalign bisent()
    {
        cmd = " -bisent";
        return this;
    }

    public Hunalign cautios()
    {
        cmd = " -cautios";
        return this;
    }

    public Hunalign hand(File file)
    {
        cmd = " -hand="+file.getAbsolutePath();
        return this;
    }

    public Hunalign realign()
    {
        cmd = " -realign";
        return this;
    }

    public Hunalign autodict(File file)
    {
        cmd = " -autodict"+file.getAbsolutePath();
        return this;
    }

    public Hunalign utf()
    {
        cmd = " -utf";
        return this;
    }

    public Hunalign thresh(int n)
    {
        cmd = " -thresh="+String.valueOf(n);
        return this;
    }

    public Hunalign ppthresh(int n)
    {
        cmd = " -ppthresh="+String.valueOf(n);
        return this;
    }

    public Hunalign topothresh(int n)
    {
        cmd = " -topothresh="+String.valueOf(n);
        return this;
    }


}
