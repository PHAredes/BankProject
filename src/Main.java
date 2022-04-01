import java.util.Scanner;
public class Main {

	public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    System.out.println("Criar conta: digite os dados");
    
    System.out.print("Nome: ");
    String nome = scan.next();
    scan.nextLine();
    
    System.out.print("Senha: ");
    String senha = scan.next();
    scan.nextLine();

    Cliente cliente = new Cliente(nome, senha);
    Conta cc = new ContaCorrente(cliente);
		Conta poupanca = new ContaPoupanca(cliente);

    System.out.println("Depósito inicial");
    double valor = scan.nextDouble();
		cc.depositar(valor);

    System.out.println("Quanto guardar na poupança");
    valor = scan.nextDouble();
    
    boolean i = false;
    do{ 
      System.out.println("Digite a senha");
      senha = scan.next();
      if (cliente.getSenha().equals(senha)) {
        cc.transferir(valor, poupanca);
        i = true;
    } else {
        System.out.println("Senha incorreta");
    }
    } while (i == false);
    
    cc.imprimirExtrato();
		poupanca.imprimirExtrato();

    scan.close();
	}
}
