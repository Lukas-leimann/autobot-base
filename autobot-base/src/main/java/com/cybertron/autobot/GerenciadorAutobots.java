package com.cybertron.autobot;

import java.util.ArrayList;
import java.util.List;

/**
 * Gerencia os Autobots da base.
 */
public class GerenciadorAutobots {

    /** Erro #6 — Nomenclatura: nomes descritivos agora deixam clara a finalidade
     * da coleção e facilitam a leitura do código.*/

    private final List<Autobot> autobots = new ArrayList<>();

    /** Erro #5 — Constantes: substituem valores numéricos sem explicação
     * por identificadores que revelam o significado de cada limite. */

    private static final double LIMITE_ENERGON_ELITE = 500.0;
    private static final double LIMITE_ENERGON_PADRAO = 200.0;
    private static final double QUANTIDADE_ENERGON_REPARO = 100.0;

    public void adicionar(Autobot autobot) {
        autobots.add(autobot);
    }

    public double calcularEnergonTotal() {
        double total = 0;

        /** Erro #1 — Limite do laço: Agora '<' garante que o índice nunca
         * ultrapasse a última posição válida da lista. */

        for (int indice = 0; indice < autobots.size(); indice++) {
            total += autobots.get(indice).getEnergon();
        }

        return total;
    }

    public Autobot buscar(String nome) {
        for (Autobot autobot : autobots) {

            /** Erro #2 — Comparação de Strings: Agora equals() compara o
             * conteúdo do texto, ao contrário do operador '=='. */

            if (autobot.getNome().equals(nome)) {
                return autobot;
            }
        }

        return null;
    }

    public void reparar(Autobot autobot) {
        try {
            if (autobot.getEnergon() < 0) {
                throw new Exception("Energon negativo");
            }

            autobot.adicionarEnergon(QUANTIDADE_ENERGON_REPARO);

        /** Erro #3 — Tratamento de exceções: Agora a falha não é ignorada,
         * ela é propagada com contexto para quem chamou o método. */

        } catch (Exception excecao) {
            throw new IllegalStateException(
                    "Não foi possível reparar o Autobot.", excecao
            );
        }
    }

    public String classificar(Autobot autobot) {
        if (autobot.getEnergon() > LIMITE_ENERGON_ELITE) {
            return "ELITE";
        } else if (autobot.getEnergon() > LIMITE_ENERGON_PADRAO) {
            return "PADRAO";
        } else {
            return "RESERVA";
        }
    }
}
