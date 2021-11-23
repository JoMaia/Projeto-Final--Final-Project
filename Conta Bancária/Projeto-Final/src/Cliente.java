import java.util.List;
import java.util.ArrayList;
import contas.Conta;

public class Cliente implements Comparable{
	
	private String nome;
    private int password;
    private int userid;
    private boolean ativo;
    
    private ArrayList<Conta> contas = new ArrayList();
    
	public Cliente(String nome, int userid, int password) {
		super();
		this.nome = nome;
		this.password = password;
		this.userid = userid;
		this.ativo = true;
	}
	public ArrayList<Conta> obterContas(){
		
		return this.contas;

	}
	public Conta obterConta(int nib) {
		Conta retorno = null;
		for(Conta account: contas) {
			if(nib == account.getNib()) {
				retorno = account;
			}
		}
		
		if(retorno == null) {
			return null;
		}
		return retorno;
	}
	
	public void adicionarConta(Conta c){
		contas.add(c);
	}
    
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public  String obterInformacoes(){
		
		return nome + userid + ativo;
		
	}
	@Override
	public int compareTo(Object o) {
		Cliente clienteaComparar = (Cliente) o;
		return nome.compareTo(clienteaComparar.nome);
	}
    
}