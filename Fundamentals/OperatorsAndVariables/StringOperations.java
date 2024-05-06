public class StringOperations {
    public static void main(String[] args) {
        String myName = "Luis";
        System.out.println(myName);
        StringBuilder newName = new StringBuilder(myName);
        newName.replace(0,1,"A");
        newName.replace(3,4,"Z");
        System.out.println(newName);
        String myURL = "www.stackoverflow.com";
        System.out.println(myURL);
        String newURL = myURL.substring(4,17) + "1331";
        System.out.println(newURL);

    }
}
