import java.util.Scanner;

public class Player {
    private String name;
    private int age;
    private int health;
    private int level;
    private static final int MAX_LEVEL = 4;
    private int speed;
    private int strength;
    private int intelligence;


    public Player(String name) {
        this.name = name;
        this.age = 0;
        this.health = 3;
        this.level = 1;
        this.speed = 0;
        this.strength = 0;
        this.intelligence = 0;
    }

    public void setName(Scanner scanner) {
        boolean isValid = false;

        while (!isValid) {
            System.out.println("Enter your name: ");
            String inputName = scanner.nextLine();

            //en kontroll om namnet endast innehåller bokstäver och är 1-20 tecken långt.
            if (inputName.matches("[a-zA-ZÅÄÖåäö]{1,20}")) {
                this.name = inputName;
                isValid = true;
                System.out.println("Your chosen name is " + name);
            } else {
                System.out.println("Incorrect input. The name must contain only letters and must be between 1-20 characters.");
            }

        }
        
    }
    
    public String getName() {
        return name;
    }

    public void setAge(Scanner scanner) {
       
        while (true) {
            System.out.println("Enter your age: ");
            String inputAge = scanner.nextLine();

            //Kontroll om inmatningen endast innehåller siffror
            if (!inputAge.matches("\\d+")) {
                System.out.println("Error: Age must be entered with numbers only.");
                continue;
            }

            //omvandlar inmatningen till heltal och sparar i age
            age = Integer.parseInt(inputAge);

            //kontroll ifall spelaren är minst 15år och max 120år
            if (age < 15) {
                System.out.println("Error: You must be at least 15 years old to play this game.");
            } else if (age > 120) {
                System.out.println("Error: The age cannot be over 120 years.");
            } else {
                System.out.println("Your age has been registered.");
                break;
            }

        }
    
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player("Default name");

        player.setName(scanner);
        player.setAge(scanner);

        scanner.close();
    }
    
 
     public int getHealth() {
        return health;
     }

     public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
     }

     //metod för att öka i nivå
     public void levelUp() {
        if (level < MAX_LEVEL) {
            level++;
            System.out.println(name + " has reached level " + level + "!");
        }
     }
     
     //metod för belöningssystem där färdigheter kan ökas
    public void reward(String choice) {
        switch (choice) {
            case "speed":
               speed += 1;
               System.out.println(name + " has increased its speed to " + speed);
               break;
            case "strength":
               strength += 1;
               System.out.println(name + " has increased its strength to " + strength);
               break;
            case "intelligence":
               intelligence += 1;
               System.out.println(name + " has increased its intelligence to " + intelligence);
               break;
            default:
                System.out.println("Invalid selection, try again.");
                break;
        }
    }

    public int getLevel() {
        return level;
    }


    }


 



    