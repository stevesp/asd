package lists;

@SuppressWarnings("serial")
public class EccezioneChiaveDuplicata extends RuntimeException {
	public EccezioneChiaveDuplicata(String str){
		super(str);
	}

	public EccezioneChiaveDuplicata(){
	}
}
