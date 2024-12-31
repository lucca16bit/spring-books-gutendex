package br.com.lucca.literalura.models.entity;

import br.com.lucca.literalura.models.Idioma;
import br.com.lucca.literalura.models.Livro;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "livros")
public class LivroJPA {
    @Id
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "livro_autor",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<AutorJPA> autores = new ArrayList<>();;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Idioma> idioma;

    @Column
    private int numeroDownloads;

    public LivroJPA() {
        this.idioma = new ArrayList<>();
    }

    public LivroJPA(Livro livro) {
        this.id = livro.id();
        this.titulo = livro.titulo();
        this.autores = new ArrayList<>();
        this.idioma = livro.idioma().stream()
                .map(codigo -> Arrays.stream(Idioma.values())
                        .filter(i -> i.getCodigo().equals(codigo))
                        .findFirst()
                        .orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        this.numeroDownloads = livro.numeroDownloads();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<AutorJPA> getAutores() {
        return autores;
    }

    public void setAutores(List<AutorJPA> autores) {
        this.autores = autores;
    }

    public List<Idioma> getIdioma() {
        return idioma;
    }

    public void setIdioma(List<Idioma> idioma) {
        this.idioma = idioma;
    }

    public int getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(int numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    public void adicionarAutor(AutorJPA autor) {
        this.autores.add(autor);
        autor.getLivros().add(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=======================   LIVRO   =======================\n")
                .append("Id: ").append(id).append("\n")
                .append("Título: '").append(titulo).append("'\n")
                .append("Autor: ");
        if (autores != null && !autores.isEmpty()) {
            sb.append(autores.stream()
                    .map(AutorJPA::getNome)
                    .collect(Collectors.joining(", ")));
        } else {
            sb.append("Desconhecido");
        }
        sb.append("\n")
                .append("Idioma: ").append(idioma).append("\n")
                .append("Número de Downloads: ").append(numeroDownloads).append("\n")
                .append("=========================================================\n");
        return sb.toString();
    }
}
