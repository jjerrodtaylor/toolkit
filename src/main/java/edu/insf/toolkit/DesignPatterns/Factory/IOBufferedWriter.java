package edu.insf.toolkit.DesignPatterns.Factory;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
            this.bw = new BufferedWriter(new FileWriter(filePath));
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
