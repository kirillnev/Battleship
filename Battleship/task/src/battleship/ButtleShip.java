package battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ButtleShip {
    final static int RESOLUTION = 10;
    char[][] field = new char[RESOLUTION][RESOLUTION];
    List<UserShip> userShipList = new ArrayList<>();

    public ButtleShip() {
        for (char[] chArr: field) {
            Arrays.fill(chArr, '~');
        }
    }

    public boolean checkShipLocation(UserShip userShip) {
        int[] c1 = userShip.getStart().getCoordinate();
        int[] c2 = userShip.getEnd().getCoordinate();

        for (int i = c1[0]; i <= c2[0] ; i++) {
            for (int j = c1[1]; j <= c2[1]; j++) {
                if(!isFree(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean setShip(UserShip userShip) {
        if (checkShipLocation(userShip)) {
            int[] c1 = userShip.getStart().getCoordinate();
            int[] c2 = userShip.getEnd().getCoordinate();

            for (int i = c1[0]; i <= c2[0] ; i++) {
                for (int j = c1[1]; j <= c2[1]; j++) {
                    field[i][j] = 'o';
                }
            }
            this.userShipList.add(new UserShip(userShip));
            return true;
        } else {
            return false;
        }
    }

    public boolean isFree(int y, int x) {
        int left = x == 0 ? x : x - 1;
        int right = x == RESOLUTION - 1 ? x : x + 1;
        int top = y == 0 ? y : y - 1;
        int bottom = y == RESOLUTION - 1 ? y : y + 1;

        for (int i = left; i <= right; i++) {
            for (int j = top; j <= bottom ; j++) {
                if (field[j][i] != '~') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean doShort(Coordinate cShot) {
        boolean res = false;
        int y = cShot.getY();
        int x = cShot.getX();
        switch (field[y][x]) {
            case '~' -> {
                field[y][x] = 'M';
                res = false;
            }
            case 'o' -> {
                field[y][x] = 'X';
                res = true;
                for (UserShip ship: userShipList) {
                    if (cShot.getY() >= ship.getStart().getY() && cShot.getY() <= ship.getEnd().getY()
                            && cShot.getX() >= ship.getStart().getX() && cShot.getX() <= ship.getEnd().getX()) {
                        ship.setShort();
                    }
                        res = true;
                }
            }
            default -> {
            }
        }
        return res;
    }

    public boolean isShipSunk(Coordinate cShot) {
        boolean res = false;
        for (UserShip ship: userShipList) {
            if (cShot.getY() >= ship.getStart().getY() && cShot.getY() <= ship.getEnd().getY()
                && cShot.getX() >= ship.getStart().getX() && cShot.getX() <= ship.getEnd().getX()
                && ship.getFullPart() == 0)
                res = true;
        }
        return res;
    }

    public boolean isShips() {
        for (int i = 0; i < RESOLUTION; i++) {
            for (int j = 0; j < RESOLUTION; j++) {
                if(field[i][j] == 'o') {
                    return true;
                }
            }
        }
        return false;
    }

    public String toStringHideShips() {
        String str = "  1 2 3 4 5 6 7 8 9 10";
        for (int i = 0; i < RESOLUTION; i++) {
            str += "\n" + (char) ('A' + i);
            for (int j = 0; j < RESOLUTION; j++) {
                str += " " + (field[i][j] == 'o' ? '~' : field[i][j]);
            }
        }
        return str;
    }


    @Override
    public String toString() {
        String str = "  1 2 3 4 5 6 7 8 9 10";
        for (int i = 0; i < RESOLUTION; i++) {
            str += "\n" + (char) ('A' + i);
            for (int j = 0; j < RESOLUTION; j++) {
                str += " " + field[i][j];
            }
        }
        return str;
    }

}
