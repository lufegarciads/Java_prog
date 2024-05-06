public class Fly {
    
    //instance variables
    private double mass;
    private double speed;
    private static final double DEFAULT_MASS = 5;
    private static final double DEFAULT_SPEED = 10;

    //constructor
    public Fly() {
        this(DEFAULT_MASS, DEFAULT_SPEED);
    }
    public Fly(double mass) {
        this(mass, DEFAULT_SPEED);
    }
    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    //setter and getter methods
    public double getMass() {
        return mass;
    }
    public void setMass(double newMass) {
        if (newMass >= 0) {
            this.mass = newMass;
        }
    } 

    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double newSpeed) {
        if (newSpeed >= 0) {
            this.speed = newSpeed;
        }
    }

    //Methods
    public String toString() {
        if (mass == 0) {
            return String.format("I'm dead, but I used to be a fly with speed of %.2f.", speed);
        }
        else {
            return String.format("I'm a speedy fly with %.2f speed and mass %.2f", speed, mass);
        }
    }
    public void grow(int addMass) {
        if (mass >= 20) {
            speed -= 0.5 * (addMass);
        }
        else if ((mass + addMass) < 20) {
            speed += addMass;
        }
        else {
            speed += (20 - mass);
        }
        int before20 = 20 - (int) mass;
        int after20 = (int) mass + addMass - 20; 
        speed += before20 - 0.5 * after20;
        
        mass += addMass;
    }
    public boolean isDead() {
        return (mass == 0);
    }

    public static void main(String[] args) {
        Fly fly1 = new Fly();
        fly1.grow(50);
        System.out.println(fly1.toString());
    }

}
