import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Banco {

	private String nome;
	private List<Conta> contas;

	public void imprimirContas() {
		System.out.println(String.format("Banco: %s", this.nome));
		System.out.println("-------------------------------");
		System.out.println("Extrato das contas");
		System.out.println("-------------------------------");
		for (Conta conta: contas) {
			conta.imprimirExtrato();
			System.out.println("-------------------------------");
		}
	}
}
