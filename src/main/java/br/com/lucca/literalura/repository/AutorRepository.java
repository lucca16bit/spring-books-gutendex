package br.com.lucca.literalura.repository;

import br.com.lucca.literalura.models.entity.AutorJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<AutorJPA, Long>{
    Optional<AutorJPA> findByNome(String nome);
}
