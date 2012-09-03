package labs.lab20100916.maze;

import java.util.Random;

import labs.lab20100916.pilacollegata.PilaCollegata;

public class Maze {

	private int[][] maze;
	private PilaCollegata<Posizione> pila;
	
	public Maze(int[][] maze) {
		this.maze = maze;
		this.pila = new PilaCollegata<Posizione>();
	}
	
	private boolean puntoUscita(Posizione p){
		return ( (p.row == 0) || (p.column == 0) || 
				(p.row == maze.length - 1) || 
				(p.column == maze[p.row].length - 1) &&
				(maze[p.row][p.column] == 0) );
	}
	
	public boolean attraversa(Posizione start){
		if(!valido(start))
			return false;
		
		if (maze[start.row][start.column] == 2)
			return false;
		
		pila.push(start);

		boolean exit = false;
		
		if(puntoUscita(start))
			return true;
		else {
			maze[start.row][start.column] = 2;
			
			//attraversa() sui 4 lati
			exit = attraversa(new Posizione(start.row - 1, start.column));
			if (exit) return true;
			
			exit = attraversa(new Posizione(start.row, start.column + 1));
			if (exit) return true;
			
			exit = attraversa(new Posizione(start.row + 1, start.column));
			if (exit) return true;
			
			exit = attraversa(new Posizione(start.row, start.column - 1));
			
			//se è un vicolo cieco elimina l'ultimo punto visitato dallo stack
			if (!exit) pila.pop();
		}
		
		return exit;
	}
	
	public boolean valido(Posizione p){
		if(p.row == maze.length || p.column == maze[p.row].length ||
				p.row < 0 || p.column < 0)
			throw new EccezionePosizioneNonValida("Posizione fuori dal labirinto");
		
		return (maze[p.row][p.column] == 0);
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		
		str.append("[ ");
		
		for(Posizione p:pila)
			str.append(p);

		str.append(" ]");
		
		return str.toString();
	}
	
	public static void main(String[] args){
		Random random = new Random();
		
		int size = random.nextInt(3) + 4;
		int[][] labirinto = new int[size][size];
		
		for(int i=0; i<labirinto.length; i++)
			for(int j=0; j<labirinto[i].length; j++)
				labirinto[i][j] = random.nextInt(2);
		
		Posizione iniziale = new Posizione(random.nextInt(labirinto.length), 
				random.nextInt(labirinto.length));
		
		Maze lab = new Maze(labirinto);
		
		StringBuffer str = new StringBuffer();
		for(int i=0; i<labirinto.length; i++){
			for(int j=0; j<labirinto[i].length; j++)
				str.append(labirinto[i][j]+" ");
			str.append("\n");
		}
		System.out.println(str);
		
		if(lab.attraversa(iniziale))
			System.out.println(lab);
		else
			System.out.println("Partendo dalla posizione "+iniziale+" il labirinto non ha soluzioni");
	}
	
}
