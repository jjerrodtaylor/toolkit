package edu.insf.toolkit.DesignPatterns.IOTypeFactory;

import java.io.*;


public class IOBufferedWriter extends IOBuffered
{
    private BufferedWriter bw = null;

    public IOBufferedWriter(String filePath)
    {
        super(IOType.BUFFERED_WRITTER);
        construct(filePath);
    }

    @Override
    protected void construct(String filePath)
    {
        try
        {
            this.bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath),"UTF-8"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public BufferedWriter getBufferedWriter()
    {
        return this.bw;
    }
}
