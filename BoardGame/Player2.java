import java.util.Random;
public class Player2 extends PlayerData
{
    private double damage;
    private int damagePoints = 0;
    private double defence;
    private int defencePoints = 0;
    private double[] technique = new double[2];
    private int techniquePoints = 0;
    private double speed;
    private int speedPoints = 0;
    private Ability[] playerAbility = new Ability[4];
    private int abilityCount = 1;
    private AbilityChart allAbility = new AbilityChart();
    private Random RD = new Random();
    private int odds = RD.nextInt(3);
	private int poisonConIndex = 0;
	private int burgerConIndex = 0;
	private int buffConIndex = 0;
	private int debuffConIndex = 0;
    
    public Player2()
    {
        damage = 1.0;
        defence = 1.0;
        technique[0] = 0.5;
        technique[1] = 1.0;
        speed = 0.0;
        playerAbility[0] = allAbility.getAbility(0);
		playerAbility[1] = allAbility.getAbility(0);
		playerAbility[2] = allAbility.getAbility(0);
		playerAbility[3] = allAbility.getAbility(0);
    }
    
    public void setPlayerAbility(int ability)
    {
        playerAbility[abilityCount] = allAbility.getAbility(ability); 
        abilityCount++;
    }
    
    public String getAbilityName(int index)
    {
        return playerAbility[index].getName();
    }
    
    public int getAbilityContinuity(int index)
    {
        return playerAbility[index].getContinuity();
    }
    
	public int getAllAbilityCost(int index)
	{
		return allAbility.getAbilityCost(index);
	}
	
    public double getHP()
    {
        return player2HP;
    }
    
    public double getMP()
    {
        return player2MP;
    }
	
	public double getShield()
	{
		return player2Shield;
	}
	
	public int getPlayer2PoisonCon(int index)
	{
		return player2PoisonCon[index];
	}
	
	public void setPlayer2PoisonCon(int index, int conDecline)
	{
		player2PoisonCon[index] += conDecline;
	}
	
	public int getPlayer2BurgerCon(int index)
	{
		return player2BurgerCon[index];
	}
	
	public void setPlayer2BurgerCon(int index, int conDecline)
	{
		player2BurgerCon[index] += conDecline;
	}
	
	public int getPlayer2BuffCon(int index)
	{
		return player2BuffCon[index];
	}
	
	public void setPlayer2BuffCon(int index, int conDecline)
	{
		player2BuffCon[index] += conDecline;
	}
	
	public int getPlayer2DebuffCon(int index)
	{
		return player2DebuffCon[index];
	}
    
	public void setPlayer2DebuffCon(int index, int conDecline)
	{
		player2DebuffCon[index] += conDecline;
	}
	
    public void setDamage(int points)
    {   
        damagePoints += points;
        damage += 0.5*points;
    }
	
	public int getDamagePoints()
	{
		return damagePoints;
	}
    
    public void setDefence(int points)
    {   
        defencePoints += points;
        defence += (-1/6)*points;
    }
	
	public int getDefencePoints()
	{
		return defencePoints;
	}
    
    public void setTechnique(int points)
    {   
        techniquePoints += points;
        technique[0] += 0.625*points;
        technique[1] += points;
    }
    
	public int getTechniquePoints()
	{
		return techniquePoints;
	}
    
	
    public void setSpeed(int points)
    {   
        speedPoints += points;
        speed += 0.15*points;
    }
    
	public int getSpeedPoints()
	{
		return speedPoints;
	}
	
    public double getSpeed()
    {
        return speed;
    }
    
