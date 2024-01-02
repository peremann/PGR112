package loesninger._04.methods;

public class Main {

    /**
     * We do not need a main method in today's assignments.
     * We use unit tests to check if our methods work.
     * But I have included a main method as it may be used
     * for an extra assignment.
     */
    public static void main(String[] args) {
	    Assignment assignment = new Assignment();
	    int intResult = assignment.addThreeNumbers(2,3,4);
        System.out.println("Result (expecting 9):"+intResult);
        String stringResult = assignment.isNumberSmallMediumOrBig(-1000);
        System.out.println("Result (expecting Small):"+stringResult);
        stringResult = assignment.isNumberSmallMediumOrBig(500);
        System.out.println("Result (expecting Medium):"+stringResult);
        stringResult = assignment.isNumberSmallMediumOrBig(10000);
        System.out.println("Result (expecting Big):"+stringResult);
        System.out.println("Expecting Hei på deg on three separate lines:");
        assignment.printAllStrings(new String[]{"Hei", "på", "deg"});
        intResult = assignment.arraySum(new int[]{3,4,5});
        System.out.println("Result (expecting 12):"+intResult);
        System.out.println("Expecting SUPERT. to be printed:");
        assignment.printFirstSentence(new char[]{'S', 'U', 'P', 'E', 'R', 'T', '.', 'a'});
        System.out.println();
        System.out.println("Expecting Database to be printed:");
        assignment.printCourseName("DB1102");
        System.out.println("Expecting Cola Pepsi Solo on three separate lines:");
        assignment.printAllStringsNotCorona(new String[]{"Cola", "Pepsi", "Corona", "Solo"});
        System.out.println("Expecting YES NO MAYBE on three separate lines:");
        assignment.printUpperCaseStrings(new String[]{"yes", "nO", "maYbE"});
        boolean booleanResult = assignment.isColorInNorwegianFlag("black");
        System.out.println("Result (expecting false):"+booleanResult);
        booleanResult = assignment.isColorInNorwegianFlag("red");
        System.out.println("Result (expecting true):"+booleanResult);
        intResult = assignment.firstOccurrence("Per", 'e');
        System.out.println("Result (expecting 1):"+intResult);
        intResult = assignment.firstOccurrence("Per", 'x');
        System.out.println("Result (expecting -1):"+intResult);
        intResult = assignment.combinedLength("Java", "ruler");
        System.out.println("Result (expecting 9):"+intResult);
        intResult = assignment.addNumbers(1,2,3,4,5,6,7,8,9,10);
        System.out.println("Result (expecting 55):"+intResult);
        System.out.println("Expecting Cool, it works! on three separate lines:");
        assignment.printAllStringsNotCoronaCaseInsensitive(new String[]{"Cool,", "CORONA", "it", "corona", "works!"});

    }
}
