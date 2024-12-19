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
}
