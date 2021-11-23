
import java.util.Random;
import java.util.Scanner;

import contas.Conta;

public class Balcao extends InteraccaoBanco {
	protected static void menuPrincipalBanco() {
		int menuPrincipal = 0;
		Scanner opcaousuario = new Scanner(System.in);
		boolean emexecucao = true;
		while (emexecucao == true) {

			System.out.println("Menu Principal");

			System.out.println("1 -> Criar Clente");
			System.out.println("2 -> Desativar Cliente");
			System.out.println("3 -> Criar Conta");
			System.out.println("4 -> Desativar Conta");
			System.out.println("5 -> Listar Clientes");
			System.out.println("6 -> Operações sobre Clientes");
			System.out.println("7 -> Sair");
			System.out.println("Digitar opção desejada!");

			menuPrincipal = opcaousuario.nextInt();
			switch (menuPrincipal) {
			case 1:
				Scanner criacao = new Scanner(System.in);
				String nome;
				System.out.println("Informe o nome do Cliente!");
				nome = criacao.nextLine();
				System.out.println("Insira a password do Cliente!");
				int senha = 0;
				senha = criacao.nextInt();
				Random random = new Random();
				int numero = random.nextInt(9999);
				Banco.criarCliente(nome, numero, senha);
				System.out.println("Seu Id é " + numero);
				break;
			case 2:
				Scanner dstcli = new Scanner(System.in);
				System.out.println("Insira o Id do Cliente");
				int id = dstcli.nextInt();
				Cliente clt = Banco.procurarCliente(id);
				if (clt == null) {
					System.out.println("cliente inexistente");
					break;
				}
				clt.setAtivo(false);
				System.out.println("Cliente destivado com sucesso");
				break;
			case 3:
				Scanner criarcnt = new Scanner(System.in);
				System.out.println("Insira o Id do Cliente");
				int valor2 = criarcnt.nextInt();
				Cliente cliente = Banco.procurarCliente(valor2);
				System.out.println("Qual o tipo de conta? (1-Débito / 2-Prazo)");
				int tipo = criarcnt.nextInt();
				if (tipo > 2 || tipo < 0) {
					System.out.println("Conta Inválida");
					break;
				}
				int nib = Banco.criarConta(cliente, tipo);
				Conta conta = Banco.obterConta(nib);
				conta.mostrar();
				break;
			case 4:
				Scanner desatc = new Scanner(System.in);
				System.out.println("Insira o nib do Cliente");
				int nibc = desatc.nextInt();
				Conta cnt = Banco.obterConta(nibc);
				if (cnt == null) {
					System.out.println("Conta inexistente");
					break;
				}
				cnt.desactivar();
				break;
			case 5:
				Scanner listacltes = new Scanner(System.in);
				System.out.println("Insira o Nome do Clente a listar (Enter para listar todos)");
				String nomealistar = listacltes.nextLine();
				Banco.listarClientes(nomealistar);
				break;
			case 6:
				Scanner pmd = new Scanner(System.in);
				System.out.println("Insira o Id do Cliente");
				int ind = pmd.nextInt();
				Cliente clts = Banco.procurarCliente(ind);
				if (clts == null) {
					System.out.println("cliente inexistente");
					break;
				}
				if (clts.isAtivo() == false) {
					System.out.println("Cliente não está Ativo");
					break;
				}
				processaMenuContas(clts.obterContas());
				break;
			case 7:
				System.out.println("Saiu da conta");
				System.exit(0);
			}
		} // while
	}

	public static void main(String[] args) {
		Banco.iniciar();
		menuPrincipalBanco();
	}
}
