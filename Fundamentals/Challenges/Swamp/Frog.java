public class Frog {

     //instance variables
     private String name;
     private int age;
     private double tongueSpeed;
     private boolean isFroglet;
     private static String species = "Rare Pepe";
     public static final int DEFAULT_AGE = 5;
     public static final double DEFAULT_TONGUE = 5;

    //constructor
    public Frog(String name) {
        this(name, DEFAULT_AGE, DEFAULT_TONGUE);
    }
    
    public Frog(String name, double ageInYears) {
        this(name, (int) (12 * ageInYears), DEFAULT_TONGUE);
    }

    public Frog(String name, int age, double tongueSpeed){
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
        this.isFroglet = (age > 1) && (age < 7);
    }
    
    //setter and getter methods
    public String getName() {
        return name;
    }    
    public void setName(String newName) {
        this.name = newName;
    } 
    public int getAge() {
        return age;
    }
    public void setAge(int newAge) {
        this.age = newAge;
    } 
  
    public double getTongueSpeed() {
        return tongueSpeed;
    }   

    public void setTongueSpeed(int newTongueSpeed) {
        this.tongueSpeed = newTongueSpeed;
    } 

    public static String getSpecies() {
        return species;
    }

    public static void setSpecies(String newSpecies) {
        species = newSpecies;
    } 
  
    //methods
    public String toString() {
        if (isFroglet) {
            return (("My name is " + name + " and I'm a rare froglet! I'm " + age + " months old and my tongue has a speed of ") + String.format("%.2f", tongueSpeed));
        }
        else {
            return (("My name is " + name + " and I'm a rare frog! I'm " + age + " months old and my tongue has a speed of ") + String.format("%.2f", tongueSpeed));
        }
    }

    public void grow(int addMonths) {
         //loop to immplement aging
         for (int i = 1; i <= addMonths; i++) {
            age += 1;
            if (age <= 12) {
                tongueSpeed += 1;
            }
            else if (age <= 30) {
            }
            else {
                tongueSpeed -= 1;
            }
         }
         tongueSpeed = (tongueSpeed < 5) ? 5 : tongueSpeed;
         isFroglet = (age > 1) && (age < 7);
    }

    public void eat(Fly Fly) {
        if (!Fly.isDead()) {
            if (tongueSpeed > Fly.getSpeed()) {
                if (Fly.getMass() >= 0.5 * age) {
                    grow(1);
                    Fly.setMass(0);
                }
                else {
                    Fly.setMass(0);
                }
            }   
            else if (tongueSpeed <= Fly.getSpeed()) {
                Fly.grow(1);
            }
        }
    }
    public static void main(String args[]) {
        Frog frog1 = new Frog(species);
        frog1.grow(50);
        System.out.println(frog1.toString());
    }
}

