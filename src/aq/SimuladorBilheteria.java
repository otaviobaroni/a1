package aq;

public class SimuladorBilheteria {
    public static void main(String[] args) {
        // Cria um evento compartilhado entre as bilheterias
        Evento evento = new Evento();
        
        // Cria duas threads representando duas bilheterias
        Thread bilheteria1 = new Thread(() -> processarVendas(evento, 1));
        Thread bilheteria2 = new Thread(() -> processarVendas(evento, 2));
        
        // Inicia as threads
        bilheteria1.start();
        bilheteria2.start();
        
        // Aguarda as threads terminarem
        try {
            bilheteria1.join();
            bilheteria2.join();
        } catch (InterruptedException e) {
            System.err.println("Thread interrompida: " + e.getMessage());
        }
        
        System.out.println("Vendas concluídas. Ingressos restantes: " + evento.ingressosDisponiveis());
    }
    
    private static void processarVendas(Evento evento, int numBilheteria) {
        for (int i = 0; i < 50; i++) {
            try {
                // Tenta obter um ingresso
                Ingresso ingresso = evento.venderIngresso();
                
                if (ingresso != null) {
                    // Vende o ingresso
                    ingresso.vender();
                    
                    // Imprime a venda
                    System.out.println("Bilheteria " + numBilheteria + " vendeu: " + ingresso);
                } else {
                    System.out.println("Bilheteria " + numBilheteria + ": Não há mais ingressos disponíveis");
                    break;
                }
                
                // Pequena pausa para simular o tempo de processamento
                Thread.sleep(10);
            } catch (IngressoJaVendidoException e) {
                System.err.println("Erro na bilheteria " + numBilheteria + ": " + e.getMessage());
            } catch (InterruptedException e) {
                System.err.println("Bilheteria " + numBilheteria + " interrompida: " + e.getMessage());
                Thread.currentThread().interrupt(); // Restaura o status de interrupção
                break;
            }
        }
    }
}