/**
 * 
 * app klasse in der das springerproblem programm ausgefuehrt wird
 * 
 * @author Luca Noel Wegner, Arnd Bethge
 */
public class App {
    /**
     * Main Methode, Programm wird hier aufgerufen
     * 
     * @param args
     * @throws Exception
     * 
     */
    public static void main(String[] args) throws Exception {
        /**
         * speichert gesamtanzahl aller moeglichen loesungen
         */
        int count = 0;
        /**
         * anzahl an spalten
         */
        int col = 10;
        /**
         * anzahl an zeilen
         */
        int row = 3;
        /**
         * gibt an ob es sich um die geschlossene variante handelt
         */
        boolean closedTour = false;
        /**
         * gibt an ob es sich um die klasische oder vereinfachte variante handelt
         */
        boolean simplifiedVariant = false;
        /**
         * start position des springers in schachnotation
         */
        String startingPosition = "a1";
        /**
         * anzahl der auszugebenden loesungswege
         * </p>
         * < 0 fuer alle loesungen (funktioniert nicht bei Output 2, dort nur > 0)
         */
        int numOfSampleSolutionsToShow = 5;
        /**
         * 0 berrechnet alle loesungen fuer eine bestimmte startposition und gibt
         * numOfSampleSolutionsToShow loesungswege aus
         * </p>
         * 1 berrechnet alle loesungen fuer alle startpositionen zusammen und gibt zu
         * jeder startposition numOfSampleSolutionsToShow loesungswege aus
         * </p>
         * 2 berrechnet numOfSampleSolutionsToShow loesungswege und gibt diese aus
         * </p>
         */
        int typeOfOutput = 1; // 0 fuer eine bestimmte Startposition, 1 fuer alle zusammen, 2 fuer einzelne
                              // Loesungen
        /**
         * Instanz der springerproblem klasse mit allen vorherigen werten
         */
        Springerproblem problem1 = new Springerproblem(col, row, simplifiedVariant, closedTour, startingPosition,
                numOfSampleSolutionsToShow);

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
