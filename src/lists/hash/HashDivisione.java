package lists.hash;


public class HashDivisione implements Hash {

	@Override
	public int h(Comparable<Object> k, int n) {
		return Math.abs(k.hashCode()) % n;
	}

}
