package graphs;

@SuppressWarnings("serial")
public class EccezioneArchiInesistenti extends RuntimeException {
	public EccezioneArchiInesistenti(String string) {
		super(string);
	}

	public EccezioneArchiInesistenti() {
	}
}
