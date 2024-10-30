package Adventure_Game;


public class Slowprint {
    public static void slowPrintln(String text) {
        slowPrintln(text, 50);
    }

    public static void slowPrintln(String text, int ms){
        for (char c : text.toCharArray()){
            System.out.print(c);
            try {
                Thread.sleep(ms);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
