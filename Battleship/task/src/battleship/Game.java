package battleship;

import java.util.Scanner;

public class Game {
    public static void setShips(ButtleShip buttleShip) {
        Scanner scanner = new Scanner(System.in);

        for (Ship ship: Ship.values()) {
            System.out.println("Enter the coordinates of the "
                    + ship.getName() + " ("
                    + ship.getSize() + " cells):");
            while (true) {
                String[] str = scanner.nextLine().split(" ");

                if (Coordinate.checkCoordinate(str[0]) && Coordinate.checkCoordinate(str[1])) {
                    Coordinate c1 = new Coordinate(str[0]);
                    Coordinate c2 = new Coordinate(str[1]);
                    if(c1.compareTo(c2) == 1) {
                        c1  = new Coordinate(str[1]);
                        c2  = new Coordinate(str[0]);
                    }
                    if (UserShip.checkLength(ship, c1, c2)) {
                        if (UserShip.checkPosition(ship, c1, c2)) {
                            UserShip sh1 = new UserShip(ship, c1, c2);
                            if (buttleShip.setShip(sh1)) {
                                System.out.println(buttleShip);
                                System.out.println();
                                break;
                            } else {
                                System.out.println("Error! You placed it too close to another one. Try again:");
                            }
                        } else {
                            System.out.println("Error! Wrong ship location! Try again:");
                        }
                    } else {
                        System.out.println("Error! Wrong length of the " + ship.getName() + "! Try again:");
                    }
                } else {
                    System.out.println("Error! Wrong coordinates! Try again:");
                }
            }
        }
    }
}
