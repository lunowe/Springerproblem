public class App {
    public static void main(String[] args) throws Exception {
        int count = 0;
        int col = 3;
        int row = 3;
        boolean closedTour = false;
        boolean simplifiedVariant = true;
        String startingPosition = "a1";
        int numOfSampleSolutionsToShow = -1;
        int typeOfOutput = 1; // 0 fuer eine bestimmte Startposition, 1 fuer alle zusammen
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
            default:
                System.out.println("Wrong Input!");
                break;
        }
    }
}
