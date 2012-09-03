package lab20100916.maze;

public class EccezionePosizioneNonValida extends RuntimeException {

	public EccezionePosizioneNonValida() {
	}

	public EccezionePosizioneNonValida(String message) {
		super(message);
	}

}
