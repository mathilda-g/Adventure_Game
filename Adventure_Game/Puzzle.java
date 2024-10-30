package Adventure_Game;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Puzzle {
    //Glöm inte ta bort intelligence, scanner, slowprint och food sen.
    int intelligence;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    Slowprint slowprint = new Slowprint();
    Food food = new Food();



    public Puzzle() {
    }

    public void arrivalAtPuzzle() {
        slowprint.slowPrintln("You stand alone in the dusty police station, facing an old filing cabinet. "
        + "\nYou walk out of the office and out in the hallways. As you navigate through the dimly lit hallways, you find a room marked 'Survival'. " 
        + "\nInside, there is a large, rusted puzzle with a numeric combination. It reads:");
        questionAndChoice();
    }
    
    public void ifSolved(){
        food.findingTheFood();
        food.choiceOfEating();
    }


    public void ifNotSolved(){
        slowprint.slowPrintln("You couldn't come up with the answer to the puzzle (equation) and decide to leave the policestation due to you already exploring the whole place.");
        //Metod för val mellan sjukhus och köpcentrum
    }

    public int checkChoice (Scanner scanner){
    //Check av input så det är ett positivt nummer över 0
        int number;
        boolean firstrun = true;
        do {

            if(!firstrun) {slowprint.slowPrintln("Write a numberical option (1-4)!");}
            while (!scanner.hasNextInt()) {
                
                slowprint.slowPrintln("Write a number!");
                
                scanner.next(); 
                
            }
            
            firstrun = false;
            number = scanner.nextInt();
        
        } while (number < 1 || number > 4);
        return number;
        
    }

    public void questionAndChoice() {
        for (int i = 0; i < 1; i++) {
            //Generation av random nummer, operator och uträkning av korrekt svar
            int num1 = random.nextInt(15) + 1, num2 = random.nextInt(15) + 1;
            String[] operators = {"+", "-", "*"};
            String operator = operators[random.nextInt(3)];
            int correctAnswer = calculateAnswer(num1, num2, operator, random);

            //Utskrift av fråga och alternativ
            slowprint.slowPrintln("Let's unveil the enigma of " + num1 + " " + operator + " " + num2);
            ArrayList<Integer> options = generateOptions(correctAnswer, random);
            for (int j = 0; j < options.size(); j++) slowprint.slowPrintln((j + 1) + ". " + options.get(j));

            //Hämtar användarens val och kollar om det är korrekt
            slowprint.slowPrintln("Enter your choice of answer on the keypad: ");
            if (options.get(checkChoice(scanner) - 1) == correctAnswer) {
                ifSolved();
            } else {
                ifNotSolved();    
            }
            System.out.println();
        }
        scanner.close();
    }

    //Metod som räknar ut svar baserat på operator
    public static int calculateAnswer(int num1, int num2, String operator, Random random) {
        switch (operator) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            default: return 0;
        }
    }

    // Metod för att generera svar och alternativ med rätt svar
    public static ArrayList<Integer> generateOptions(int correctAnswer, Random random) {
        ArrayList<Integer> options = new ArrayList<>();
        options.add(correctAnswer);
        while (options.size() < 4) {
            int wrongAnswer = correctAnswer + random.nextInt(10) - 5;
            if (!options.contains(wrongAnswer)) options.add(wrongAnswer);
        }
        Collections.shuffle(options);
        return options;
    }

}    
