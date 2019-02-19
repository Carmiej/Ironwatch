/**
 * Created by blake on 10/03/2017.
 */
public class Monster {

    private String name;
    private int health;
    private int damage;
    private int Exp;
    private int gold;
    private int level;
    private String emote;
    private EnumClass.ClassType ClassType;
    private EnumClass.Weakness Weakness;


    public Monster(String name, int health, int damage, int exp, int gold, int level, String emote)
    {
        setName(name);
        setHealth(health);
        setDamage(damage);
        setExp(exp);
        setGold(gold);
        setLevel(level);
        setEmote(emote);
        //setClassType(ClassType);
        //setWeakness(Weakness);
    }


    public String getName() {
        return name;
    }
    
    public void printName()
    {
    	System.out.println(this.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public void takeDamage(int damage)
    {
    	this.health = this.health - damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getExp() {
        return Exp;
    }

    public void setExp(int exp) {
        Exp = exp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getEmote() {
        return emote;
    }

    public void setEmote(String emote) {
        this.emote = emote;
    }

    public EnumClass.ClassType getClassType() {
        return ClassType;
    }

    public void setClassType(EnumClass.ClassType classType) {
        ClassType = classType;
    }

    public EnumClass.Weakness getWeakness() {
        return Weakness;
    }

    public void setWeakness(EnumClass.Weakness weakness) {
        Weakness = weakness;
    }
}
