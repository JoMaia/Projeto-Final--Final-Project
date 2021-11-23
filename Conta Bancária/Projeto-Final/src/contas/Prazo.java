package contas;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import transacoes.Levantamento;
import transacoes.Transferencia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class Prazo extends Conta{

	private double taxaJuros;
	private Date dataValidade;
	private double valorJurosAcomulado;
	

	public Prazo() {
		super();
		
		LocalDate dataValidadeAtualizada = datacriacao.toInstant()
								                .atZone(ZoneId.systemDefault())
								                .toLocalDate()
								                .plusYears(1);


		this.dataValidade = Date.from(dataValidadeAtualizada
								.atStartOfDay()
								.atZone(ZoneId.systemDefault())
								.toInstant());
	}
	private void aplicarTaxaJuros(double valorMovimento) {
		        Date criacaoConta;
		        Date dataValidadeConta;
		        Date hoje;
		        long diferencaDataCriacaoAteHoje = 0;
		        long quantidadeDiasConta = 0;
				try {
					 hoje = new Date();
					 dataValidadeConta = dataValidade;
					 criacaoConta = datacriacao;
					 
					long diff = hoje.getTime() - criacaoConta.getTime();

			        TimeUnit time = TimeUnit.DAYS;
			         diferencaDataCriacaoAteHoje = time.convert(diff, TimeUnit.MILLISECONDS);
			         long diff2 = dataValidadeConta.getTime()- criacaoConta.getTime();
			         quantidadeDiasConta = time.convert(diff2, TimeUnit.MILLISECONDS);
			         
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				double porcentagem = (diferencaDataCriacaoAteHoje / quantidadeDiasConta);
				valorJurosAcomulado = porcentagem * taxaJuros * valorMovimento;
	}
	@Override
	public boolean levantar(int valor) {	
		if(saldo >= valor) {
			saldo = saldo - valor;
			aplicarTaxaJuros(valor);
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
			aplicarTaxaJuros(valor);
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