    // use different abilities
    public void useAbility(int index)
    {
        switch (playerAbility[index].getName())
        {
            case "Attack":
				if (player2MP <  Math.abs(playerAbility[index].getCost()))
					break;
                player1HP += playerAbility[index].getEffect()*damage*player2Status;
				player2MP += playerAbility[index].getCost();
                break;
            case "Heal":
                if (player2MP <  Math.abs(playerAbility[index].getCost()))
					break;
				player2HP += playerAbility[index].getEffect();
                player2MP += playerAbility[index].getCost();
				if (player2HP > 200.0)
					player2HP = 200.0;
                break;
            case "Poison":
				if (player2MP <  Math.abs(playerAbility[index].getCost()))
					break;
                player1HP += playerAbility[index].getEffect()*damage*player2Status;
				player2PoisonCon[poisonConIndex] = playerAbility[index].getContinuity();
				poisonConIndex++;
                player2MP += playerAbility[index].getCost();
                break;
            case "Eat A Burger":
				if (player2MP <  Math.abs(playerAbility[index].getCost()))
					break;
                player2HP += playerAbility[index].getEffect();
				player2BurgerCon[burgerConIndex] = playerAbility[index].getContinuity();
				burgerConIndex++;
                player2MP += playerAbility[index].getCost();
				if (player2HP > 200.0)
					player2HP = 200.0;
                break;
            case "Strength Buff":
				if (player2MP <  Math.abs(playerAbility[index].getCost()))
					break;
                player2Status += playerAbility[index].getEffect()*technique[0];
				player2BuffCon[buffConIndex] = playerAbility[index].getContinuity();
				buffConIndex++;
                player2MP += playerAbility[index].getCost();
                break;
            case "Strength Debuff":
				if (player2MP <  Math.abs(playerAbility[index].getCost()))
					break;
                player1Status *= playerAbility[index].getEffect();
				player2DebuffCon[debuffConIndex] = playerAbility[index].getContinuity()*(int)technique[1];
				debuffConIndex++;
                player2MP += playerAbility[index].getCost();
                break;
			case "Shield":
				if (player2MP <  Math.abs(playerAbility[index].getCost()))
					break;
				player2Shield = playerAbility[index].getEffect();
				player2MP += playerAbility[index].getCost();
				break;
            case "Purify":
				if (player2MP <  Math.abs(playerAbility[index].getCost()))
					break;
                if (player2Status < 1)
                    player2Status = playerAbility[index].getEffect();
                if (player1Status > 1)
                    player1Status = playerAbility[index].getEffect();
				for (int conIndex = 0; conIndex < 10; conIndex++)
				{	
					player1PoisonCon[conIndex] = (int)playerAbility[index].getEffect()-(int)playerAbility[index].getEffect();
					player1BurgerCon[conIndex] = (int)playerAbility[index].getEffect()-(int)playerAbility[index].getEffect();
					player1BuffCon[conIndex] = (int)playerAbility[index].getEffect()-(int)playerAbility[index].getEffect();
					player1DebuffCon[conIndex] = (int)playerAbility[index].getEffect()-(int)playerAbility[index].getEffect();
				}
                player2MP += playerAbility[index].getCost();
                break;
            case "Snare":
				if (player2MP <  Math.abs(playerAbility[index].getCost()))
					break;
                player1Snare = true;
                break;
            case "Instant Kill":
				if (player2MP <  Math.abs(playerAbility[index].getCost()))
					break;
                if (player1HP < 200/3)
                    if (odds == 0 || odds == 1)
                        player1HP = playerAbility[index].getEffect();
                player2MP += playerAbility[index].getCost();
                break;
            case "Magic Potion":
				if (player2MP <  Math.abs(playerAbility[index].getCost()))
					break;
                player2MP +=  playerAbility[index].getEffect();
				player2MP += playerAbility[index].getCost();
				if (player2MP > 100.0)
					player2MP = 100.0;
                break;  
        }
    }
    
    
	public void passiveAbility(int index)
	{
		switch (allAbility.getAbilityName(index))
        {
			case "Poison":
				player1HP += allAbility.getAbilityEffect(index)*damage*player2Status;
				break;
			case "Eat A Burger":
				player2HP += allAbility.getAbilityEffect(index);
				break;
			case "Strength Buff":
                player2Status += -allAbility.getAbilityEffect(index)*technique[0];
				break;
			case "Strength Debuff":
				player1Status /= allAbility.getAbilityEffect(index);
				break;
		}
	}
	
    public String playerAttributes()
    {
        String display = "Your Attributes: 1-Damage("+damagePoints+")\t2-Defence("+defencePoints+")\t3-Technique("+techniquePoints+")\t  4-Speed("+speedPoints+")";
        return display;
    }
    
    public String playerAbilities()
    {
        String display = "Your Abilities: 1-"+playerAbility[1].getName()+"\t\t2-"+playerAbility[2].getName()+"\t\t3-"+playerAbility[3].getName();
        return display;
    }
}
