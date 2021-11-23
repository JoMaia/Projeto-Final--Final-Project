package contas;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import transacoes.Transaccao;

public abstract class Conta {	
	protected double saldo;
	protected int nib;
	protected Date datacriacao;
	protected boolean activa;
	protected ArrayList<Transaccao> transaccoes = new ArrayList();
	//METODOS ABSTRACTOS
	
	/**
	 * Levanta dinheiro desta conta, decrementando o saldo existente
	 * Isto so acontece se a conta tiver o saldo pelo menos igual ao que se pretende levantar
	 * @param valor saldo a retirar desta conta
	 * @return Devolve true ou falso caso tenha sido possivel de fazer o levantamento
	 */
	public abstract boolean levantar(int valor);
	
	public void mostrarExtracto() {
		
		for(Transaccao t : transaccoes) {
			System.out.println(t.mostrar());
			
		}
		System.out.println(saldo);
	}
	
	public void adicionarTransaccao(Transaccao transaccao) {
		this.transaccoes.add(transaccao);
	}
	
	public ArrayList<Transaccao> obterTransaccoes() {
		return this.transaccoes;
		
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNib() {
		return nib;
	}

	public void setNib(int nib) {
		this.nib = nib;
	}

	public Date getDatacriacao() {
		return datacriacao;
	}

	public void setDatacriacao(Date datacriacao) {
		this.datacriacao = datacriacao;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public List getTransaccoes() {
		return transaccoes;
	}

	public void setTransaccoes(ArrayList transaccoes) {
		this.transaccoes = transaccoes;
	}

	/**
	 * Transfere dinheiro desta conta para a conta destino recebida como parametro
	 * Isto so acontece se a conta tiver o saldo pelo menos igual ao que se pretende transferir
	 * E criada um objecto transaccao tanto na conta de origem como na conta de destino
	 * ESTE METODO ASSUME QUE A CONTA DESTINO EXISTE
	 * @param valor valor que se pretende transferir
	 * @param contadestino Conta para a qual se esta a transferir dinheiro
	 * @return Devolve true ou falso caso tenha sido possivel efectuar a transferencia
	 */
	public abstract boolean transferir(int valor, Conta contadestino);	
	
	/**
	 * Retorna uma String representantiva do identificador da conta e do tipo
	 * @return String com informacao da conta
	 */
	public abstract String mostrar();
	
	/**
	 * Retorna uma String com todas as informacoes da conta especifica
	 * @return String com todas as informacoes da conta
	 */
	public abstract String mostrarInformacoes();
	
	/**
	 * Escreve no ecra o saldo corrente da conta
	 */	
	public abstract void mostrarSaldo();
	
	public abstract String obterTipo();	
	
			
	//METODOS IMPLEMENTADOS	
	public Conta(){
		datacriacao = new Date();
		saldo = 0;
		
		Random geradoraleatorio = new Random();
		int numaleatorio = geradoraleatorio.nextInt(Integer.MAX_VALUE);
		nib = numaleatorio;
		activa=true;
	}
		
	/**
	 * Deposita um valor na Conta. Este metodo nao tem qualquer tipo de verificacoes
	 * @param valor valor a depositar
	 */
	public void depositar(int valor){
		saldo += valor;		
		transaccoes.add(new Deposito(new Date(), this, valor));	
	}
		
	public int obterNib(){
		return nib;
	}
	
	public double obterSaldo(){
		return saldo;		
	}
	
	public void desactivar(){
		activa=false;
	}
	
	public boolean estaActiva(){
		return activa;
	}
}
