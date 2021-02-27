public class Pit
{
    private int stone;
    private Pit next;
    
    public Pit(int stone)
    {
        this.stone = stone;
    }
    
    public void setStone(int stone)
    {
        this.stone = stone;
    }
    
    public int getStone()
    {
        return stone;
    }
    
    public void setNext(Pit next)
    {
        this.next = next;
    }
    
    public Pit getNext()
    {
        return next;
    }
}
