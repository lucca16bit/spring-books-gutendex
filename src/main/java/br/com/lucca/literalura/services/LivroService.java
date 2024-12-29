package br.com.lucca.literalura.services;

import br.com.lucca.literalura.models.Autor;
import br.com.lucca.literalura.models.GutendexResponse;
import br.com.lucca.literalura.models.entity.AutorJPA;
import br.com.lucca.literalura.models.entity.LivroJPA;
import br.com.lucca.literalura.repository.LivroRepository;
import br.com.lucca.literalura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private GutendexService gutendexService;

    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository, GutendexService gutendexService) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.gutendexService = gutendexService;
    }

    @Transactional
    public LivroJPA salvarLivro(String titulo) throws IOException {
        GutendexResponse response = gutendexService.buscarLivroPorTitulo(titulo);
        if (response.results().isEmpty()) {
            throw new RuntimeException("Livro não encontrado.");
        }

        var livroGutendex = response.results().get(0);

        Optional<LivroJPA> livroExistente = livroRepository.findById(livroGutendex.id());
        if (livroExistente.isPresent()) {
            return livroExistente.get();
        }

        LivroJPA livro = new LivroJPA(livroGutendex);

        for (Autor autor : livroGutendex.autor()) {
            AutorJPA autorJpa = autorRepository.findByNome(autor.nome())
                    .orElseGet(() -> {
                        AutorJPA novoAutor = new AutorJPA(autor);
                        return autorRepository.save(novoAutor);
                    });

            livro.adicionarAutor(autorJpa);
        }

        return livroRepository.save(livro);
    }

    @Transactional(readOnly = true)
    public void listarTodosOsLivros() {
        List<LivroJPA> livros = livroRepository.findAllWithAutores();
        livros.forEach(System.out::println);
    }
}