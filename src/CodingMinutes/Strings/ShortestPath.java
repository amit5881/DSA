package CodingMinutes.Strings;

public class ShortestPath {

    public static void shortestRoute(String str) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'N':
                    x++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'W':
                    x--;
                    break;
                case 'E':
                    y++;
                    break;
            }
        }
        if (x >= 0 && y >= 0) {
            while (y > 0) {
                System.out.print('S');
                y--;
            }
            while (x > 0) {
                System.out.print(x);
                x--;
            }
        }

        if (x <= 0 && y <= 0) {
            while (x < 0) {
                System.out.print(x);
                x++;
            }
            while (y < 0) {
                System.out.print(y);
                y++;
            }
        }
    }

    public static void main(String[] args) {
        shortestRoute("SNNNEWE");
    }
}
