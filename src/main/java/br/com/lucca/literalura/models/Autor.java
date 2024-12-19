package br.com.lucca.literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Autor(@JsonAlias("name") String nome,
                    @JsonAlias("birth_year") int anoNascimento,
                    @JsonAlias("death_year") int anoFalecimento) {
}
