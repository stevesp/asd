package trees.vettpos;

@SuppressWarnings("serial")
public class EccezioneNodoInesistente extends RuntimeException {
	public EccezioneNodoInesistente(String str) {
		super(str);
	}

	public EccezioneNodoInesistente() {
	}
}
