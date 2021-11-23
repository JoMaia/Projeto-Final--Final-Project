package contas;

import java.util.Date;

import transacoes.Levantamento;
import transacoes.Transferencia;

public class Debito extends Conta{

	@Override
	public boolean levantar(int valor) {
		if(saldo >= valor) {
			saldo = saldo - valor;
			transaccoes.add(new Levantamento(new Date(), this, valor));
			return true;
		}
		return false;
	}

	@Override
	public boolean transferir(int valor, Conta contadestino) {
		if(saldo >= valor) {
			saldo = saldo - valor;
			depositar(valor);
			transaccoes.add(new Transferencia(new Date(), this, valor, contadestino));
			return true;
		}
		return false;
	}

	@Override
	public String mostrar() {
		
		return nib + " " + getClass();
	}

	@Override
	public String mostrarInformacoes() {
		
		return "Debito [saldo=" + saldo + ", nib=" + nib + ", datacriacao=" + datacriacao + ", activa=" + activa
				+ ", transaccoes=" + transaccoes;
	}

	@Override
	public void mostrarSaldo() {
		System.out.println(saldo);
	}

	@Override
	public String obterTipo() {
		
		return "debito";
	}

}
