package lists.listdoublelinked;

class CellaDouble {

	Object elemento;

	PuntatoreDouble successivo;

	PuntatoreDouble precedente;

	/**
	 * 
	 */
	public CellaDouble() {
		successivo = precedente = null;
	}

	public CellaDouble(Object e) {
		elemento = e;
		successivo = precedente = null;
	}

}
