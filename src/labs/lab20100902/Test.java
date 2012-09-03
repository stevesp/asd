package labs.lab20100902;

import labs.lab20100902.index.IndexGenerator;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IndexGenerator index = new IndexGenerator();
		
		String text = "Sono qui * con Nicola Lamonaca * a smadonnare su * ";
		text+= "questa traccia * di ASD * grazie donato * ti amiamo * ";
		
		index.buildIndex(text);
		
		index.showIndex();
	}

}
