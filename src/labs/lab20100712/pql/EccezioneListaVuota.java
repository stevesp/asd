package labs.lab20100712.pql;

public class EccezioneListaVuota extends RuntimeException {

	public EccezioneListaVuota() {
	}

	public EccezioneListaVuota(String message) {
		super(message);
	}

}
