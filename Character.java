package RPG;

import java.util.Random;

public class Character {
        private int healthPoints;
        private String name;
        private double attackPower;
        private int magicPoints;
        private int magicPower;
        private boolean isAlive;
        private int numOfPotions;

        Character() {
            this.name = "Hero";
            this.healthPoints = 100;
            this.attackPower = 10;
            this.magicPoints = 100;
            this.magicPower = 30;
            this.isAlive = true;
            this.numOfPotions = 2;
        }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(double attackPower) {
        this.attackPower = attackPower;
    }

    public int getMagicPoints() {
        return magicPoints;
    }

    public void setMagicPoints(int magicPoints) {
        this.magicPoints = magicPoints;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean usePotion(){
            /*
               This function will allow a Character to use a potion.
               The statement will check if there are any potions left to use,
               it will USE it, and then take one away from numOfPotions.
             */
            if (this.numOfPotions > 0) {
                setHealthPoints(this.healthPoints + 10);
                this.numOfPotions--;
                System.out.println(getName() + " used a potion");
                return true;
            }

            return false;
    }

    //Return this as a boolean to know if it hit or not
    public boolean attack(Enemy x) { //Allows the enemy selection

        Random critical = new Random(); //Create a new random for critical chance
        int critChance = critical.nextInt(100); //Find a random number 0-100
        if (critChance <= 20){ //If the number is less than or equal to 20 perform a critical attack
            x.setHealthPoints(x.getHealthPoints() - 500);
            System.out.println("You hit a critical strike!");
        }
        else {

            Random random = new Random(); //Creates a new random
            int randomNumber = random.nextInt(20); //Runs a random number that goes 0-20
            double percent = randomNumber * .01; //Turns the random number into a percent in decimal form

            int posORneg = random.nextInt(100); //Runs a random number that is 0-100

            //If the positive or negative one is greater than equal to 50, subtract from attack power
            if (posORneg >= 50) {
                setAttackPower(this.attackPower - (this.attackPower * percent));
            }
            //If the positive or negative one is less than 50, add to the attack power
            else {
                setAttackPower(this.attackPower + (this.attackPower * percent));
            }

            //Turns the attack power from a double into an int
            int attackDamage = (int) getAttackPower();

            //Creates an int of what the current enemy health is
            int currEnemyHealth = x.getHealthPoints();

            //Lowers the enemies health by the amount of attackpower
            x.setHealthPoints(currEnemyHealth - attackDamage);

            //Tell the user that the attack was successful
            System.out.println(getName() + " attacked for " + getAttackPower() + " damage.");
        }

        //Returns true to let the computer know that the attacked work
        return true;
    }

    //Return this as a boolean to know if this hit or not
    public boolean fireball(Enemy x) {
        int currEnemyHealth = x.getHealthPoints();
        x.setHealthPoints(currEnemyHealth - this.magicPower);
        System.out.println(getName() + " sent a fireball that did " + getMagicPower() + " damage.");
        setMagicPoints(getMagicPoints() - 30);
        System.out.println(getName() + " used 30 magic points for that shot");
        return true;
    }


    @Override
    public String toString() {
        return "Character{" +
                "healthPoints=" + healthPoints +
                ", name='" + name + '\'' +
                ", attackPower=" + attackPower +
                ", magicPoints=" + magicPoints +
                ", magicPower=" + magicPower +
                ", isAlive=" + isAlive +
                ", numOfPotions=" + numOfPotions +
                '}';
    }
}
