package edu.insf.toolkit.DesignPatterns.IOTypeFactory;


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
