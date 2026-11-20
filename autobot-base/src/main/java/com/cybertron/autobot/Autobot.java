package com.cybertron.autobot;

/**
 * Representa um Autobot cadastrado na base.
 */
public class Autobot {

    /** Erro #4 — Encapsulamento: os atributos agora são privados para impedir
     alterações diretas e não controladas por outras classes. */

    private String nome;
    private double energon;
    private int nivel;

    public Autobot(String nome, double energon, int nivel) {
        this.nome = nome;
        this.energon = energon;
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public double getEnergon() {
        return energon;
    }

    public int getNivel() {
        return nivel;
    }

    public void adicionarEnergon(double quantidade) {
        this.energon += quantidade;
    }
}
