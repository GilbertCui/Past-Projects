import java.util.Random;
public class ShapeList
{
    private Shape[] shapeList;
    
    public ShapeList()
    {
        shapeList = new Shape[8];
        shapeList[0] = new Shape(true, true, true, true, false, 1);
        shapeList[1] = new Shape(true, false, true, true, true, 21);
        shapeList[2] = new Shape(false, true, true, true, true, 22);
        shapeList[3] = new Shape(true, true, false, true, true, 23);
        shapeList[4] = new Shape(true, true, true, false, true, 24);
        shapeList[5] = new Shape(true, false, true, false, false, 31);
        shapeList[6] = new Shape(true, true, false, false, false, 32);
        shapeList[7] = new Shape(true, false, false, false, false, 4);
    }
    
    public Shape randomShape()
    {
        Random RD = new Random();
        int randomShapeIndex = RD.nextInt(5);
        if (randomShapeIndex == 0)
            return shapeList[0];
        else if (randomShapeIndex == 1)
            return shapeList[1];
        else if (randomShapeIndex == 2)
            return shapeList[5];
        else if (randomShapeIndex == 3)
            return shapeList[3];
        else
            return shapeList[7];
    }
    
    public void display(Shape myShape)
    {
        for (int row = 0; row < 2; row++)
        {
            int jump = 0;
            for (int column = 0; column < 2; column++)
            {
                if (myShape.getFfloat() == true)
                    if (myShape.getBlock(row,column).getValue() == true)
                        System.out.print("■ ");
                    else
                        System.out.print("□ ");
                else 
                    if (myShape.getBlock(row,column).getValue() == true)
                        System.out.print("■ ");
                    else
                        jump++;
            }
            if (jump < 2)
                System.out.println();
        }
    }
    
    public Shape changeShape(Shape myShape)
    {
        if (myShape.getType() == 1)
            return shapeList[0];
        else if (myShape.getType() == 21)
            return shapeList[2];
        else if (myShape.getType() == 22)
            return shapeList[3];
        else if (myShape.getType() == 23)
            return shapeList[4];
        else if (myShape.getType() == 24)
            return shapeList[1];
        else if (myShape.getType() == 31)
            return shapeList[6];
        else if (myShape.getType() == 32)
            return shapeList[5];
        else
            return shapeList[7];
    }
}