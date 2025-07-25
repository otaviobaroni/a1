package aq;

import java.util.LinkedList;
import java.util.Queue;

public class Evento {
    private final Queue<Ingresso> ingressos;

    public Evento() {
        this.ingressos = new LinkedList<>();
        // Popula a fila com 100 ingressos
        for (int i = 1; i <= 100; i++) {
            try {
                ingressos.add(new Ingresso(i, 50.0));
            } catch (IngressoInvalidoException e) {
                // Isso não deve acontecer pois estamos usando valores válidos
                System.err.println("Erro ao criar ingresso: " + e.getMessage());
            }
        }
    }

    // Método thread-safe para vender ingresso
    public synchronized Ingresso venderIngresso() {
        return ingressos.poll(); // Retorna e remove o próximo ingresso ou null se vazia
    }

    public int ingressosDisponiveis() {
        return ingressos.size();
    }
}