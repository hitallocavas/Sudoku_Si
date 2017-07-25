package testes;

import java.util.Scanner;

public class main {
	
	public static String[] leia(){
		String[] a = new String[9];
	    Scanner scan = new Scanner(System.in);
	    for (int i = 0; i < 9; i++) {
			a[i] = scan.next();
		}
	    return a;
	}
	
	public static int[][] transforma(String[] a){
		int[][] matriz = new int[9][9];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				matriz[i][j] = a[i].charAt(j) - 48;
			}
			
		}
		
		return matriz;
	}
	
	public static void main(String[] args) {
				
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();
		Sudoku[] asudoku = new Sudoku[id];    
		    
		    for (int i = 0; i < id; i++) {
				asudoku[i] = new Sudoku(transforma(leia()));
			}
		    
		    System.out.println("");
		    
		    for (int i = 0; i < id; i++) {
		    	
		    	asudoku[i].SUDOKU();
		    	asudoku[i].imprime();
		    	
		    	System.out.println("");
		    	
			}		    
		   
	       

	}

}
