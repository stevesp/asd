package labs.lab20100712.pql;

public class EccezioneElementoNonValido extends RuntimeException {

	public EccezioneElementoNonValido() {
	}

	public EccezioneElementoNonValido(String message) {
		super(message);
	}
}
