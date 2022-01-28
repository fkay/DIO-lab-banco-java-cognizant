import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	@Getter
	protected int agencia;
	@Getter
	protected int numero;
	@Getter
	protected double saldo;
	protected Cliente cliente;

	private List<Transacao> transacoes;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.transacoes = new ArrayList<>();
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
		transacoes.add(new Transacao(this, null, TipoTransacao.SACAR, valor));
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		transacoes.add(new Transacao(null, this, TipoTransacao.DEPOSITAR, valor));
	}

	private void sacarTransf(double valor) {
		saldo -= valor;
	}

	private void depositarTransf(double valor, IConta contaOrigem) {
		saldo += valor;
		transacoes.add(new Transacao(contaOrigem, this, TipoTransacao.TRANSFERIR, valor));
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacarTransf(valor);
		((Conta)contaDestino).depositarTransf(valor, this);
		transacoes.add(new Transacao(this, contaDestino, TipoTransacao.TRANSFERIR, valor));
	}

	@Override
	public void imprimirDadosResumido() {
		System.out.println(String.format("Ag: %d conta: %d", this.agencia, this.numero, this.cliente.getNome()));
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

	protected void imprimirTransacoes() {
		System.out.println("**** Transações ****");
		for(Transacao trans : transacoes) {
			trans.imprimirTransacao();
		}
	}
}
