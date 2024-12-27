package br.com.lucca.literalura.models.entity;

import br.com.lucca.literalura.models.Livro;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livros")
public class LivroJPA {
    @Id
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor")
    private AutorJPA autor;

    @Column
    private List<String> idioma;

    @Column
    private int numeroDownloads;

    public LivroJPA() {
        this.idioma = new ArrayList<>();
    }
    public LivroJPA(Livro livro) {
        this.id = livro.id();
        this.titulo = livro.titulo();
        this.idioma = livro.idioma();
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

    public AutorJPA getAutor() {
        return autor;
    }

    public void setAutor(AutorJPA autor) {
        this.autor = autor;
    }

    public List<String> getIdioma() {
        return idioma;
    }

    public void setIdioma(List<String> idioma) {
        this.idioma = idioma;
    }

    public int getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(int numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=======================   LIVRO   =======================\n")
                .append("Id: ").append(id).append("\n")
                .append("Título: '").append(titulo).append("'\n")
                .append("Autor: ").append(autor != null ? autor.getNome() :  "Desconhecido").append("\n")
                .append("Idioma: ").append(idioma).append("\n")
                .append("Número de Downloads: ").append(numeroDownloads).append("\n");
        return sb.toString();
    }
}
