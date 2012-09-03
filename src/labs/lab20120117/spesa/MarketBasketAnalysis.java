package labs.lab20120117.spesa;

import java.util.HashMap;

public class MarketBasketAnalysis {

	private HashMap<Class, Integer> qTotArticolo;
	
	public MarketBasketAnalysis(){
		this.qTotArticolo = new HashMap<Class, Integer>();
	}
	
	public void add(Carrello trolley){
		for(Item i:trolley){
			System.out.println(i);

			Class _class = i.getArticolo().getClass();
			while(! _class.getSimpleName().equals("Object")){
				int qTa = readQuantita(_class) + i.getQuantita();
				qTotArticolo.put(_class, qTa);
				_class = _class.getSuperclass();
			}
		}
	}
	
	private int readQuantita(Class classe){
		Integer value = qTotArticolo.get(classe);
		return (value == null ? 0 : value);
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		
		for(Class c : qTotArticolo.keySet()) {
			buffer.append(c.getSimpleName());
			buffer.append(" ");
			buffer.append(qTotArticolo.get(c));
			buffer.append("\n");
		}
			
		return buffer.toString();
	}
}
