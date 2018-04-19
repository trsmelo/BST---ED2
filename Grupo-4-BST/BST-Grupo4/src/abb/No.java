package abb;


/**
 * Estrutura auxiliar que cont�m um valor inteiro e dois n�s filhos. Um n� folha possui seus dois filhos iguais a null 
 */
public class No 
{
	private int valor;
	private No noFilhoEsquerda;
	private No noFilhoDireita;
	
	public No(){
		
	}
	
	public No (int valor)
	{
		this.valor = valor;
		noFilhoEsquerda = null;
		noFilhoDireita = null;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public No getNoFilhoEsquerda() {
		return noFilhoEsquerda;
	}

	public void setNoFilhoEsquerda(No noFilhoEsquerda) {
		this.noFilhoEsquerda = noFilhoEsquerda;
	}

	public No getNoFilhoDireita() {
		return noFilhoDireita;
	}

	public void setNoFilhoDireita(No noFilhoDireita) {
		this.noFilhoDireita = noFilhoDireita;
	}	
	
	
}
