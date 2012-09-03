package graphs;


public class GrafoLA implements Grafo {

	ArcoLA[] archi= new ArcoLA[0];
	NodoLA[] nodi= new NodoLA[0];
	
	@Override
	public boolean isEmpty() {
		return nodi.length==0;
	}

	@Override
	public Nodo creaNodo(Object info) {
		return new NodoLA(info, null);
	}

	private boolean checkNode(Nodo v) 	{
		if( v==null) return true;
		if(((NodoLA)v).grafo!=this) return true;
		return false;
	}
	
	@Override
	public void aggiungiNodo(Nodo n) {
		if(!checkNode(n)) throw new EccezioneErroreNodo("nodo già esistente");
	
		NodoLA[]tmp= new NodoLA[nodi.length+1];
		System.arraycopy(nodi, 0, tmp, 0, nodi.length);
		tmp[nodi.length]=(NodoLA) n;
		tmp[nodi.length].grafo=this;
		nodi=tmp;	
	}

	@Override
	public Arco creaArco(Nodo src, Nodo dst, Object info) {
		if(checkNode(src)&& checkNode(dst)) throw new EccezioneErroreNodo("nodo inesistente");
		return new ArcoLA(src, dst, info);
	}

	@Override
	public void aggiungiArco(Arco a) {
		if(arcoIncidente(((ArcoLA)a).src,((ArcoLA)a).dst )!=null)
			throw new EccezioneArchiInesistenti("arco esiste");
		
		ArcoLA[] tmp = new ArcoLA[archi.length+1];
		System.arraycopy(archi, 0, tmp, 0, archi.length);
		tmp[archi.length]=(ArcoLA) a;
		archi=tmp;
	}

	@Override
	public Arco arcoIncidente(Nodo src, Nodo dst) {
		if(checkNode(src)&& checkNode(dst)) throw new EccezioneErroreNodo("nodo inesistente");

		for(int i=0; i<archi.length; i++){
			if(archi[i].src==src && archi[i].dst==dst)
				return archi[i];
		}
		
		return null;
	}

	@Override
	public void cambiaInfoArco(Arco a, Object info) {
		if(arcoIncidente(((ArcoLA)a).src,((ArcoLA)a).dst )==null)
			throw new EccezioneArchiInesistenti("arco inesiste");
		
		((ArcoLA)a).info = info;
	}

	@Override
	public void cambiaInfoNodo(Nodo n, Object info) {
		if(checkNode(n)) throw new EccezioneErroreNodo("nodo inesistente");
		
		((NodoLA)n).info = info;
	}

	@Override
	public Object infoArco(Arco a) {
		return ((ArcoLA)a).info;
	}

	@Override
	public Object infoNodo(Nodo n) {
		if(checkNode(n)) throw new EccezioneErroreNodo("nodo inesistente");
		
		return ((NodoLA)n).info;
	}

	@Override
	public Lista nodiAdiacenti(Nodo n) {
		if(checkNode(n)) throw new EccezioneErroreNodo("nodo inesistente");
		
		Lista adiacenti = new linkedList();
		
		for(int i=0; i<archi.length; i++){
			if(archi[i].src==n)
				adiacenti.insert(archi[i].dst);
			else if(archi[i].dst==n)
				adiacenti.insert(archi[i].src);
		}
		
		return adiacenti;
	}

}
