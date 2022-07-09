/**
 * 
 * Schachnotation Klasse
 * 
 * @author Luca Wegner, Arnd Bethge
 * 
 */
public class Schachnotation {
  /**
   * 
   * methode welche position des springers in schachnotation wiedergibt
   * 
   * @param y     int, y position des springers
   * @param x     int, x position des springers
   * @param sizey int, anzahl der zeilen des spielbretts
   * @return gibt einen String wider, welcher die position des springers in
   *         schachnotation ist
   */
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

  /**
   * 
   * methode welche aus position des springers in schachnotation in x y werte der
   * position des springers umwandelt
   * 
   * @param s     string, position des springers in schachnotation
   * @param sizey int, anzahl der zeilen des spielbretts
   * @return 2d array von int, gibt position des springers in x und y werten (int)
   *         wieder
   */
  public static int[] convertToNormal(String s, int sizey) {
    char c = s.charAt(0);
    int x;
    switch (c) {
      case 'a':
        x = 0;
        break;
      case 'b':
        x = 1;
        break;
      case 'c':
        x = 2;
        break;
      case 'd':
        x = 3;
        break;
      case 'e':
        x = 4;
        break;
      case 'f':
        x = 5;
        break;
      case 'g':
        x = 6;
        break;
      case 'h':
        x = 7;
        break;
      case 'i':
        x = 8;
        break;
      case 'j':
        x = 9;
        break;
      case 'k':
        x = 10;
        break;
      case 'l':
        x = 11;
        break;
      case 'm':
        x = 12;
        break;
      case 'n':
        x = 13;
        break;
      case 'o':
        x = 14;
        break;
      case 'p':
        x = 15;
        break;
      case 'q':
        x = 16;
        break;
      case 'r':
        x = 17;
        break;
      case 's':
        x = 18;
        break;
      case 't':
        x = 19;
        break;
      case 'u':
        x = 20;
        break;
      case 'v':
        x = 21;
        break;
      case 'w':
        x = 22;
        break;
      case 'x':
        x = 23;
        break;
      case 'y':
        x = 24;
        break;
      case 'z':
        x = 25;
        break;
      default:
        x = -1;
        break;
    }
    int num = Integer.parseInt(s.substring(1));
    int y = num + (sizey) - (2 * num);
    return new int[] { x, y };
  }
}