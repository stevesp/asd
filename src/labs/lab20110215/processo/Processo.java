package lab20110215.processo;

import java.util.Random;

public class Processo {

	private static int idCount = 0;
	private int id;
	private int durata;
	
	public Processo() {
		Random random = new Random();
		
		this.id = idCount++;
		this.durata = random.nextInt(801) + 50;
	}
	
	public boolean execute(int time_slice){
		this.durata -= time_slice;
		
		return this.durata <= 0;
	}
	
	public int getID(){
		return this.id;
	}
	
	public int getDurata(){
		return this.durata;
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		
		str.append("[ ");
		str.append("ID: "+this.id);
		str.append(" durata: "+this.durata);
		str.append(" ]");
		
		return str.toString();
	}
}
