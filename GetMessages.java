class GettingMessages {
    public static void main(String[] args) {
        Grab myMessages = new Grab("texts.txt");
        System.out.println(myMessages.getTotal());
    }
}