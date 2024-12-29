package br.com.lucca.literalura.services;

import br.com.lucca.literalura.models.entity.LivroJPA;
import br.com.lucca.literalura.repository.LivroRepository;
import br.com.lucca.literalura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public void listarTodosOsLivros() {
        List<LivroJPA> livros = livroRepository.findAll();
        livros.forEach(l -> System.out.println(l));
    }
}
