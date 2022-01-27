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
}
