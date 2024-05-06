public class Pond {
    public static void main(String[] args) {
        //create objects
        Frog frogPeepo = new Frog("Peepo");
        Frog frogPepe = new Frog("Pepe", 10, 15.0);
        Frog frogPeepaw = new Frog("Peepaw", 4.6);
        Frog frogMassive = new Frog("Massive", 45, 30.5);

        Fly fly1 = new Fly(1, 3);
        Fly fly2 = new Fly(6);
        Fly fly3 = new Fly(6);


        //procedures
        //1
        Frog.setSpecies("1331 Frogs");
        //2
        System.out.println(frogPeepo.toString());
        //3
        frogPeepo.eat(fly2);
        //4
        System.out.println(fly2.toString());
        //5
        frogPeepo.grow(8);
        //6
        frogPeepo.eat(fly2);
        //7
        System.out.println(fly2.toString());
        //8
        System.out.println(frogPeepo.toString());
        //9
        System.out.println(frogMassive.toString());
        //10
        frogPeepaw.grow(4);
        //11
        System.out.println(frogPeepaw.toString());
        //12
        System.out.println(frogPepe.toString());
    }

}
