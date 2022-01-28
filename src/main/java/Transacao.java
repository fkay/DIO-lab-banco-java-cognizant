import lombok.Getter;

@Getter
public class Transacao {
    private IConta contaDe;
    private IConta contaPara;
    private TipoTransacao tipo;
    private double valor;

    public Transacao(IConta de, IConta para, TipoTransacao tipoTransacao, double valor) {
        this.contaDe = de;
        this.contaPara = para;
        this.tipo = tipoTransacao;
        this.valor = valor;
    }

    public void imprimirTransacao() {
        System.out.println(String.format("Tipo operação: %s", tipo.toString()));
        if(contaDe != null) {
            System.out.print("Origem: ");
            contaDe.imprimirDadosResumido();
        }
        if(contaPara !=null) {
            System.out.print("Destino: ");
            contaPara.imprimirDadosResumido();
        }
        System.out.println(String.format("valor: %.2f", valor));
    }
}
