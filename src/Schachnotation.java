public class Schachnotation {
  public static String getSchanotation(int y, int x, int sizey) {
    char c;
    switch (x) {
      case 0:
        c = 'a';
        break;
      case 1:
        c = 'b';
        break;
      case 2:
        c = 'c';
        break;
      case 3:
        c = 'd';
        break;
      case 4:
        c = 'e';
        break;
      case 5:
        c = 'f';
        break;
      case 6:
        c = 'g';
        break;
      case 7:
        c = 'h';
        break;
      case 8:
        c = 'i';
        break;
      case 9:
        c = 'j';
        break;
      case 10:
        c = 'k';
        break;
      case 11:
        c = 'l';
        break;
      case 12:
        c = 'm';
        break;
      case 13:
        c = 'n';
        break;
      case 14:
        c = 'o';
        break;
      case 15:
        c = 'p';
        break;
      case 16:
        c = 'q';
        break;
      case 17:
        c = 'r';
        break;
      case 18:
        c = 's';
        break;
      case 19:
        c = 't';
        break;
      case 20:
        c = 'u';
        break;
      case 21:
        c = 'v';
        break;
      case 22:
        c = 'w';
        break;
      case 23:
        c = 'x';
        break;
      case 24:
        c = 'y';
        break;
      case 25:
        c = 'z';
        break;
      default:
        c = '.';
        break;
    }
    String s = "";
    int num = y + (sizey - 1) - (2 * y);
    /*
     * 0 - 9
     * 
     * 0 -> 9 0 + 9 - 0
     * 1 -> 8 1 + 9 - 2
     * 2 -> 7 2 + 9 - 4
     * 3 -> 6 3 + 9 - 6
     * 4 -> 5 4 + 9 - 8
     * 5 -> 4 5 + 9 - 10
     * 6 -> 3 6 + 9 - 12
     * 7 -> 2 7 + 9 - 14
     * 8 -> 1 8 + 9 - 16
     * 9 -> 0 9 + 9 - 18
     * 
     * num + 9 -
     */
    s = c + String.valueOf(num + 1);
    return s;
  }
}
