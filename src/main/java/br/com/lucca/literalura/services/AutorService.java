package br.com.lucca.literalura.services;

import br.com.lucca.literalura.models.entity.AutorJPA;
import br.com.lucca.literalura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<AutorJPA> buscarTodos() {
        return autorRepository.findAll();
    }
}
