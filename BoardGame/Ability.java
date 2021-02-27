public class Ability
{
    private String name;
    private double effect;
    private int continuity;
    private int cost;
    
    public Ability(String name, double effect, int continuity, int cost)
    {
        this.name = name;
        this.effect = effect;
        this.continuity = continuity;
        this.cost = cost;
    }
    
    public String getName()
    {
        return name;
    }
    
    public double getEffect()
    {
        return effect;
    }
    
    public int getContinuity()
    {
        return continuity;
    }
    
    public int getCost()
    {
        return cost;
    }
    
    public String toString()
    {
        String display = name+" "+effect;
        return display;
    }
}
