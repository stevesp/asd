package lab20110215.circlist;

public class EccezioneListaVuota extends RuntimeException {

	public EccezioneListaVuota() {
	}

	public EccezioneListaVuota(String message) {
		super(message);
	}

}
