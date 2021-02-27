public class Shape
{
    private Block[][] shape;
    private boolean ffloat;
    private int shapeType;
    
    public Shape(boolean tl, boolean tr, boolean bl, boolean br, boolean ffloat, int shapeType)
    {
        shape = new Block[2][2];
        shape[0][0] = new Block(tl);
        shape[0][1] = new Block(tr);
        shape[1][0] = new Block(bl);
        shape[1][1] = new Block(br);
        this.ffloat = ffloat;
        this.shapeType = shapeType;
    }
    
    public Block getBlock(int row, int column)
    {
        return shape[row][column];
    }
    
    public int getType()
    {
        return shapeType;
    }
    
    public boolean getFfloat()
    {
        return ffloat;
    }
}
