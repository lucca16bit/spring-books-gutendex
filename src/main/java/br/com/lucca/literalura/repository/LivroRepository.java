package br.com.lucca.literalura.repository;

import br.com.lucca.literalura.models.Idioma;
import br.com.lucca.literalura.models.entity.LivroJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<LivroJPA, Long> {

    Optional<LivroJPA> findByTitulo(String titulo);

    @Query("SELECT DISTINCT l FROM LivroJPA l LEFT JOIN FETCH l.autores")
    List<LivroJPA> findAllWithAutores();

    List<LivroJPA> findByIdiomaContaining(Idioma idioma);
}
