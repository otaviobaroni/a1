package aq;

public class Ingresso {
    // Enum deve ser declarado (assumindo que está em outro arquivo ou aqui dentro)
    public enum StatusIngresso {
        DISPONIVEL,
        VENDIDO
    }

    private StatusIngresso status;
    private final int id;
    private final double valor;

    public Ingresso(int id, double valor) throws IngressoInvalidoException {
        if (id <= 0 || valor < 0) {
            throw new IngressoInvalidoException("ID e valor não podem ser negativos");
        }
        this.id = id;
        this.valor = valor;
        this.status = StatusIngresso.DISPONIVEL;  // Corrigido o nome da constante
    }

    // Getters
    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    // Corrigido o tipo de retorno do getStatus
    public StatusIngresso getStatus() {
        return status;
    }

    // Método para vender o ingresso
    public void vender() throws IngressoJaVendidoException {
        if (this.status == StatusIngresso.VENDIDO) {  // Corrigida a referência
            throw new IngressoJaVendidoException("Ingresso já vendido: " + this.id);
        }
        this.status = StatusIngresso.VENDIDO;  // Corrigida a referência
    }

    @Override
    public String toString() {
        return "[ID=" + id + ", Valor=" + valor + ", Status=" + status + "]";
    }
}