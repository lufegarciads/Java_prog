public abstract class Pet {
    //instance variables
    private String name;
    private double health;
    private int painLevel;

    //getters and setters
    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public int getPainLevel() {
        return painLevel;
    }

    //constructor
    public Pet(String name, double health, int painLevel) {
        this.name = name;
        this.health = health;
        this.painLevel = painLevel;
    }

    //methods
    public abstract int treat();
    
    public void speak() {
        if (painLevel > 5) {
            System.out.println(("Hello! My name is " + name).toUpperCase());
        }
        else {
            System.out.println("Hello! My name is " + name);        
        }
    }

    public boolean equals(Object o) {
        return (((Pet) o).getName() == name);
    }

    protected void heal() {
        health = 1.0;
        painLevel = 1;
    }
}
