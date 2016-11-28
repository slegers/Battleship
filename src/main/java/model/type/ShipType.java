package model.type;

<<<<<<< HEAD

=======
>>>>>>> aaf47de81dbbbbf32d5a3c361e35518f3d0aadde
public enum ShipType {
	Aircraftcarrier(5,1), BattleShip(4,2), Cruiser(3,3), Submarine(3,3), Destroyer(2,4);

	private int size;
	private int maxShips;
	ShipType(int Size, int maxShips) {
		this.size = Size;
		this.maxShips = maxShips;
	}
	public int getSize(){
		return size;
	}

	public int getMaxShips() {
		return this.maxShips;
	}
	public void setMaxShips(int maxShips){
		this.maxShips = maxShips;
	}
}

