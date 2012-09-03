package labs.lab20100222.layout;

public class Block {
	
	private static int idCount = 0;
	
	private int id;
	private Point2D tl, br;
	private TypeC tc;
	
	public Block(Point2D tl, Point2D br, TypeC tc) {
		this.id = this.idCount++;
		this.tl = tl;
		this.br = br;
		this.tc = tc;
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		
		str.append("[ ");
		
		str.append(id+" |");
		str.append("TL: "+tl+" ");
		str.append("BR: "+br+" ");
		str.append("TypeC: "+tc+" ");
		
		str.append("]");
		
		return str.toString();
	}
	
	public int getId(){
		return this.id;
	}
	
	public Point2D getTl(){
		return this.tl;
	}
	
	public Point2D getBr(){
		return this.br;
	}
	
	public TypeC getTc(){
		return this.tc;
	}
}
