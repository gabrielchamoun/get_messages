class GetMessages {
    public static void main(String[] args) {
        
        Grab myMessages = new Grab("messages.txt");
        System.out.println(myMessages.getTotal());
        System.out.println("love " + myMessages.getWordCount("love"));
        System.out.println("you " + myMessages.getWordCount("you"));        
        System.out.println("peanut " + myMessages.getWordCount("peanut"));
        System.out.println("bean " + myMessages.getWordCount("bean"));
        System.out.println(myMessages.getCommon());
    }
}