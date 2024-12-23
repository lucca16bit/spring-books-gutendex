package br.com.lucca.literalura.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class AutorJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int anoNascimento;
    private int anoFalecimento;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LivroJPA> livros = new ArrayList<>();

    public AutorJPA() {}

    public AutorJPA(Autor autor) {
        this.nome = autor.nome();
        this.anoNascimento = autor.anoNascimento();
        this.anoFalecimento = autor.anoFalecimento();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public int getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(int anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<LivroJPA> getLivros() {
        return livros;
    }

    public void setLivros(List<LivroJPA> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "Autor: {" +
                "nome: '" + nome + '\'' +
                ", ano de nascimento: " + anoNascimento +
                ", ano de falecimento: " + anoFalecimento +
                ", livros: " + livros +
                '}';
    }
}
