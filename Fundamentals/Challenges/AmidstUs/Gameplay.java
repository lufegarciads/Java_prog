public class Gameplay {
    public static void main(String[] args){
        // Instantiate objects
        BlueAstronaut blueBob = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut blueHeath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut blueAlbert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut blueAngel = new BlueAstronaut("Angel", 0, 1, 0);
        RedAstronaut redLiam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut redSuspiciousPerson = new RedAstronaut("Suspicious Person", 100, "expert");
        
        //1
        redLiam.sabotage(blueBob);
        //System.out.println(blueBob.toString());
        //System.out.println(redLiam.toString());
        //2
        redLiam.freeze(redSuspiciousPerson);
        //3
        redLiam.freeze(blueAlbert);
        //4
        blueAlbert.emergencyMeeting();
        //5
        redSuspiciousPerson.emergencyMeeting();
        //6
        blueBob.emergencyMeeting();
        //System.out.println(redSuspiciousPerson.toString());
        //7
        blueHeath.completeTask();
        //8
        blueHeath.completeTask();
        //9
        blueHeath.completeTask();
        //10
        redLiam.freeze(blueAngel);
        //System.out.println(blueAngel.toString());
        //System.out.println(redLiam.toString());
        //11
        //System.out.println(blueBob.toString());
        redLiam.sabotage(blueBob);
        //System.out.println(blueBob.toString());
        redLiam.sabotage(blueBob);
        //System.out.println(blueBob.toString());
        //12
        redLiam.freeze(blueBob);
        //13
        redLiam.sabotage(blueHeath);
        redLiam.sabotage(blueHeath);
        redLiam.sabotage(blueHeath);
        redLiam.sabotage(blueHeath);
        redLiam.sabotage(blueHeath);
        //14
        //15
        redLiam.freeze(blueHeath);
    }    
}
