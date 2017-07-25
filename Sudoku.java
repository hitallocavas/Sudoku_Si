package testes;

public class Sudoku {
	//Declaração do vetor
	int[][] matriz;
	
	
	//Construtor
	public Sudoku(int[][] matriz){
		this.matriz = matriz;
	}
	
public boolean SUDOKU() {
		
		int lin, col;
		int[] vazia = posicoesVazias();
		lin = vazia[0];
		col = vazia[1];
		
		if (lin == -1) {
			// Tá preenchido
			return true;
		}
		// Há de se preencher
		for (int i = 1; i <= 9; i++) {
			// check if number i is safe for grid[row][col] cell
			if (checkUso(lin, col, i)) {
				// means its safe to fill the number
				this.matriz[lin][col] = i;
				// fill the rest of the grid
				if (SUDOKU()) {
					return true;
				}
				matriz[lin][col] = 0;
			}
		}
		return false; //backtrack 
	}

	
	public boolean checkUso(int lin, int col, int n) {
		int inicio = lin - lin % 3;
		int fim = col - col % 3;	
		if (!checkLinha(lin, n) && !checkColuna(col, n)
				&& !checkBloco(inicio,fim, n)) {
			return true;
		}
		return false;
	}
	
	//Checa se o número já é usado na linha
	public boolean checkLinha(int lin, int n){
		for (int i = 0; i < 9; i++) {
		    if (matriz[lin][i] == n) {
				return true;
			}
		}
		return false;
	}
	
	//Checa se o número já é usado na coluna
	public boolean checkColuna(int col, int n){
		for (int i = 0; i < 9; i++) {
		    if (matriz[i][col] == n) {
				return true;
			}
		}
		return false;
    }
	
	//Verifica em blocos de 3 se o número já é usado em alguma posição do vetor
	
	public boolean checkBloco(int inicio, int fim, int n) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (matriz[i + inicio][j + fim] == n) {
					return true;
				}
			}
		}
		return false;
	}
	
	//Me dá as posições vazias, ou seja, 0
	public int[] posicoesVazias() {
		
		int[] campo = new int[2]; 
		
		for (int i = 0; i < 9; i++) {
			
			for (int j = 0; j < 9; j++) {
			
				if (matriz[i][j] == 0) {
					campo[0] = i;
					campo[1] = j;
					return campo;
				}
			}
		}
		
		campo[0] = -1;
		campo[1] = -1;
		return campo; 
	}
	
	//Imprime
	public void imprime() {
		for (int lin = 0; lin < 9; lin++) {
			for (int col = 0; col < 9; col++) {
				System.out.print(matriz[lin][col]);
			}
			System.out.println("");
		}
		System.out.println("");
	}
	

}
