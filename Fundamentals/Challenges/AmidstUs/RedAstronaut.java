//import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
    private String skill;
    private static final int DEFAULT_SUSLEVEL = 15;
    private static final String DEFAULT_SKILL = "experienced";

    //constructor
    public RedAstronaut(String name) {
        this(name, DEFAULT_SUSLEVEL, DEFAULT_SKILL);
    }
    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill;
    }

    //setter and getters
    public String getSkill() {
        return skill;
    }
    public void setSkill(String newSkill) {
        this.skill = newSkill;
    }
    
    //methods

    public void emergencyMeeting() {
        
        if ((this.isFrozen() == false)) {
            int maxSus = players[0].getSusLevel();
            int maxInd = 0;
            int compareSus = 0;

            for (int i = 0; i < players.length; i++) {
                if ((players[i].getSusLevel() > maxSus)
                    && (players[i].getSusLevel() != this.getSusLevel())) {
                    maxSus = players[i].getSusLevel();
                    maxInd = i;
                }
            }
            for (int j = 0; j < players.length; j++) {
                compareSus = players[j].getSusLevel();
                if (((j == maxInd) 
                    || (compareSus == maxSus))) {
                        continue;
                } else {
                    players[maxInd].setFrozen(true);
                }
            }     
        }
        gameOver();
    }
    public void freeze(Player p) {
        if (p instanceof Impostor || this.isFrozen()) {
            return;
        }
        if (!this.isFrozen() 
        && !(p instanceof Impostor)) { 
            if (p.getSusLevel() > this.getSusLevel()) {
                p.setFrozen(true);
            }
            else if (p.getSusLevel() <= this.getSusLevel()) {
                this.setSusLevel(getSusLevel() * 2);
            }
        } 
        gameOver();
    }
    
    public void sabotage(Player p) {
        if (this.isFrozen() == false) {
            if ((p instanceof Crewmate) && (p.isFrozen() == false)) {    
                if (this.getSusLevel() < 20) {
                    p.setSusLevel((int) (p.getSusLevel() * 1.5));
                }
                else {
                    p.setSusLevel((int) (p.getSusLevel() * 1.25));
                }
            }
        }
    }

    public boolean equals(Object o) {
        return ((this.getName() == ((Player) o).getName()) 
            && (this.getSusLevel() == ((Player) o).getSusLevel()) 
            && (this.getSkill() == ((RedAstronaut) o).getSkill()));
    }

    @Override
    public String toString() {
        if (this.getSusLevel() > 15) {
            return ("My name is " + getName() 
            + ", and I have a suslevel of " + getSusLevel()
            + ". I am currently " + (this.isFrozen() ? "frozen." : "not frozen.") 
            + " I am an " + skill 
            + " player.").toUpperCase();
        }
        else {
            return "My name is " + getName() 
                    + ", and I have a suslevel of " + getSusLevel()
                    + ". I am currently " + (this.isFrozen() ? "frozen." : "not frozen.") 
                    + " I am an " + skill 
                    + " player.";
        }
    }
}
