package lab20100916.maze;

public class Posizione {

	int row, column;
	
	Posizione(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	@Override
	public String toString() {
		return "("+this.row+", "+this.column+")";
	}
	
}
