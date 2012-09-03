package labs.lab20110915.collaborazione;

public class EccezioneAnnoNonValido extends RuntimeException {

	public EccezioneAnnoNonValido() {
	}

	public EccezioneAnnoNonValido(String message) {
		super(message);
	}
}
