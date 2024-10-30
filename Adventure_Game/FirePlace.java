package Adventure_Game;
import java.util.Scanner;

public class FirePlace {
    //Glöm inte att ta bort health, intellegence och slowprint sen.
    private boolean isLit;
    Slowprint slowprint = new Slowprint();
    Scanner scanner = new Scanner(System.in);
    int health = 3;
    int intelligence = 0;

    public FirePlace() {
        this.isLit = false;
    }

    public void arrivalAtFirePlace(){
        slowprint.slowPrintln("The traveler emerged from the dense forest as dusk crept in, weary and cold. Through the trees, you spot a stone-ringed "
         + "fireplace in a small clearing, untouched and waiting in the twilight.\nYou approach, noting the silence around it. "
         + "No firewood was stacked, no sign of another soul - only the cold stones and the faint scent of old ashes.\nKneeling down "
         + "you brushed your right hand over the stones, feeling a chill that ran deeper than the night air.\nYou hesitate, then decide to gather some kindling nearby, "
         + "preparing to bring warmth back to this quiet, abandoned place.\nYou think twice, do I want to start a fire or not? "
         + "\nWhat if I attract unwanted creatures towards me? Do you still want to lit the fireplace?", 20);
    }

    public void askToLit() {
        //Metod för att hämta valmeny
        int choice;
                //Visar meny och hämtar användarens val.
                while (true) {
                    slowprint.slowPrintln("1. Yes");
                    slowprint.slowPrintln("2. No");
        
                    // Kallar på metod för att se att input av användare är en integer
                   choice = checkChoice(scanner);
        
                        switch (choice) {
                            case 1:
                                ifLit();
                                break;
        
                            case 2:
                                ifNotLit();
                                break;
                        
                        }
                        
                    } 
                }

    

    public void ifLit() {
        isLit = true;
        slowprint.slowPrintln("You've decided to lit the fire.");
        intelligence += 1;
        slowprint.slowPrintln("You've also gotten a skillpoint for intelligence! " + "Unfortunally, you attracted spiders towards your position." ,50);
        //Metod för att kalla på spindlar
        
    }
    public void ifNotLit() {
        isLit = false;
        slowprint.slowPrintln("You've decided to not lit the fire.");
        health -=1;
        slowprint.slowPrintln("Due to you not putting up the fire, you've gotten cold and lost a healthpoint. " + "-1 Healthpoint, you still got "+health+ " left");
        slowprint.slowPrintln("You've moved on without a scratch though, which let's you move on to the next part of the story");
        //Metod för att ta sig vidare i historien
    }
    public int checkChoice (Scanner scanner){
        //Check av input så det är ett positivt nummer över 0
            int number;
            boolean firstrun = true;
            do {
    
                if(!firstrun) {slowprint.slowPrintln("Write a numberical option (1 or 2)!");}
                while (!scanner.hasNextInt()) {
                    
                    slowprint.slowPrintln("Write a number!");
                    
                    scanner.next(); 
                    
                }
                
                firstrun = false;
                number = scanner.nextInt();
            
            } while (number < 1 || number > 2);
            return number;
            
        }
    }

    