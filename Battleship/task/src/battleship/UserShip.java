package battleship;

public class UserShip {
    private final Coordinate start;
    private final Coordinate end;
    private final Ship ship;
    private int fullPart;

    public UserShip(Ship ship, Coordinate start, Coordinate end) {
        if (!checkPosition(ship, start, end)) {
            throw new IllegalArgumentException();
        }
        this.start = new Coordinate(start);
        this.end = new Coordinate(end);
        this.ship = ship;
        this.fullPart = ship.getSize();
    }
    public UserShip(UserShip userShip) {
        this.start = new Coordinate(userShip.getStart());
        this.end = new Coordinate(userShip.getEnd());
        this.ship = userShip.ship;
        this.fullPart = userShip.ship.getSize();
    }

    public static boolean checkPosition(Ship ship, Coordinate start, Coordinate end) {
        boolean res = false;

        if (start.getX() == end.getX() && ship.getSize() == end.getY() - start.getY() + 1
            || start.getY() == end.getY() && ship.getSize() == end.getX() - start.getX() + 1) {
            res = true;
        }

        return res;
    }

    public static boolean checkLength(Ship ship, Coordinate start, Coordinate end) {
        boolean res = false;

        if (ship.getSize() == end.getY() - start.getY() + 1
                || ship.getSize() == end.getX() - start.getX() + 1) {
            res = true;
        }

        return res;
    }


    public Ship getShip() {
        return ship;
    }

    public Coordinate getEnd() {
        return end;
    }

    public Coordinate getStart() {
        return start;
    }

    @Override
    public String toString() {
        return "UserShip{" +
                "ship=" + ship +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public int getFullPart() {
        return fullPart;
    }

    public void setShort() {
        this.fullPart = this.fullPart == 0 ? 0 : this.fullPart - 1;
    }
}
