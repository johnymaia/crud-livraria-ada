package tech.ada.aula.web.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.aula.web.model.dto.CategoriaDTO;
import tech.ada.aula.web.model.dto.EditoraDTO;
import tech.ada.aula.web.model.entity.Categoria;
import tech.ada.aula.web.model.entity.Editora;
import tech.ada.aula.web.model.mapper.CategoriaMapper;
import tech.ada.aula.web.model.mapper.EditoraMapper;
import tech.ada.aula.web.repository.CategoriaRepository;
import tech.ada.aula.web.repository.EditoraRepository;
import tech.ada.aula.web.service.CategoriaService;
import tech.ada.aula.web.service.EditoraService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private CategoriaMapper mapper;

    public List<CategoriaDTO> buscarTodos() {
        return mapper.parseListDTO(repository.findAll());
    }

    public CategoriaDTO buscarUm(Long id) {

        Optional<Categoria> modelOp = repository.findById(id);
        if (modelOp.isPresent()) {
            Categoria model = modelOp.get();
            return mapper.parseDTO(model);
        }

        throw new EntityNotFoundException();
    }

    public CategoriaDTO criar(CategoriaDTO dto) {

        Categoria model = mapper.parseEntity(dto);
        model.setId(null);
        model = repository.save(model);
        return mapper.parseDTO(model);

    }

    public CategoriaDTO editar(Long id, CategoriaDTO dto) {

        if (repository.existsById(id)) {
            Categoria model = mapper.parseEntity(dto);
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
}
