package transacoes;

import java.util.Date;

import contas.Conta;

public class Deposito extends Transaccao {
	public Deposito(Date date, Conta conta, int valor) {
	super(date, conta, valor);
}
	
	@Override
	public String mostrar() {
		return "Deposito,"+";"+ super.date +";"+  super.conta +";"+  super.valor + "€";

	}
	public String obterTipo() {
		return "Deposito";
		}
}
