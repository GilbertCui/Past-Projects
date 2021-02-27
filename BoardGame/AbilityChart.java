public class AbilityChart
{
    private Ability[] chart;
    
    public AbilityChart()
    {
        chart = new Ability[11];
        chart[0] = new Ability("Attack", -10.0, 0, 0);
        chart[1] = new Ability("Heal", 60.0, 0, -40);
        chart[2] = new Ability("Poison", -5.0, 3, -20);
        chart[3] = new Ability("Eat A Burger", 10.0, 3, -20);
        chart[4] = new Ability("Strength Buff", 1, 5, -30);
        chart[5] = new Ability("Strength Debuff", 0.5, 4, -30);
        chart[6] = new Ability("Shield", 100.0, 0, -70);
        chart[7] = new Ability("Purify", 1.0, 0, -70);
        chart[8] = new Ability("Snare", 0.0, 2, -50);
        chart[9] = new Ability("Instant Kill", 0.0, 0, -70);
        chart[10] = new Ability("Magic Potion", 20.0, 0, 0);
    }
    
    public Ability getAbility(int index)
    {
        return chart[index];
    }
    
    public String getAbilityName(int index)
    {
        return chart[index].getName();
    }
    
    public double getAbilityEffect(int index)
    {
        return chart[index].getEffect();
    }
    
    public int getAbilityCost(int index)
    {
        return chart[index].getCost();
    }
    
    public String toString()
    {
        String display = "Ability Chart";
        for (int index = 0; index < 12; index++)
            display += chart[index].toString()+"\n";
        return display;
    }
}