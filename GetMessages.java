class GetMessages {
    public static void main(String[] args) {
        Grab myMessages = new Grab("texts.txt");
        System.out.println(myMessages.getTotal());
        System.out.println("love " + myMessages.getWordCount("love"));
        System.out.println("peanut " + myMessages.getWordCount("peanut"));
        System.out.println("bean " + myMessages.getWordCount("bean"));
    }
}