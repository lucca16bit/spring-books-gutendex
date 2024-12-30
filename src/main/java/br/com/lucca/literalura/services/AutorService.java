package br.com.lucca.literalura.services;

import br.com.lucca.literalura.models.entity.AutorJPA;
import br.com.lucca.literalura.repository.AutorRepository;
import br.com.lucca.literalura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private GutendexService gutendexService;

    public AutorService(LivroRepository livroRepository, AutorRepository autorRepository, GutendexService gutendexService) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.gutendexService = gutendexService;
    }

    public void listarTodosOsAutores()  {
        List<AutorJPA> autores = autorRepository.findAll();
        autores.forEach(System.out::println);
    }

    public void listarAutoresVivos(int ano) {
        List<AutorJPA> autoresVivos = autorRepository.findAutoresVivos(ano);

        if (!autoresVivos.isEmpty()) {
            System.out.println("Autores vivos a partir do ano (" + ano + "): \n");
            autoresVivos.forEach(System.out::println);
        } else {
            System.out.println("Autores não encontrado a partir deste ano!");
        }
    }
}
