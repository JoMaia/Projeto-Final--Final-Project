
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import contas.Conta;
import contas.Prazo;
import contas.Debito;

public class Banco {
	private static ArrayList<Cliente> clientes;
	private static int numerocliente; // utilizado para as numeracoes dos clientes
	private static int numeroconta; // utilizado para as numeracoes das contas

	public static void simularDados() {
		Cliente joao = new Cliente("joao", 111, 222);
		joao.adicionarConta(new Prazo());
		joao.adicionarConta(new Debito());

		Cliente pedro = new Cliente("pedro", 123, 456);
		pedro.adicionarConta(new Prazo());
		pedro.adicionarConta(new Debito());

		clientes.add(joao);
		clientes.add(pedro);
	}

	public static void iniciar() {
		clientes = new ArrayList<Cliente>();
		simularDados();
	}

	public static int gerarNumConta() {
		return numeroconta++;
	}

	public static int gerarNumCliente() {
		return numerocliente++;
	}

	// METODOS CLIENTES

	/**
	 * Desactiva o cliente com o id passado como parametro. Para isto deve usar o
	 * metodo procurar cliente do banco para encontrar o cliente com esse id. Caso
	 * exista define o estado como inactivo através do metodo desactivar do cliente
	 * 
	 * @param idcliente id do cliente a desactivar
	 * @return booleano a indicar se foi ou nao possivel de desactivar o cliente
	 */
	public static boolean desactivarCliente(int idcliente) {
		Cliente cliente = procurarCliente(idcliente);
		if (cliente == null) {
			return false;
		}
		cliente.setAtivo(false);
		return true;
	}

	/**
	 * Lista os clientes do banco que tem o nome igual ao recebido como parametro.
	 * Caso seja passada uma string vazia entao sao listados todos os clientes
	 * 
	 * @param criterionome nome do cliente a listar
	 */
	public static void listarClientes(String criterionome) {
		Collections.sort(clientes);
		if (criterionome.isEmpty()) {
			for (Cliente cliente : clientes) {
				if (cliente.isAtivo() == true) {
					System.out.println(cliente.obterInformacoes());
				}
			}
		} else {
			for (Cliente cliente : clientes) {
				if (cliente.getNome().equalsIgnoreCase(criterionome)) {
					if (cliente.isAtivo() == true) {
						System.out.println(cliente.obterInformacoes());
					}

				}
			}

		}
	}

	/**
	 * Procura o cliente com o id recebido como parametro e devolve-o caso exista.
	 * Caso não exista devolve null. Este metodo e utilizado noutros metodos do
	 * banco.
	 * 
	 * @param userid id do cliente a procurar
	 * @return devolve o cliente com o id procurado ou null
	 */
	public static Cliente procurarCliente(int userid) {
		Cliente retorno = null;
		for (Cliente cliente : clientes) {
			if (userid == cliente.getUserid()) {
				retorno = cliente;
			}
		}

		if (retorno == null) {
			return null;
		}
		return retorno;
	}

	/**
	 * Utiliza o userid para encontrar o respectivo cliente e se existir confirma
	 * que a password e a correcta para esse utilizador. Caso isso se verifique
	 * devolve o cliente que fez login
	 * 
	 * @param userid   id do utilizador que esta a fazer login
	 * @param password passwor dod utilizador que esta a fazer login
	 * @return Cliente que acabou de fazer login ou null caso não coincidam as
	 *         credênciais
	 */
	public static Cliente validarLogin(int userid, int password) {
		Cliente cliente = procurarCliente(userid);
		if (cliente == null) {
			return null;
		}
		if (cliente.getPassword() == password) {
			return cliente;
		}
		return null;

	}

	/**
	 * Cria um cliente com os dados recebidos e adiciona-o à lista de clientes do
	 * banco
	 * 
	 * @param nome     nome do cliente a adicionar
	 * @param userid   userid do cliente a adicionar
	 * @param password password do cliente a adicionar
	 */
	public static void criarCliente(String nome, int userid, int password) {
		clientes.add(new Cliente(nome, userid, password));
	}

	public static Conta obterConta(int nib) {
		Conta retorno = null;
		for (Cliente cliente : clientes) {
			for (Conta conta : cliente.obterContas()) {
				if (nib == conta.obterNib()) {
					retorno = conta;
				}

			}
		}

		return retorno;
	}

	private static void adicionarConta(int idcliente, Conta c) {
		Cliente cliente = procurarCliente(idcliente);
		if (cliente != null) {
			cliente.adicionarConta(c);
		}
	}

	public static int criarConta(Cliente c, int tipoconta) {
		Cliente cliente = procurarCliente(c.getUserid());
		Conta conta = null;

		if (tipoconta == 1) {
			conta = new Debito();
			cliente.adicionarConta(conta);

		} else if (tipoconta == 2) {
			conta = new Prazo();
			cliente.adicionarConta(conta);
		}
		return conta.getNib();

	}

}
