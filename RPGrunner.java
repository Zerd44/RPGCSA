package RPG;

import java.util.Scanner;

import java.util.Random;

public class RPGrunner {

    static Character hero = new Character();
    static Character magician = new Character();
    static Character brawler  = new Character();
    static Enemy e1 = new Enemy();


    public static void main(String[] args) {

        //Set up the stats for the magician so he is better with magic
        magician.setHealthPoints(80);
        magician.setMagicPoints(200);
        magician.setMagicPower(50);
        magician.setAttackPower(5);
        magician.setName("Magician");

        brawler.setHealthPoints(150);
        brawler.setMagicPoints(0);
        brawler.setAttackPower(20);
        brawler.setName("Brawler");

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to HGP RPG!");
        int userInput = -1;

        while(userInput != 5) {
            //Menu
            System.out.println("MENU:");
            System.out.println("1. ROAM THE WORLD");
            System.out.println("2. GET CHARACTER INFO");
            System.out.println("3. REST AT INN");
            System.out.println("4. SHOP AT STORE");
            System.out.println("5. EXIT THE GAME");

            userInput = scan.nextInt();

            //Write these
            //If-else statements based on user input
            if (userInput == 1) {
                roamTheWorld();
            }
            else if (userInput == 2) {
                getAllCharInfo();
            }
            else if (userInput == 3) {
                restAllChar();
            }
            else if (userInput == 4) {
                shopAtStore();
            }
        }
    }

