package RPG;

public class Enemy {
    //Instance variables
    private int healthPoints;
    private String type;
    private int attackPower;
    private boolean isAlive;

    Enemy(){
        healthPoints = 250;
        type = "Wolf";
        attackPower = 5;
        isAlive = true;
    }

    public boolean attack(Character c) {
        int currCharHealth = c.getHealthPoints();
        c.setHealthPoints(currCharHealth - this.attackPower);
        //Tell the user that the attack was successful
        System.out.println(getType() + " attacked for 5 damage.");
        return true;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "healthPoints=" + healthPoints +
                ", type='" + type + '\'' +
                ", attackPower=" + attackPower +
                ", isAlive=" + isAlive +
                '}';
    }
}
