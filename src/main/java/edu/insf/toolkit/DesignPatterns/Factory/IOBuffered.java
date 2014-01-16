package edu.insf.toolkit.DesignPatterns.Factory;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

public abstract class IOBuffered
{
    public IOBuffered()
    {
        super();
    }

    public IOBuffered(IOType type)
    {
        this.ioType = type;
    }
    List<String> s = new ArrayList<String>();

    private IOType ioType = null;

    //Do subclass level processing in this method
    protected abstract void construct(String filePath);


    public IOType getIoType()
    {
        return ioType;
    }

    public void setIoType(IOType type)
    {
        this.ioType = type;
    }
}
