package br.com.lucca.literalura.repository;

import br.com.lucca.literalura.models.entity.LivroJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<LivroJPA, Long> {

    Optional<LivroJPA> findByTitulo(String titulo);

//    List<LivroJPA> findByIdioma(String idioma);


}