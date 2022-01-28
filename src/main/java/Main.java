import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente("Maria");
		cliente1.setNome("José");
		
		Conta cc1 = new ContaCorrente(cliente1);
		Conta poupanca1 = new ContaPoupanca(cliente1);

		Conta cc2 = new ContaCorrente(cliente2);

		cc1.depositar(100);
		cc1.transferir(50, poupanca1);

		cc1.transferir(25, cc2);
		
		//cc1.imprimirExtrato();
		//poupanca1.imprimirExtrato();
		//cc2.imprimirExtrato();

		Banco banco = new Banco();
		banco.setNome("Banco de teste");
		banco.setContas(new ArrayList<>());
		banco.getContas().add(cc1);
		banco.getContas().add(cc2);
		banco.getContas().add(poupanca1);
		System.out.println("Lista de bancos");
		banco.imprimirContas();


		System.out.println("Extrato de transações da cc1");
		cc1.imprimirTransacoes();

		System.out.println("Extrato de transações da poupanca1");
		poupanca1.imprimirTransacoes();
	}

}
