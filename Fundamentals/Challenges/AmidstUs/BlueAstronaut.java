public class BlueAstronaut extends Player implements Crewmate {
    
    private int numTasks;
    private int taskSpeed;
    private static final int DEFAULT_SUSLEVEL = 15;
    private static final int DEFAULT_NUMTASKS = 6;    
    private static final int DEFAULT_TASKSPEED = 10;    

    //constructor

    public BlueAstronaut(String name) {
        this(name, DEFAULT_SUSLEVEL, DEFAULT_NUMTASKS, DEFAULT_TASKSPEED);
    }
    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }
    
    //setter and getters
    public int getNumTasks() {
        return numTasks;
    }

    public int getTaskSpeed() {
        return taskSpeed;
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

    public void completeTask() {
        if ((this.isFrozen() == false) && (this.getNumTasks() > 0)) {
            if (this.taskSpeed > 20) {
                this.numTasks -= 2;
            }
            else {
                this.numTasks -= 1;
            }
            if (this.taskSpeed < 0) {
                this.taskSpeed = 0;
            }
            if (this.taskSpeed == 0) {
                System.out.println("I have completed all my tasks.");
                this.setSusLevel((int) (this.getSusLevel() * 0.5));
            }
        }
    };
    
    public boolean equals(Object o) {
        return ((this.getName() == ((Player) o).getName()) 
            && (this.getSusLevel() == ((Player) o).getSusLevel()) 
            && (this.getNumTasks() == ((BlueAstronaut) o).getNumTasks())
            && (this.getTaskSpeed() == ((BlueAstronaut) o).getTaskSpeed()));
    }

    @Override
    public String toString() {
        if (this.getSusLevel() > 15) {
            return ("My name is " + getName() 
            + ", and I have a suslevel of " + getSusLevel()
            + ". I am currently " + (this.isFrozen() ? "frozen." : "not frozen.") 
            + " I have " + numTasks 
            + " left over.").toUpperCase();
        }
        else {
            return "My name is " + getName() 
                    + ", and I have a suslevel of " + getSusLevel()
                    + ". I am currently " + (this.isFrozen() ? "frozen." : "not frozen.") 
                    + " I have " + numTasks 
                    + " left over.";
        }
    }
}
