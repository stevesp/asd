package lists;

@SuppressWarnings("serial")
public class EccezioneChiaveNonValida extends RuntimeException {
	public EccezioneChiaveNonValida(String str) {
		super(str);
	}

	public EccezioneChiaveNonValida() {
	}
}
