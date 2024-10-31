package monster;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Combat {
    private Random random = new Random();
    private Scanner sc = new Scanner(System.in);
    private int choice;

    public boolean checkSuccess(int playerStrenght, int monsterStrenght){
        int strenghtDifference = getPlayerStrenght - getMonsterStrenght;
                
        double successChance;
        if (strengthDifference == 0) {
            successChance = 50.0;
        } else if (strengthDifference == 1) {
            successChance = 66.6;
        } else if (strengthDifference == 2) {
            successChance = 83.3;
        } else if (strengthDifference == -1) {
            successChance = 33.3;
        } else if (strengthDifference == -2) {
            successChance = 16.7;
        } else if (strengthDifference > 2) {
            successChance = 100.0;
        } else {
            successChance = 0.0;
        }
        
        double randomValue = random.nextDouble() * 100;
        return randomValue < successChance;
        
    }

    public void combat(int getPlayerStrength, int getPlayerHealth, Monster monster) {

        while (playerHealth > 0) {
            boolean success = checkSuccess(getPlayerStrength, monster.getMonsterStrength);

            if (success) {
                slowprint.slowPrintln(monster.getKilledByPlayer);
                break;
            } 
            else {
                slowprint.slowPrintln(monster.getHitPlayer);
                setPlayerHealth -= 1;
                System.out.println("Your current health: " + getPlayerHealth);

                if (getPlayerHealth <= 0) {
                    slowprint.slowPrintln(monster.getKillPlayer);
                    break;
                }

                System.out.println("Would you like to try again or run away?");
                System.out.println("Press 1 to try again, or 2 to run away:");
                
                int choice = 0;

                try {
                    choice = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter 1 or 2.");
                    sc.nextLine();
                    continue;
                }

                if (choice == 2) {
                    System.out.println("You run away!");
                    break;
                } 
                else if(choice == 1) {
                    System.out.println("You try again.");
                }
                else {
                    System.out.println("Invalid choice. Please enter 1 to try again or 2 to run away.");
                }
            }
        }
    }
}