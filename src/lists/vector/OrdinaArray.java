package lists.vector;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Random;

import arrangements.BubbleSort;
import arrangements.InsertionSort;
import arrangements.MergeSort;
import arrangements.QuickSort;
import arrangements.SelectionSort;
import arrangements.ShellSort;

public class OrdinaArray {

	/*
	 * Inizializza l'array di interi A con numeri interi generati in maniera
	 * casuale con valore tra 1 e A.length
	 * 
	 * @param A
	 */
	static void inizializzaArrayCasuale(Integer A[], Integer max) {
		Random num = new Random();

		Date date = new Date();
		num.setSeed(date.getTime());

		for (Integer i = new Integer(0); i < A.length; i++)
			A[i] = num.nextInt(max);
	}

	/*
	 * Inizializza l'array di interi A con i numeri interi 1, 2, 3,..., A.length
	 * 
	 * @param A
	 */
	static void inizializzaArrayCrescente(Integer A[]) {
		for (Integer i = new Integer(0); i < A.length; i++)
			A[i] = i + 1;
	}

	/*
	 * Inizializza l'array di interi A con numeri interi A.length,
	 * A.length-1,...,2, 1
	 * 
	 * @param A
	 */
	static void inizializzaArrayDecrescente(Integer A[]) {
		for (Integer i = new Integer(A.length - 1); i >= 0; i--)
			A[i] = A.length - i;
	}

