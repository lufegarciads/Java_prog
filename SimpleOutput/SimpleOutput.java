public class SimpleOutput {
    public static void main(String []args){
        String str1 = "1";
        String str2 = "2";
        int int1 = 1;

        System.out.println(str1 + str2 + int1);

        int x = 100;
        if (x > 0)
            System.out.println("launch");
        else if (x >= 100)
            System.out.println("lift off");
        else
            System.out.println("float");

        boolean num34 = false || "jackets".equals("Jackets");
        System.out.println(num34);

        String funnyStr = "south, long island";
        funnyStr.replace("!"," ");
        funnyStr.replace("the beach","");
        funnyStr.replace(", long", "");
        funnyStr.replace("wal","roc");
        funnyStr.toUpperCase();
        System.out.println(funnyStr);
    }
}
