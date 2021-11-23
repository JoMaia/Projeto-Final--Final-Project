package transacoes;

import java.util.Date;

import contas.Conta;

public abstract class Transaccao {
	protected Date date;
	protected Conta conta;
	protected int valor;
	
	public abstract String mostrar();
	
	public abstract String obterTipo();

	public Transaccao(Date date, Conta conta, int valor) {
		super();
		this.date = date;
		this.conta = conta;
		this.valor = valor;
	}
	

}
