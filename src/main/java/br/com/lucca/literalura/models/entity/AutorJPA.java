package br.com.lucca.literalura.models.entity;

import br.com.lucca.literalura.models.Autor;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class AutorJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @Column
    private int anoNascimento;

    @Column
    private Integer anoFalecimento;

    @OneToMany(mappedBy = "autor")
    private List<LivroJPA> livros = new ArrayList<>();

    public AutorJPA() {}

    public AutorJPA(Autor autor) {
        if (autor.nome() == null || autor.nome().isEmpty()) {
            throw new IllegalArgumentException("Nome do autor não pode ser nulo ou vazio.");
        }
        this.nome = autor.nome();
        this.anoNascimento = autor.anoNascimento();
        this.anoFalecimento = autor.anoFalecimento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Integer anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<LivroJPA> getLivros() {
        return livros;
    }

    public void adicionarLivro(LivroJPA livro) {
        this.livros.add(livro);
        livro.setAutor(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: '").append(nome).append("'\n")
                .append("Ano de Nascimento: ").append(anoNascimento).append("\n")
                .append("Ano de Falecimento: ").append(anoFalecimento != null ? anoFalecimento : "Ainda vivo").append("\n");
        return sb.toString();
    }
}