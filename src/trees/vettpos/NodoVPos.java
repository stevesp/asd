package trees.vettpos;
import trees.Albero;
import trees.Nodo;




public class NodoVPos implements Nodo, Cloneable {

	Object info;
	
	int indice;
	
	Albero albero;

	int arita;
	
	public NodoVPos(Object info) {
		this.info = info;
		}
	
	 public Object clone() {
         try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
 }


	public String toString(){
		return info.toString();
		
	}
}
