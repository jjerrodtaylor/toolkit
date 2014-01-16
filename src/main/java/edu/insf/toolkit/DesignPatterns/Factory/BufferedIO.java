package edu.insf.toolkit.DesignPatterns.Factory;


public abstract class BufferedIO
{
    private IOType ioType = null;

    public BufferedIO(IOType type)
    {
        this.ioType = type;
    }


}
