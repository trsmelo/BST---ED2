package abb;

public class BinarySearchRecursive {

	private static No raiz;
	private static No pai;
	
	public static No getRaiz() {
		return raiz;
	}

	public static void setRaiz(No raiz) {
		BinarySearchRecursive.raiz = raiz;
	}

	public BinarySearchRecursive() {
		this.raiz = null;
	}

	public boolean buscaRecursiva(int valor) {

		return buscaRecursiva(valor, raiz);
	}

	/**
	 * Realiza a busca por um N� na �rvore bin�ria de busca recursivamente
	 * 
	 */
	private boolean buscaRecursiva(int valor, No noAtual_in) {
		No noAtual = noAtual_in;

		if (noAtual != null) {
			if (noAtual.getValor() == valor) {
				/* Essa sa�da indica que a recurss�o encontrou o n� buscado */
				return true;
			} else if (noAtual.getValor() > valor) {
				noAtual = noAtual.getNoFilhoEsquerda();
			} else {
				noAtual = noAtual.getNoFilhoDireita();
			}
			/* Se n�o encontrou o n� buscado, chama a fun��o novamente */
			if (buscaRecursiva(valor, noAtual)) {
				return true;
			}
			;
		}
		/*
		 * A sa�da da recurs�o acontece quando o n� atual aponta para um valor
		 * null. Este caso indica que o �ltimo n� percorrido era uma folha
		 */
		return false;
	}

	/**
	 * Chamada publica para inser��o recursiva de um n�
	 * 
	 */
	public void insereNoRecursivo(int valor) {

		if (raiz == null) {

			raiz = new No(valor);

		} else {

			insereNoRecursivo(raiz, valor);
		}
	}

	/**
	 * M�todo de inser��o de n� recursivo.Retorna o n� inserido
	 * 
	 */
	private No insereNoRecursivo(No no, int valor) {

		if (valor < no.getValor()) {

			if (no.getNoFilhoEsquerda() != null) { // checa se existe filho a
													// esquerda do no atual

				insereNoRecursivo(no.getNoFilhoEsquerda(), valor);

			} else {

				no.setNoFilhoEsquerda(new No(valor));
			}
		} else if (valor > no.getValor()) {

			if (no.getNoFilhoDireita() != null) { // checa se existe filho a
													// direita do no atual

				insereNoRecursivo(no.getNoFilhoDireita(), valor);
			} else {

				no.setNoFilhoDireita(new No(valor));
			}
		}

		return no; // retorna no inserido
	}
	
	
	public No removeNoRecursivo(int valor){
		return removeNoRecursivo(raiz, valor, pai);
	}
	/**
	 * Remo��o recursiva de no em arvore binaria
	 * 
	 */
	private No removeNoRecursivo(No no, int valor, No pai) {
		
		if (no == null) {

			return null;
		} else if (no.getNoFilhoEsquerda() == null && no.getNoFilhoDireita() == null) {
			if(no.getValor() == valor){
				if(pai.getNoFilhoEsquerda() != null){
					if(pai.getNoFilhoEsquerda().getValor() == valor){
						pai.setNoFilhoEsquerda(null);
					}
				}
				if(pai.getNoFilhoDireita() != null){
					if(pai.getNoFilhoDireita().getValor() == valor)
					{
						pai.setNoFilhoDireita(null);
					}
				}
				return pai;
			}
		} else if (no.getNoFilhoEsquerda() == null && no.getNoFilhoDireita() != null) {
			if (no.getValor() == valor) {
				no = no.getNoFilhoDireita();
				pai.setNoFilhoDireita(null);
				return no;
				
			} else {
				removeNoRecursivo(no.getNoFilhoDireita(), valor, no);
			}
		} else if (no.getNoFilhoEsquerda() != null && no.getNoFilhoDireita() == null) {
			if (no.getValor() == valor) {
				no = no.getNoFilhoEsquerda();
				pai.setNoFilhoEsquerda(null);
				return no;
			} else {
				removeNoRecursivo(no.getNoFilhoEsquerda(), valor, no);
			}
			
		} else if(no.getNoFilhoEsquerda() != null && no.getNoFilhoDireita() != null){
			
			if(no.getValor() < valor){
				removeNoRecursivo(no.getNoFilhoDireita(), valor, no);
			} else if(no.getValor() > valor){
				removeNoRecursivo(no.getNoFilhoEsquerda(), valor, no);
			
			}else{
				int menorNoDireita = minValor(no.getNoFilhoDireita());
				removeNoRecursivo(no.getNoFilhoDireita(), menorNoDireita, no);
				no.setValor(menorNoDireita);
				no.setNoFilhoDireita(null);
			}
		}
		
		return no;
	}

	/**
	 * M�todo que retorna o menor valor a direita de uma subarvore
	 * 
	 */
	public int minValor(No no) {

		if (no.getNoFilhoEsquerda() == null) {

			return no.getValor();
		} else {

			return minValor(no.getNoFilhoEsquerda());
		}
	}

	public void display(No raiz) {
		if (raiz != null) {
			display(raiz.getNoFilhoEsquerda());
			System.out.print(" " + raiz.getValor());
			display(raiz.getNoFilhoDireita());
		}
	}
}