	/*
	 * Q Stampa gli elementi contenuti nell'array A
	 * 
	 * @param A
	 */
	static void stampaArray(Integer A[]) {
		for (Integer i : A)
			System.out.print(i + " ");
		System.out.println(" ");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer maxDim, step;
		Integer nroConfrontiBS = new Integer(0), nroConfrontiCrescenteBS = new Integer(
				0), nroConfrontiDecrescenteBS = new Integer(0);
		Integer nroConfrontiSS = new Integer(0), nroConfrontiCrescenteSS = new Integer(
				0), nroConfrontiDecrescenteSS = new Integer(0);
		Integer nroConfrontiIS = new Integer(0), nroConfrontiCrescenteIS = new Integer(
				0), nroConfrontiDecrescenteIS = new Integer(0);
		Integer nroConfrontiSH = new Integer(0), nroConfrontiCrescenteSH = new Integer(
				0), nroConfrontiDecrescenteSH = new Integer(0);
		Integer nroConfrontiQS = new Integer(0), nroConfrontiCrescenteQS = new Integer(
				0), nroConfrontiDecrescenteQS = new Integer(0);
		Integer nroConfrontiMS = new Integer(0), nroConfrontiCrescenteMS = new Integer(
				0), nroConfrontiDecrescenteMS = new Integer(0);
		maxDim = new Integer(args[0]).intValue();
		step = new Integer(args[1]).intValue();

		final Integer MAX = new Integer(3 * maxDim);

		try {
			FileOutputStream file = new FileOutputStream("statistica.csv");
			PrintStream Output = new PrintStream(file);
			Output.println("dimArray, nroConfrontiBS, nroConfrontiCrescenteBS, nroConfrontiDecrescenteBS,"
					+ "nroConfrontiSS, nroConfrontiCrescenteSS, nroConfrontiDecrescenteSS,"
					+ "nroConfrontiIS, nroConfrontiCrescenteIS, nroConfrontiDecrescenteIS,"
					+ "nroConfrontiSH, nroConfrontiCrescenteSH, nroConfrontiDecrescenteSH,"
					+ "nroConfrontiQS, nroConfrontiCrescenteQS, nroConfrontiDecrescenteQS,"
					+ "nroConfrontiMS, nroConfrontiCrescenteMS, nroConfrontiDecrescenteMS");

			for (Integer i = new Integer(step); i <= maxDim; i += step) {
				Integer A[] = new Integer[i];
				System.out.println("Array di dimensione " + i);
				System.out
						.println("***************************************************");
				System.out.print("Uso del generatore di numeri casuali: ");
				inizializzaArrayCasuale(A, MAX);
				stampaArray(A);
				nroConfrontiBS = BubbleSort.sort(A);
				System.out.print(": " + nroConfrontiBS
						+ " confronti per ottenere (BubbleSort) ");
				stampaArray(A);
				inizializzaArrayCasuale(A, MAX);
				nroConfrontiSS = SelectionSort.sort(A);
				System.out.print(": " + nroConfrontiSS
						+ " confronti per ottenere (SelectionSort) ");
				stampaArray(A);
				inizializzaArrayCasuale(A, MAX);
				nroConfrontiIS = InsertionSort.sort(A);
				System.out.print(": " + nroConfrontiIS
						+ " confronti per ottenere (InvertionSort) ");
				stampaArray(A);
				inizializzaArrayCasuale(A, MAX);
				nroConfrontiSH = ShellSort.sort(A);
				System.out.print(": " + nroConfrontiSH
						+ " confronti per ottenere (ShellSort) ");
				stampaArray(A);
				inizializzaArrayCasuale(A, MAX);
				nroConfrontiQS = QuickSort.sort(A, 0, A.length - 1);
				System.out.print(": " + nroConfrontiQS
						+ " confronti per ottenere (QuickSort) ");
				stampaArray(A);
				inizializzaArrayCasuale(A, MAX);
				nroConfrontiMS = MergeSort.sort(A, 0, A.length - 1);
				System.out.print(": " + nroConfrontiMS
						+ " confronti per ottenere (MergeSort) ");
				stampaArray(A);
				System.out.println("");
				inizializzaArrayCrescente(A);
				System.out.print("Array crescente: ");
				stampaArray(A);
				nroConfrontiCrescenteBS = BubbleSort.sort(A);
				System.out.print(": " + nroConfrontiCrescenteBS
						+ " confronti per ottenere (BubbleSort) ");
				stampaArray(A);
				inizializzaArrayCrescente(A);
				nroConfrontiCrescenteSS = SelectionSort.sort(A);
				System.out.print(": " + nroConfrontiCrescenteSS
						+ " confronti per ottenere (SelectionSort) ");
				stampaArray(A);
				inizializzaArrayCrescente(A);
				nroConfrontiCrescenteIS = InsertionSort.sort(A);
				System.out.print(": " + nroConfrontiCrescenteIS
						+ " confronti per ottenere (InvertionSort) ");
				stampaArray(A);
				inizializzaArrayCrescente(A);
				nroConfrontiCrescenteSH = ShellSort.sort(A);
				System.out.print(": " + nroConfrontiCrescenteSH
						+ " confronti per ottenere (ShellSort) ");
				stampaArray(A);
				inizializzaArrayCrescente(A);
				nroConfrontiCrescenteQS = QuickSort.sort(A, 0, A.length - 1);
				System.out.print(": " + nroConfrontiCrescenteQS
						+ " confronti per ottenere (QuickSort) ");
				stampaArray(A);
				inizializzaArrayCrescente(A);
				nroConfrontiCrescenteMS = MergeSort.sort(A, 0, A.length - 1);
				System.out.print(": " + nroConfrontiCrescenteMS
						+ " confronti per ottenere (MergeSort) ");
				stampaArray(A);
				System.out.println("");
				inizializzaArrayDecrescente(A);
				System.out.print("Array decrescente: ");
				stampaArray(A);
				nroConfrontiDecrescenteBS = BubbleSort.sort(A);
				System.out.print(": " + nroConfrontiDecrescenteBS
						+ " confronti per ottenere (BubbleSort) ");
				stampaArray(A);
				inizializzaArrayDecrescente(A);
				nroConfrontiDecrescenteSS = SelectionSort.sort(A);
				System.out.print(": " + nroConfrontiDecrescenteSS
						+ " confronti per ottenere (SelectionSort) ");
				stampaArray(A);
				inizializzaArrayDecrescente(A);
				nroConfrontiDecrescenteIS = InsertionSort.sort(A);
				System.out.print(": " + nroConfrontiDecrescenteIS
						+ " confronti per ottenere (InvertionSort) ");
				stampaArray(A);
				inizializzaArrayDecrescente(A);
				nroConfrontiDecrescenteSH = ShellSort.sort(A);
				System.out.print(": " + nroConfrontiDecrescenteSH
						+ " confronti per ottenere (ShellSort) ");
				stampaArray(A);
				inizializzaArrayDecrescente(A);
				nroConfrontiDecrescenteQS = QuickSort.sort(A, 0, A.length - 1);
				System.out.print(": " + nroConfrontiDecrescenteQS
						+ " confronti per ottenere (QuickSort) ");
				stampaArray(A);
				inizializzaArrayDecrescente(A);
				nroConfrontiDecrescenteMS = MergeSort.sort(A, 0, A.length - 1);
				System.out.print(": " + nroConfrontiDecrescenteMS
						+ " confronti per ottenere (MergeSort) ");
				stampaArray(A);
				System.out.println("");

				Output.println(i + "," + nroConfrontiBS + ","
						+ nroConfrontiCrescenteBS + ","
						+ nroConfrontiDecrescenteBS + "," + nroConfrontiSS
						+ "," + nroConfrontiCrescenteSS + ","
						+ nroConfrontiDecrescenteSS + "," + nroConfrontiIS
						+ "," + nroConfrontiCrescenteIS + ","
						+ nroConfrontiDecrescenteIS + "," + nroConfrontiSH
						+ "," + nroConfrontiCrescenteSH + ","
						+ nroConfrontiDecrescenteSH + "," + nroConfrontiQS
						+ "," + nroConfrontiCrescenteQS + ","
						+ nroConfrontiDecrescenteQS + "," + nroConfrontiMS
						+ "," + nroConfrontiCrescenteMS + ","
						+ nroConfrontiDecrescenteMS);
			}
			Output.close();
		} catch (IOException e) {
			System.out.println("Errore: " + e);
			System.exit(1);
		}
	}

}