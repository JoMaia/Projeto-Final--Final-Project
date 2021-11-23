package transacoes;

import java.util.Date;

import contas.Conta;

public class Transferencia extends Transaccao {
	private Conta contaDestino;
	
	public Transferencia(Date date, Conta conta, int valor, Conta destino) {
		super(date, conta, valor);
	this.contaDestino = destino; 
	}
		
		@Override
		public String mostrar() {
			return "Transferencias,"+";"+ super.date +";"+  super.conta +";"+  super.valor + "€";

		}
		public String obterTipo() {
			return "Transferencia";
			}

}
