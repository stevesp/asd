package labs.lab20120210.orologio;

public class EccezioneOrologioVuoto extends RuntimeException {

	public EccezioneOrologioVuoto() {
	}

	public EccezioneOrologioVuoto(String message) {
		super(message);
	}

}
