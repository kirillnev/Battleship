package battleship;

public class Coordinate implements Comparable<Coordinate>{
    private final static int MAX_N = 10;
    private final static char MAX_CH = 'J';
    private final static char MIN_CH = 'A';
    private final int[] coordinate;

    public Coordinate(String posStr) {
        this.coordinate = parseCoordinate(posStr);
    }

    public Coordinate(Coordinate coordinate) {
        this.coordinate = coordinate.getCoordinate().clone();
    }

    public static int[] parseCoordinate(String str) {
        if (!checkCoordinate(str)) {
            throw new IllegalArgumentException();
        }

        return new int[]{(str.toUpperCase().charAt(0) - MIN_CH), Integer.parseInt(str.substring(1)) - 1};
    }

    public static boolean checkCoordinate(String str) {
        boolean res = true;
        char l = ' ';
        int n = 0;
        if (str != null && str.length() >= 2 && str.length() <= 3) {
            l = str.toUpperCase().charAt(0);
            try {
                n = Integer.parseInt(str.substring(1));
            } catch (NumberFormatException e) {
                n = 0;
            }
            if (l < MIN_CH || l > MAX_CH || n <= 0 || n > MAX_N) {
                res = false;
            }
        } else {
            res = false;
        }
        return res;
    }


    @Override
    public String toString() {
        return "" + (char) (coordinate[0] + MIN_CH) + (coordinate[1] + 1);
    }

    public int[] getCoordinate() {
        return coordinate;
    }

    public int getX() {
        return coordinate[1];
    }

    public int getY() {
        return coordinate[0];
    }

    @Override
    public int compareTo(Coordinate o) {
        if (this.getX() == o.getX() && this.getY() == o.getY()) {
            return 0;
        } else if (this.getX() >= o.getX() && this.getY() >= o.getY()) {
            return 1;
        } else {
            return -1;
        }
    }
}
