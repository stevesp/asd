package labs.lab20090615.lista;

public class EccezioneListaVuota extends RuntimeException {

	public EccezioneListaVuota() {
	}

	public EccezioneListaVuota(String message) {
		super(message);
	}
}
