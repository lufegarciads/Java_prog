public class PrimitiveOperations {
    public static void main(String[] args) {
        int myInt = 23;
        double myDouble = 23.23;
        System.out.println(myInt);
        System.out.println(myDouble);
        double myMult = (double) myInt * myDouble;
        System.out.println(myMult);
        float myFloat = (float) myInt;
        System.out.println(myFloat);
        int myInt2 = (int) myDouble;
        System.out.println(myInt2);
        char myChar = 'Y';
        System.out.println(myChar);
        System.out.println((char) (myChar - 'A' + 'a'));
    }
}
