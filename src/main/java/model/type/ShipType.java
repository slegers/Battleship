package model.type;

/**
 * @author: Louis Roebben
 */
public enum ShipType {
	Aircraftcarrier(5,1), Battleship(4,2), Cruiser(3,3), Submarine(3,3), Destroyer(2,4);

	private final int size;
	private int maxShips;
	ShipType(int Size, int maxShips) {
		this.size = Size;
		this.maxShips = maxShips;
	}
	public int getSize(){
		return size;
	}

    public int getMaxShips() {
        return maxShips;
    }

	public void setMaxShips(int maxShips) {
		this.maxShips = maxShips;
	}
}

