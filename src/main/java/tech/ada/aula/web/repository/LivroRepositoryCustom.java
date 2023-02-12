package tech.ada.aula.web.repository;

import tech.ada.aula.web.model.entity.Livro;

import java.util.List;

public interface LivroRepositoryCustom {

    List<Livro> buscarPorNomeOuIsbn(String nome, String isbn);
}
