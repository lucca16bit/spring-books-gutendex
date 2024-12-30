package br.com.lucca.literalura.repository;

import br.com.lucca.literalura.models.entity.AutorJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<AutorJPA, Long>{
    Optional<AutorJPA> findByNome(String nome);

    @Query("select a from AutorJPA a where a.anoNascimento <= :ano and (a.anoFalecimento is null or a.anoFalecimento > :ano)")
    List<AutorJPA> findAutoresVivos(int ano);
}
