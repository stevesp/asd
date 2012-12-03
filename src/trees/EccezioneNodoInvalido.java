package trees;

@SuppressWarnings("serial")
public class EccezioneNodoInvalido extends RuntimeException {
	public EccezioneNodoInvalido(String str) {
		super(str);
	}

	public EccezioneNodoInvalido() {
	}
}
