package transacoes;

import java.util.Date;

import contas.Conta;

public class CapitalizacaoJuros extends Transaccao {
	public CapitalizacaoJuros(Date date, Conta conta, int valor) {
		super(date, conta, valor);
	}
		
		@Override
		public String mostrar() {
			return "CaptalizacaoJuros,"+";"+ super.date +";"+  super.conta +";"+  super.valor + "€";

		}
		public String obterTipo() {
			return "CaptalizacaoJuros";
			}
}
