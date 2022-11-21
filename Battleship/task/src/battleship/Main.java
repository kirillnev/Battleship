package battleship;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        ButtleShip[] buttleShip = new ButtleShip[2];

        for (int i = 0; i < 2; i++) {
            System.out.println("Player " + (i + 1) + ", place your ships on the game field");
            buttleShip[i] = new ButtleShip();
            System.out.println(buttleShip[i]);
            System.out.println();
            Game.setShips(buttleShip[i]);
            System.out.println("Press Enter and pass the move to another player");
            System.in.read();
        }

        int playerCurrent = 0;
        int playerAnother = 1;

        while (true) {
            System.out.println(buttleShip[playerAnother].toStringHideShips());
            System.out.println("---------------------");
            System.out.println(buttleShip[playerCurrent]);

            System.out.println("\nPlayer " + (playerCurrent + 1) + ", it's your turn:");

            boolean isNextPlayer = false;
            while (!isNextPlayer) {
                String str = scanner.nextLine();
                if (Coordinate.checkCoordinate(str)) {
                    Coordinate cShot = new Coordinate(str);
                    if(buttleShip[playerAnother].doShort(cShot)) {
                        if(buttleShip[playerAnother].isShipSunk(cShot)) {
                            System.out.println("\nYou sank a ship!");
                        } else {
                            System.out.println("\nYou hit a ship!");
                        }
                    } else {
                        System.out.println("\nYou missed!");
                    }
                    isNextPlayer = true;
                } else {
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                }
            }

            if(!buttleShip[playerAnother].isShips()) {
                System.out.println("You sank the last ship. You won. Congratulations!");
                break;
            }
            playerCurrent = playerCurrent == 0 ? 1 : 0;
            playerAnother = playerAnother == 0 ? 1 : 0;

            System.out.println("Press Enter and pass the move to another player");
            System.in.read();
        }
    }
}
