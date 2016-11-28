package model.type;
<<<<<<< HEAD
public enum ShipType {
	Aircraftcarrier(5,1), BattleShip(4,2), Cruiser(3,3), Submarine(3,3), Destroyer(2,4);


=======

public enum ShipType {
	Aircraftcarrier(5,1), BattleShip(4,2), Cruiser(3,3), Submarine(3,3), Destroyer(2,4);
>>>>>>> 2119ca2bc0cbdcdc25e2fb54e21a567060185b26
	private int size;
	private int maxShips;
	ShipType(int Size, int maxShips) {
		this.size = Size;
		this.maxShips = maxShips;
	}
	public int getSize(){
		return size;
	}

	public int getMaxShips(){
		return this.maxShips;
	}
<<<<<<< HEAD

}
=======
	public void setMaxShips(int maxShips){
		this.maxShips = maxShips;
	}
}
>>>>>>> 2119ca2bc0cbdcdc25e2fb54e21a567060185b26
