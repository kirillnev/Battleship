package battleship;

public enum Ship {

    AIRCRAFT_CARRIER(5, "Aircraft Carrier"),
    BATTLESHIP(4, "Battleship"),
    SUBMARINE(3, "Submarine"),
    CRUISER(3, "Cruiser"),
    DESTROYER(2, "Destroyer");

    private int size;
    private String name;


    Ship(int size, String name) {
        this.size = size;
        this.name = name;
    }

    public int getSize() {
        return this.size;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "size=" + size +
                ", name='" + name + '\'' +
                '}';
    }
}
