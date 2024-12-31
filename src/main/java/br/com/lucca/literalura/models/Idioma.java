package br.com.lucca.literalura.models;

import java.util.Arrays;

public enum Idioma {
    INGLES("en", "ingles"),
    CHINES("zh", "chines"),
    PORTUGUES("pt", "portugues"),
    ESPANHOL("es", "espanhol"),
    FRANCES("fr", "frances");


    private final String codigo;
    private final String nome;

    Idioma(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public static Idioma buscarPorNome(String nome) {
        return Arrays.stream(values())
                .filter(i -> i.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Idioma não encontrado: " + nome));
    }
}
