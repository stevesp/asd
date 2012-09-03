package lab20100712.pq;


public class Priority {
	
	private int priority;
		
	public Priority(int priority) {
		if(priority < 0 || priority > 100)
			throw new EccezionePrioritaNonValida("Inserire un valore compreso tra 0 e 100");
		
		this.priority = priority;
	}
	
	public int getPriority(){
		return priority;
	}
	
	@Override
	public String toString() {
		
		StringBuffer str = new StringBuffer();
		
		str.append("[ "+priority+" ]");
		
		return str.toString();
	}
}
