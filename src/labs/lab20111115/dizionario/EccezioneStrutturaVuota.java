package labs.lab20111115.dizionario;

public class EccezioneStrutturaVuota extends RuntimeException {
	public EccezioneStrutturaVuota(String messaggioErrore) {
		super(messaggioErrore);
	}

	public EccezioneStrutturaVuota() {
	}
}
