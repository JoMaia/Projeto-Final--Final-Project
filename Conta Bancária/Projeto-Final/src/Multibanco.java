import java.util.Scanner;

public class Multibanco extends InteraccaoBanco{
	
	public static void login() {
		Scanner login = new Scanner(System.in);
		System.out.println("Insira seu login");
		int log = login.nextInt();
		System.out.println("Insira a sua password");
		int pass = login.nextInt();
		Cliente cliente = Banco.validarLogin(log, pass);
		if(cliente == null ) {
			System.out.println("Dados de login invalido");
			login();
		}
		if(cliente.isAtivo() == false) {
			System.out.println("Não pode operar sobre um cliente inativo");
			login();
		}else {
			System.out.println("Bem vindo!");
			cli = cliente;
			processaMenuContas(cliente.obterContas());
		}
	}
	public static void main(String[] args) {
		Banco.iniciar();
		login();
	}

}
