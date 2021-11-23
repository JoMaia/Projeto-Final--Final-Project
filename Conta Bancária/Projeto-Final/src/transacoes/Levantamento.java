package transacoes;

import java.util.Date;

import contas.Conta;

public class Levantamento extends Transaccao {
	public Levantamento(Date date, Conta conta, int valor) {
		super(date, conta, valor);
	}
		
		@Override
		public String mostrar(){
			return"Levantamento,"+";"+ super.date +";"+  super.conta +";"+  super.valor + "€";

		}
		public String obterTipo() {
			return "Levantamento";
			}

}
