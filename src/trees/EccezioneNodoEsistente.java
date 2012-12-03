package trees;

@SuppressWarnings("serial")
public class EccezioneNodoEsistente extends RuntimeException {
	public EccezioneNodoEsistente(String str) {
		super(str);
	}

	public EccezioneNodoEsistente() {
	}
}
