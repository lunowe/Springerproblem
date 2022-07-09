public class App {
    public static void main(String[] args) throws Exception {
        int count = 0;
        int col = 4;
        int row = 7;
        boolean closedTour = false;
        boolean simplifiedVariant = false;
        String startingPosition = "a1";
        int numOfSampleSolutionsToShow = 5; // < 0 fuer alle Loesungen (funktioniert nicht bei Output 2)
        int typeOfOutput = 0; // 0 fuer eine bestimmte Startposition, 1 fuer alle zusammen, 2 fuer einzelne
                              // Loesungen
        Springerproblem problem1 = new Springerproblem(col, row, simplifiedVariant, closedTour, startingPosition,
                numOfSampleSolutionsToShow);
        // problem1.run();

        switch (typeOfOutput) {
            case 0:
                problem1.runWhileLoop();
                break;
            case 1:
                count = problem1.getNumOfTotalSolutions(col, row);
                System.out.println("Number of total possible " + ((closedTour &&
                        !simplifiedVariant) ? "closed " : "")
                        + "solutions for all starting positions combined: " + count);
                break;
            case 2:
                problem1.run();
                break;
            default:
                System.out.println("Wrong Input!");
                break;
        }
    }
}
