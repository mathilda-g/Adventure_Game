package Adventure_Game;

public abstract class Monster {
    private int monsterStrenght;
    private String description;
    private String hitPlayer;
    private String killPlayer;
    private String killedByPlayer;

    public Monster(int monsterStrenght, String description, String hitPlayer, String killPlayer, String killedByPlayer){
        this.monsterStrenght = monsterStrenght;
        this.description = description;
        this.killPlayer = killPlayer;
        this.hitPlayer = hitPlayer;
        this.killedByPlayer = killedByPlayer;
    }

    public int getMonsterStrenght() {
        return monsterStrenght;
    }

    public void setMonsterStrenght(int monsterStrenght) {
        this.monsterStrenght = monsterStrenght;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHitPlayer() {
        return hitPlayer;
    }

    public void setHitPlayer(String hitPlayer) {
        this.hitPlayer = hitPlayer;
    }

    public String getKillPlayer() {
        return killPlayer;
    }

    public void setKillPlayer(String killPlayer) {
        this.killPlayer = killPlayer;
    }

    public String getKilledByPlayer() {
        return killedByPlayer;
    }

    public void setKilledByPlayer(String killedByPlayer) {
        this.killedByPlayer = killedByPlayer;
    }
}   