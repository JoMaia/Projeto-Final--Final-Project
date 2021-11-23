package contas;

import java.util.Date;

import transacoes.Transaccao;

public class Deposito extends Transaccao{

	private Date date;
	private Conta conta;
	private int valor;
	
	
	public Deposito(Date date, Conta conta, int valor) {
		super(date, conta, valor);
		this.date = date;
		this.conta = conta;
		this.valor = valor;
	}
	@Override
	public String mostrar() {
		return "Deposito,"+ super.date +  super.conta +  super.valor + "€";

	}
	public String obterTipo() {
		return "Deposito";
		}

}
