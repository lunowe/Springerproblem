public class App {
    public static void main(String[] args) throws Exception {
        int count = 0;
        int col = 5;
        int row = 5;
        boolean closedTour = false;
        boolean simplifiedVariant = false;
        String startingPosition = "a1";
        int numOfSampleSolutionsToShow = 5;
        int typeOfOutput = 0; // 0 fuer eine bestimmte Startposition, 1 fuer alle zusammen
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
            default:
                System.out.println("Wrong Input!");
        }
    }
}
