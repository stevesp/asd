package labs.lab20100222.layout;

import java.util.LinkedList;
import java.util.List;

import labs.lab20100222.listaarray.ListaArray;
import labs.lab20100222.listaindicizzata.ListaIndicizzata;

public class Layout {
	
	protected ListaIndicizzata<Block> blocchi;
	protected LinkedList<Relation> above;
	protected LinkedList<Relation> left;
	
	public Layout() {
		this.blocchi = new ListaArray<Block>();
		this.above = new LinkedList<Relation>();
		this.left = new LinkedList<Relation>();
	}

	public void addBlock(Block block){
		if (blocchi.getElement(block.getId()) != null)
			throw new BloccoGiaPresente("Blocco già presente nel layout");
		
		blocchi.addElement(block, block.getId());
	}
	
	public boolean isNew(){
		return blocchi.numberElements() == 0;
	}
	
	public void addAbove(Block block1, Block block2){
		if (blocchi.getElement(block1.getId()) == null ||
				blocchi.getElement(block2.getId()) == null)
			throw new BloccoNonPresente("Blocco non presente nel layout");
		
		if (!above(block1,block2))
			throw new EccezionePosizioneNonCorretta(block1 +" non si trova sopra "+ block2);
		
		Relation above = new Relation();
		
		above.b1 = block1.getId();
		above.b2 = block2.getId();
		
		this.above.add(above);
	}
	
	public void addLeft(Block block1, Block block2){
		if (blocchi.getElement(block1.getId()) == null ||
				blocchi.getElement(block2.getId()) == null)
			throw new BloccoNonPresente("Blocco non presente nel layout");
		
		if (!left(block1,block2))
			throw new EccezionePosizioneNonCorretta(block1 +" non si trova a sinistra di "+ block2);
		
		Relation left = new Relation();
		
		left.b1 = block1.getId();
		left.b2 = block2.getId();
		
		this.left.add(left);
	}
	
	public boolean above(Block block1, Block block2){
		if (blocchi.getElement(block1.getId()) == null ||
				blocchi.getElement(block2.getId()) == null)
			throw new BloccoNonPresente("Blocco non presente nel layout");
		
		if (block1.getBr().compareTo(block2.getTl()) >= 0)
			return true;
		else
			return false;
	}
	
	public boolean left(Block block1, Block block2){
		if (blocchi.getElement(block1.getId()) == null ||
				blocchi.getElement(block2.getId()) == null)
			throw new BloccoNonPresente("Blocco non presente nel layout");
		
		if (block1.getTl().compareTo(block2.getTl()) == 0)
			return true;
		else
			return false;
	}
	
	public int numBlocks(){
		return blocchi.numberElements();
	}
	
	public List<Integer> neighbour(Block block){
		if (blocchi.getElement(block.getId()) == null)
			throw new BloccoNonPresente("Blocco non presente nel layout");
		
		List<Integer> neighbour = new LinkedList<Integer>();
		
		for(Relation a:above)
			if (a.b1 == block.getId())
				neighbour.add(a.b2);
			else if (a.b2 == block.getId())
				neighbour.add(a.b1);
						
		for(Relation l:left)
			if (l.b1 == block.getId())
				neighbour.add(l.b2);
			else if (l.b2 == block.getId())
				neighbour.add(l.b1);
			
		return neighbour;
	}
	
}
