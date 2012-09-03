package lists.listdoublelinked;

import lists.Posizione;

class PuntatoreDouble implements Posizione {
	
	public CellaDouble link;
	
	public PuntatoreDouble(CellaDouble c) {
		link = c;
	}
}
