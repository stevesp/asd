package objects;

public class Chiave implements Comparable<Object> {
	
	public Chiave(String c){
		this.c=c;
	}
	
	public Chiave(){
		this.c=null;
	}
	
	@Override
	public int compareTo(Object o) {
		if(((Chiave)o).getC().compareTo(this.c)<0)
			return +1;
		else 
			if(((Chiave)o).getC().compareTo(this.c)>0)
				return -1;
		return 0;
	}

	public String getC() {
		return this.c;
	}
	
	private String c;

}
