package teste;

import java.util.Scanner;

import abb.*;

public class Main {

	public static void main(String[] args) {
				
		Scanner reader = new Scanner(System.in);
		System.out.println("1 - Demonstração com valores default \n2 - Inserir/remover nós\n");
		int input = reader.nextInt();
		
		if(input == 1) {
			BinarySearchRecursive abbTree = new BinarySearchRecursive();
			
			abbTree.insereNoRecursivo(17);
			abbTree.insereNoRecursivo(22);
			abbTree.insereNoRecursivo(133);
			abbTree.insereNoRecursivo(2);
			abbTree.insereNoRecursivo(8);
			abbTree.insereNoRecursivo(52);
			abbTree.insereNoRecursivo(30);
			abbTree.insereNoRecursivo(12);
			abbTree.insereNoRecursivo(6);
			
			System.out.print("Arvore Original: ");
			abbTree.display(abbTree.getRaiz());
			
			System.out.println("");
			
			System.out.println("Existe o nº 52 na árvore? " + abbTree.buscaRecursiva(52));
			System.out.println("Existe o nº 20 na árvore? " + abbTree.buscaRecursiva(20));
			
			abbTree.removeNoRecursivo(8);
			System.out.print("Arvore Nova: ");
			abbTree.display(abbTree.getRaiz());
			
		}
		
		if (input == 2){
			BinarySearchRecursive novaArvore = new BinarySearchRecursive();
			while(true) {
			
				System.out.println("\n1 - Inserir\n2 - Remover\n3 - Buscar\n 4 - Sair");
				
				int escolha = reader.nextInt();
				int valor;
				if (escolha == 1){
					System.out.println("Valor do nó a ser inserido: ");
					valor = reader.nextInt();
					novaArvore.insereNoRecursivo(valor);
					System.out.println("\nÁrvore: ");
					novaArvore.display(novaArvore.getRaiz());
					System.out.println("");
				} else if (escolha == 2){
					
					
				} else if (escolha == 3){
					System.out.println("Valor do nó a ser buscado: ");
					valor = reader.nextInt();
					System.out.println("Valor Existe? " + novaArvore.buscaRecursiva(valor));
					System.out.println("");
				} else if (escolha == 4){
					System.out.println("Fim!");
					break;
				}
			}
		}
		
		reader.close();
	}
}