    static public void roamTheWorld(){
        //Creates a new random with the name r1
        Random r1 = new Random();

        System.out.println("You ran into a wild wolf!");

        //While the enemies health is greater than 0 run the loop
        while(e1.getHealthPoints() > 0) {

            //Creates a scanner called attack for attack selection
            Scanner attack = new Scanner(System.in);
            //Sets the variable at -1 to start
            int attackChoice = -1;

            //Gives the choices of attack for the hero to the player
            System.out.println(" ");
            System.out.println("Choose an attack for your Hero to use!");
            System.out.println("Press 1 to attack with your weapon");
            System.out.println("Press 2 to attack with your fireball");
            System.out.println("Press 3 to use a potion");

            //Takes next input as attack selection
            attackChoice = attack.nextInt();

            //If the selection is 1 have the hero use attack
            if (attackChoice == 1) {
                hero.attack(e1);
            }
            //If the selection is 2 have the hero use fireball
            else if (attackChoice == 2) {
                hero.fireball(e1);
            }
            //If the selection is 3 have the hero use a potion
            else if (attackChoice == 3) {
                hero.usePotion();
            }

            //Run a random number 0-100 to see what character is hit
            int rando1 = r1.nextInt(100) + 1;
            System.out.println(" "); //Blank line

            //If the random number is less than or equal to 33 have the enemy attack the hero
            if(rando1 <= 33) {
                e1.attack(hero);        //Have the enemy attack the hero
                System.out.println("The wolf attacked Hero!");
            }

            //If the random number is greater than or equal to 66 have the enemy attack the brawler
            else if(rando1 >= 66) {
                e1.attack(brawler);
                System.out.println("The wolf attacked the Brawler!");
            }

            //Otherwise have the enemy attack the wolf
            else{
                e1.attack(magician);
                System.out.println("The wolf attacked the Magician!");
            }

            //Gives the choices of attack for the magician to the player
            System.out.println(" ");
            System.out.println("Choose an attack for your Magician to use!");
            System.out.println("Press 1 to attack with your weapon");
            System.out.println("Press 2 to attack with your fireball");
            System.out.println("Press 3 to use a potion");

            //Takes next input as the attack selection
            attackChoice = attack.nextInt();

            //If the input is 1 have the magician use attack
            if (attackChoice == 1) {
                magician.attack(e1);
            }

            //If the input is 2 have the magician use fireball
            else if (attackChoice == 2) {
                magician.fireball(e1);
            }

            //If the input is 3 have the magician use a potion
            else if (attackChoice == 3) {
                magician.usePotion();
            }

            //Run a random number 0-100 to see what character is hit
            rando1 = r1.nextInt(100) + 1;
            System.out.println(" "); //Blank line

            //If the random number is less than or equal to 33 have the enemy attack the hero
            if(rando1 <= 33) {
                e1.attack(hero);        //Have the enemy attack the hero
                System.out.println("The wolf attacked Hero!");
            }

            //If the random number is greater than or equal to 66 have the enemy attack the brawler
            else if(rando1 >= 66) {
                e1.attack(brawler);
                System.out.println("The wolf attacked the Brawler!");
            }

            //Otherwise have the enemy attack the wolf
            else{
                e1.attack(magician);
                System.out.println("The wolf attacked the Magician!");
            }

            //Give the player their selections of attacks for the brawler
            System.out.println(" ");
            System.out.println("Choose an attack for your Brawler to use!");
            System.out.println("Press 1 to attack with your weapon");
            System.out.println("Press 2 to attack with your fireball");
            System.out.println("Press 3 to use a potion");

            //Take the next input as the attack selection for the brawler
            attackChoice = attack.nextInt();

            //If the input is 1 have the brawler use attack
            if (attackChoice == 1) {
                brawler.attack(e1);
            }

            //If the input is 2 have the brawler use a fireball
            else if (attackChoice == 2) {
                brawler.fireball(e1);
            }

            //If the input is 3 have the brawler use a potion
            else if (attackChoice == 3) {
                brawler.usePotion();
            }

            //Run a random number 0-100 to see what character is hit
            rando1 = r1.nextInt(100) + 1;
            System.out.println(" "); //Blank line

            //If the random number is less than or equal to 33 have the enemy attack the hero
            if(rando1 <= 33) {
                e1.attack(hero);        //Have the enemy attack the hero
                System.out.println("The wolf attacked Hero!");
            }

            //If the random number is greater than or equal to 66 have the enemy attack the brawler
            else if(rando1 >= 66) {
                e1.attack(brawler);
                System.out.println("The wolf attacked the Brawler!");
            }

            //Otherwise have the enemy attack the wolf
            else{
                e1.attack(magician);
                System.out.println("The wolf attacked the Magician!");
            }

            //Print out the health values of each target, the hero and the enemy
            System.out.println(hero.toString());
            System.out.println(magician.toString());
            System.out.println(brawler.toString());
            System.out.println(e1.getHealthPoints());

            Scanner revive = new Scanner(System.in); //Create new scanner for revive system

            //If the hero is dead, give the options to revive the hero
            if(hero.getHealthPoints() <= 0){
                System.out.println("Your hero died would you like to use a revive");
                System.out.println("Press 1 for yes, press 2 for no");
                int reviveChoice = revive.nextInt();

                //Set the hero health to 2/3 his starting health
                if(reviveChoice == 1){
                    hero.setHealthPoints(66);
                }
            }
            //If the magician is dead, give the options to revive the hero
            if(magician.getHealthPoints() <= 0){
                System.out.println("Your magician died would you like to use a revive");
                System.out.println("Press 1 for yes, press 2 for no");
                int reviveChoice = revive.nextInt();

                //Set the magician health to 2/3 his starting health
                if(reviveChoice == 1){
                    magician.setHealthPoints(53);
                }
            }
            //If the brawler is dead, give the options to revive the hero
            if(brawler.getHealthPoints() <= 0){
                System.out.println("Your brawler died would you like to use a revive");
                System.out.println("Press 1 for yes, press 2 for no");
                int reviveChoice = revive.nextInt();

                //Set the brawler health to 2/3 his starting health
                if(reviveChoice == 1){
                    brawler.setHealthPoints(100);
                }
            }
        }

        //If the enemies health is less than or equal to 0 set their alive status to false
        if(e1.getHealthPoints() <= 0){
            e1.setAlive(false);
        }
    }

    static public void getAllCharInfo(){
        System.out.println("Info");
        System.out.println(hero.toString());
        System.out.println(magician.toString());
        System.out.println(brawler.toString());
    }

    static public void restAllChar(){
        System.out.println("Rest");
        hero.setHealthPoints(100);
        System.out.println(hero.toString());
    }

    static public void shopAtStore(){
        System.out.println("Shop \n");
    }

}
