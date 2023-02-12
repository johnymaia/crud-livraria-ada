package tech.ada.aula.web.service;

import tech.ada.aula.web.model.dto.CategoriaDTO;
import tech.ada.aula.web.model.dto.LivroDTO;

import java.util.List;

public interface LivroService extends BaseService<LivroDTO> {

    List<LivroDTO> buscarPorCategoria(Long id);

    List<LivroDTO> buscarPorEditora(Long id);

    List<LivroDTO> buscarPorNomeOuIsbn(String nome, String isbn);

}
