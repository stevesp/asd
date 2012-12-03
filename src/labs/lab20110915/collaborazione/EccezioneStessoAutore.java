package labs.lab20110915.collaborazione;

public class EccezioneStessoAutore extends RuntimeException {

	public EccezioneStessoAutore() {
	}

	public EccezioneStessoAutore(String message) {
		super(message);
	}

}
