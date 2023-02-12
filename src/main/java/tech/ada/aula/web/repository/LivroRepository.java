package tech.ada.aula.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.aula.web.model.entity.Livro;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>, LivroRepositoryCustom {

    List<Livro> findByCategoria_id(Long id);

    List<Livro> findByEditora_id(Long id);

}
