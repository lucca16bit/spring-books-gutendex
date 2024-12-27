package br.com.lucca.literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Livro(@JsonAlias("id") Long id,
                    @JsonAlias("title") String titulo,
                    @JsonAlias("authors") List<Autor> autor,
                    @JsonAlias("languages") List<String> idioma,
                    @JsonAlias("download_count") int numeroDownloads) {

    @Override
    public String toString() {
        return "=======================   LIVRO   =======================\n" +
                "Id: " + id + "\n" +
                "Título: " + titulo + "\n" +
                "Autor: " + autor + "\n" +
                "Idioma: " + idioma + "\n" +
                "Número de Downloads:" + numeroDownloads + "\n" +
                "=========================================================\n";
    }
}
