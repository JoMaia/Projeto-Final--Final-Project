
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import contas.Conta;
import contas.Debito;
import contas.Prazo;

public abstract class InteraccaoBanco {

	protected static Cliente cli; // � medida que os menus avan�am o cliente a ser usado � guardado nesta variavel
	protected static Conta con;// � medida que os menus avan�am a conta a ser usada � guardada nesta variavel

	/**
	 * Este metodo est� em repeti��o a mostrar o menu de opera��es disponiveis numa
	 * conta. Para cada uma das op��es existentes e atrav�s de um switch solicita a
	 * informa��o necessaria ao utilizador e invoca os metodos correspondentes.
	 */
	protected static void processaMenuConta() {
		int menuopconta = 0;
		Scanner opcaousuario = new Scanner(System.in);
		System.out.println("Menu Opera��es Conta");

		System.out.println("1 -> Levantar");
		System.out.println("2 -> Depositar");
		System.out.println("3 -> Tranferir");
		System.out.println("4 -> Obter extrato");
		System.out.println("5 -> Obter saldo");
		System.out.println("6 -> Obter Informa��es");
		System.out.println("7 -> Sair do Menu");
		System.out.println("Digitar op��o desejada!");

		menuopconta = opcaousuario.nextInt();
		switch (menuopconta) {
		case 1:
			Scanner levantamento = new Scanner(System.in);
			int valor = 0;
			System.out.println("Quanto dinheiro quer levantar?");
			valor = levantamento.nextInt();
			con.levantar(valor);
			break;
		case 2:
			Scanner deposito = new Scanner(System.in);
			int valor1 = 0;
			System.out.println("Quanto dinheiro quer depositar?");
			valor1 = deposito.nextInt();
			con.depositar(valor1);
			break;
		case 3:
			Scanner transferencia = new Scanner(System.in);
			int valor2 = 0;
			System.out.println("qual o nib da conta a transferir?");
			int nib = transferencia.nextInt();
			Conta cnta = Banco.obterConta(nib);
			if (cnta != null) {
				System.out.println("Qual valor a ser depositado?");
				valor2 = transferencia.nextInt();
				con.transferir(valor2, cnta);
			}
			break;
		case 4:
			con.mostrarExtracto();
			break;
		case 5:
			con.mostrarSaldo();
			break;
		case 6:
			con.mostrarInformacoes();
			break;
		case 7:
			System.out.println("Saiu da conta");
			System.exit(0);
		}

	}

	/**
	 * Este metodo est� em repeti��o a mostrar o menu de contas disponiveis do
	 * cliente. De notar que APENAS AS CONTAS ACTIVAS s�o mostradas. Ap�s ser
	 * seleccionada uma conta � invocado o metodo processaMenuConta referente �
	 * conta escolhida
	 * 
	 * @param contascliente Cliente sobre o qual se quer visualizar as contas
	 */
	protected static void processaMenuContas(ArrayList<Conta> contascliente) {
		int opcaomenu = 0;
		Scanner opcaousuario = new Scanner(System.in);
		do {

			System.out.println("Menu Contas");
			for (Conta conta : contascliente) {

				System.out.println((contascliente.indexOf(conta) + 1) + " -> " + conta.getClass().getSimpleName()
						+ " - " + conta.getNib());

			}
			System.out.println("0 -> Sair do Menu");
			System.out.println("Digitar op��o desejada!");

			opcaomenu = opcaousuario.nextInt();
			if(opcaomenu < 0 || (contascliente.size() < opcaomenu)){
				System.out.println("op��o invalida. Digite novamente");
			}else {

				con  = contascliente.get(opcaomenu - 1);
				processaMenuConta();
			}
		}while (opcaomenu != 0);
	}

	public static void main(String[] args) {
		Banco.iniciar();
		Cliente c = Banco.procurarCliente(111);
		cli = c;
		processaMenuContas(c.obterContas());

	}
}
