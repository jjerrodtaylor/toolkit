package edu.insf.toolkit.DesignPatterns.Factory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 1/15/14
 * Time: 10:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class IOBufferedReader extends IOBuffered
{
    private BufferedReader br = null;

    public IOBufferedReader(String filePath)
    {
        super(IOType.BUFFERED_READER);
        this.construct(filePath);
    }

    @Override
    protected void construct(String filePath)
    {
        try
        {
            this.br = new BufferedReader(new FileReader(filePath));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
