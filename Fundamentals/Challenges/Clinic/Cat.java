public class Cat extends Pet {
    //instance variables
    private int miceCaught;

    //constructors
    public Cat(String name, double health, int painLevel) {
        this(name, health, painLevel, 0);
    }
    public Cat(String name, double health, int painLevel, int miceCaught){
        super(name, health, painLevel);
        this.miceCaught = miceCaught;
    }

    //getters
    public int getMiceCaught() {
        return miceCaught;
    }

    //methods
    public int treat() {
        super.heal();
        int time;
        if (miceCaught < 4) {
            time = ((int) (((this.getPainLevel() * 2) / this.getHealth()) + 0.5));
        } else if ((miceCaught >= 4) && (miceCaught <= 7)) {
            time = ((int) ((this.getPainLevel()/ this.getHealth()) + 0.5));
        } else {
            time = ((int) ((this.getPainLevel()/ (this.getHealth() * 2)) + 0.5));
        }
        return time;
    }

    public void speak() {
        super.speak();
        for (int i = 0; i < this.getMiceCaught(); i++) {
            if (this.getMiceCaught() > 5) {
            System.out.print("meow ".toUpperCase());
            }
            else {
            System.out.print("meow ");
            }
        }
    }

    public boolean equals(Object o) {
        return super.equals(o) && (((Cat) o).getMiceCaught() == this.miceCaught);
    }
}
