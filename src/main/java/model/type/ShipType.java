package model.type;

<<<<<<< HEAD
public enum ShipType
{
	Aircraftcarrier(5), BattleShip(4), Cruiser(3), Submarine(3), Destroyer(2);

	ShipType(int Size)
	{
=======
public enum ShipType {
	Aircraftcarrier(5,1), BattleShip(4,2), Cruiser(3,3), Submarine(3,3), Destroyer(2,4);
>>>>>>> 2f5672b69a40487a1d3ea718ab9de982c7ce3f2f

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

}
