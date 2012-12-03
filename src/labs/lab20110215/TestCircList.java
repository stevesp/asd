package labs.lab20110215;

import labs.lab20110215.circlist.CircList;
import labs.lab20110215.circlist.Direction;
import labs.lab20110215.circlist.ListCircDL;

public class TestCircList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CircList<String> c = new ListCircDL<String>();
		c.setDir(Direction.FORWARD);

		c.addCircList(new String("alfa"));
		c.addCircList(new String("beta"));
		c.addCircList(new String("gamma"));
		c.addCircList(new String("delta"));
		c.addCircList(new String("epsilon"));

		for (String s : c)
			System.out.println(s);

		c.setDir(Direction.BACKWARD);
		c.ruota();

		System.out.println();
		for (String s : c)
			System.out.println(s);

		c.setDir(Direction.FORWARD);
		c.ruota();

		System.out.println();
		for (String s : c)
			System.out.println(s);

		int i = 0;
		for (i = 0; i < c.numItem(); i++) {
			if (c.value().startsWith("d")) {
				c.delCircList();
				break;
			}
			c.ruota();
		}

		// riporto la lista al primo elemento
		for (; i < c.numItem(); i++) {
			c.ruota();
		}

		System.out.println();
		for (String s : c)
			System.out.println(s);
	}

}
