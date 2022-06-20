import java.util.*;

public class Springerproblem {
  Random rand = new Random();
  private int[] movesX = { 2, 1, -1, -2, -2, -1, 1, 2 };
  private int[] movesY = { 1, 2, 2, 1, -1, -2, -2, -1 };

  private int sizeX;
  private int sizeY;
  private ArrayList<int[][]> solutions = new ArrayList<int[][]>();

  private boolean isEasy;
  private boolean closed;

  private int x;
  private int y;

  public Springerproblem(int x, int y, boolean isEasy, boolean closed, int xpos, int ypos) {
    this.sizeX = x;
    this.sizeY = y;
    this.isEasy = isEasy;
    this.closed = closed;
    this.x = xpos;
    this.y = ypos;
  }

  private int[][] createBoard() {
    int board[][] = new int[this.sizeY][this.sizeX];
    for (int y = 0; y < this.sizeY; y++) {
      for (int x = 0; x < this.sizeX; x++) {
        board[y][x] = -1;
      }
    }
    return board;
  }

  private String[] createSolutionString(ArrayList<int[][]> sol) {
    String[] solution = new String[sol.size()];
    String solutionString;
    int board[][];
    for (int n = 0; n < sol.size(); n++) {
      solutionString = "Solution " + (n + 1) + ": ";
      board = sol.get(n);
      for (int i = 0; i < this.sizeX * this.sizeY; i++) {
        for (int y = 0; y < this.sizeY; y++) {
          for (int x = 0; x < this.sizeX; x++) {
            if (board[y][x] == i) {
              solutionString += Schachnotation.getSchanotation(y, x, this.sizeY) + "  ";
            }
          }
        }
      }
      solution[n] = solutionString;
    }
    return solution;
  }

  // private void printBoard(int[][] board) {
  // for (int i = 0; i < this.sizeY; i++) {
  // System.out.println(Arrays.toString(board[i]));
  // }
  // }

  private boolean validateMove(int[][] board, int row, int col, int counter) {
    if (row < this.sizeY && row >= 0 && col < this.sizeX && col >= 0 && board[row][col] == -1) {
      if (this.closed) {
        if (counter == this.sizeX * this.sizeY - 1) {

        }
      }
      return true;
    }
    return false;
  }

  private boolean solve(int[][] board, int row, int col, int counter, ArrayList<int[][]> prevBoards) {
    int new_x, new_y;

    if (board[0][0] != -1 && board[this.sizeY - 1][0] != -1 && board[this.sizeY - 1][this.sizeX - 1] != -1
        && board[0][this.sizeX - 1] != -1 && this.isEasy) {
      if (checkIfBoardAreEqual(board, prevBoards)) {
        board[row][col] = -1;
        return false;
      }
      return true;
    }

    if (counter >= this.sizeX * this.sizeY) {
      if (checkIfBoardAreEqual(board, prevBoards)) {
        board[row][col] = -1;
        return false;
      }
      if (this.closed) {
        for (int j = 0; j < 8; j++) {
          new_y = row + movesY[j];
          new_x = col + movesX[j];
          if (new_y == this.y && new_x == this.x) {
            return true;
          }
        }
        board[row][col] = -1;
        return false;
      }
      if (checkIfBoardAreEqual(board, prevBoards)) {
        board[row][col] = -1;
        return false;
      }
      return true;
    }

    for (int i = 0; i < 8; i++) {
      // int[] moves = this.pickNewMove();
      // System.out.println(moves[0]);
      // moves = this.pickNewMove();
      new_y = row + movesY[i];
      new_x = col + movesX[i];
      if (validateMove(board, new_y, new_x, counter)) {
        board[new_y][new_x] = counter;
        if (solve(board, new_y, new_x, counter + 1, prevBoards))
          return true;
        else
          board[new_y][new_x] = -1;
      }
    }
    return false;
  }

  // public int[] pickNewMove() {
  // int[] move = new int[2];
  // ArrayList<int[]> moves = new ArrayList<int[]>();
  // ArrayList<Integer> numMoves = new ArrayList<Integer>();
  // for (int i = 0; i < 8; i++) {
  // move[0] = movesX[i];
  // move[1] = movesY[i];
  // }
  // int n = numMoves.indexOf(Collections.min(numMoves));
  // return moves.get(n);
  // }

  private int getNumOfTotalSolutions() {
    int totalSol = 1;
    ArrayList<int[][]> prevBoards = new ArrayList<int[][]>();
    int[][] board = createBoard();
    board[this.y][this.x] = 0;
    prevBoards.add(board);
    while (solve(board, this.y, this.x, 1, prevBoards)) {
      totalSol++;
      prevBoards.add(board);
      board = createBoard();
      board[this.y][this.x] = 0;
    }
    return totalSol;
  }

  private boolean checkIfBoardAreEqual(int[][] currentBoard, ArrayList<int[][]> prevBoards) {
    for (int[][] b : prevBoards) {
      boolean isEqual = true;
      for (int i = 0; i < this.sizeY; i++) {
        for (int j = 0; j < this.sizeX; j++) {
          if (currentBoard[i][j] != b[i][j]) {
            isEqual = false;
          }
        }
      }
      if (isEqual) {
        return true;
      }
    }
    return false;
  }

  public void run() {
    int numOfSol = 3;
    boolean DidNotRemove = true;
    int[][][] boards = new int[numOfSol][this.sizeY][this.sizeX];
    int[][] prevBoard = createBoard();
    prevBoard[this.y][this.x] = 0;
    ArrayList<int[][]> prevBoards = new ArrayList<int[][]>();
    prevBoards.add(prevBoard);
    for (int[][] b : boards) {
      b = createBoard();
      b[this.y][this.x] = 0;
      if (!this.solve(b, this.y, this.x, 1, prevBoards)) {
        System.out.println("Knight's tour is not possible");
        break;
      } else {
        if (DidNotRemove) {
          DidNotRemove = false;
          prevBoards.remove(0);
        }
        // printBoard(b);
        this.solutions.add(b);
        prevBoards.add(b);
        // System.out.println(this.checkIfBoardAreEqual(b, prevBoards));

      }
    }
    for (String s : this.createSolutionString(solutions)) {
      System.out.println(s);
    }
    // String s[] = this.createSolutionString(this.solutions);
    // if (s.length > 0) {
    // System.out.println(s[s.length - 1]);
    // }
  }
}
