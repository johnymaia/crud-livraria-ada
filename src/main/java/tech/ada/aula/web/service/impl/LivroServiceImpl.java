package tech.ada.aula.web.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.aula.web.model.dto.CategoriaDTO;
import tech.ada.aula.web.model.dto.LivroDTO;
import tech.ada.aula.web.model.entity.Categoria;
import tech.ada.aula.web.model.entity.Livro;
import tech.ada.aula.web.model.mapper.CategoriaMapper;
import tech.ada.aula.web.model.mapper.LivroMapper;
import tech.ada.aula.web.repository.CategoriaRepository;
import tech.ada.aula.web.repository.LivroRepository;
import tech.ada.aula.web.service.CategoriaService;
import tech.ada.aula.web.service.LivroService;

import java.util.List;
import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private LivroMapper mapper;

    public List<LivroDTO> buscarTodos() {
        return mapper.parseListDTO(repository.findAll());
    }

    public LivroDTO buscarUm(Long id) {

        Optional<Livro> modelOp = repository.findById(id);
        if (modelOp.isPresent()) {
            Livro model = modelOp.get();
            return mapper.parseDTO(model);
        }

        throw new EntityNotFoundException();
    }

    public LivroDTO criar(LivroDTO dto) {

        Livro model = mapper.parseEntity(dto);
        model.setId(null);
        model = repository.save(model);
        return mapper.parseDTO(model);

    }

    public LivroDTO editar(Long id, LivroDTO dto) {

        if (repository.existsById(id)) {
            Livro model = mapper.parseEntity(dto);
            model.setId(id);
            model = repository.save(model);
            return mapper.parseDTO(model);
        }

        throw new EntityNotFoundException();
    }

    public void excluir(Long id) {

        if (!repository.existsById(id)) {
            throw new EntityNotFoundException();
        }

        repository.deleteById(id);
    }

    @Override
    public List<LivroDTO> buscarPorCategoria(Long id) {

        List<LivroDTO> modelList = mapper.parseListDTO(repository.findByCategoria_id(id));
        if (modelList != null && modelList.size() > 0) {
            return modelList;
        }

        throw new EntityNotFoundException();

    }

    @Override
    public List<LivroDTO> buscarPorEditora(Long id) {

        List<LivroDTO> modelList = mapper.parseListDTO(repository.findByEditora_id(id));
        if (modelList != null && modelList.size() > 0) {
            return modelList;
        }

        throw new EntityNotFoundException();

    }

    @Override
    public List<LivroDTO> buscarPorNomeOuIsbn(String nome, String isbn) {
        List<LivroDTO> modelList = mapper.parseListDTO(repository.buscarPorNomeOuIsbn(nome, isbn));
        if (modelList != null && modelList.size() > 0) {
            return modelList;
        }

        throw new EntityNotFoundException();
    }
}
