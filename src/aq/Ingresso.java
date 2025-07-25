package aq;

// Enum para representar o status do ingresso
public enum Ingresso {
    DISPONIVEL, VENDIDO
}

// Exceção para ingressos inválidos
public class IngressoInvalidoException extends Exception {
    public IngressoInvalidoException(String message) {
        super(message);
    }
}

// Exceção para quando um ingresso já foi vendido
public class IngressoJaVendidoException extends Exception {
    public IngressoJaVendidoException(String message) {
        super(message);
    }
}

// Classe Ingresso
public class Ingresso {
    private final int id;
    private final double valor;
    private Ingresso status;

    public Ingresso(int id, double valor) throws IngressoInvalidoException {
        if (id <= 0 || valor < 0) {
            throw new IngressoInvalidoException("ID e valor não podem ser negativos");
        }
        this.id = id;
        this.valor = valor;
        this.status = Ingresso.DISPONIVEL;
    }

    // Getters
    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public Ingresso getStatus() {
        return status;
    }

    // Método para vender o ingresso
    public void vender() throws IngressoJaVendidoException {
        if (this.status == Ingresso.VENDIDO) {
            throw new IngressoJaVendidoException("Ingresso já vendido: " + this.id);
        }
        this.status = Ingresso.VENDIDO;
    }

    @Override
    public String toString() {
        return "[ID=" + id + ", Valor=" + valor + ", Status=" + status + "]";
    }
}