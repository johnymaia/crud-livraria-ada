package tech.ada.aula.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.aula.web.model.entity.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {
}
