package br.com.lucca.literalura.models;

import java.util.List;

public record GutendexResponse(int count,
                               String next,
                               String previous,
                               List<Livro> results) {
}
