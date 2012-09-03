package polacca;

@SuppressWarnings("serial")
public class EccezioneEspressioneNonValida extends RuntimeException {
	public EccezioneEspressioneNonValida(String str){
		super(str);
	}

	public EccezioneEspressioneNonValida(){
	}
}