public class Dog extends Pet {
    //instance variables
    private double droolRate;

    //Constructors
    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, 5.0);
    }
    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        this.droolRate = (droolRate <= 0 ? 0.5 : droolRate);
    }

    //getters
    public double getDroolRate() {
        return droolRate;
    }

    public int treat() {
        super.heal();
        int time;
        if (droolRate < 3.5) {
            time = ((int) (((this.getPainLevel() * 2) / this.getHealth()) + 0.5));
        } else if ((droolRate >= 3.5) && (droolRate <= 7.5)) {
            time = ((int) ((this.getPainLevel()/ this.getHealth()) + 0.5));
        } else {
            time = ((int) ((this.getPainLevel()/ (this.getHealth() * 2)) + 0.5));
        }
        return time;
    }

    public void speak() {
        super.speak();
        for (int i = 0; i < this.getPainLevel(); i++) {
            if (this.getPainLevel() > 5) {
            System.out.print("bark ".toUpperCase());
            }
            else {
            System.out.print("bark ");
            }
        }
    }

    public boolean equals(Object o) {
        return super.equals(o) && (((Dog) o).getDroolRate() == this.droolRate);
    }
}
