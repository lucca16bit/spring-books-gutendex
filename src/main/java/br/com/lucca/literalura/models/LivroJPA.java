package br.com.lucca.literalura.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "livros")
public class LivroJPA {
    @Id
    private Long id;
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private AutorJPA autor;
    private List<String> idioma;
    private int numeroDownloads;

    public LivroJPA() {}

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
        return "Livro: {" +
                "id: " + id +
                ", titulo: '" + titulo + '\'' +
                ", autor: " + autor +
                ", idioma: " + idioma +
                ", número de downloads: " + numeroDownloads +
                '}';
    }
}
