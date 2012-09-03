package labs.lab20100712.pql;

public class EccezioneStatoNonValido extends RuntimeException {

	public EccezioneStatoNonValido() {
	}

	public EccezioneStatoNonValido(String message) {
		super(message);
	}

}
