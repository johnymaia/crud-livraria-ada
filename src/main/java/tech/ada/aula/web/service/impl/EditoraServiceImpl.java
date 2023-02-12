package tech.ada.aula.web.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.aula.web.model.dto.EditoraDTO;
import tech.ada.aula.web.model.entity.Editora;
import tech.ada.aula.web.model.mapper.EditoraMapper;
import tech.ada.aula.web.repository.EditoraRepository;
import tech.ada.aula.web.service.EditoraService;

import java.util.List;
import java.util.Optional;

@Service
public class EditoraServiceImpl implements EditoraService {

    @Autowired
    private EditoraRepository repository;

    @Autowired
    private EditoraMapper mapper;

    public List<EditoraDTO> buscarTodos() {
        return mapper.parseListDTO(repository.findAll());
    }

    public EditoraDTO buscarUm(Long id) {

        Optional<Editora> modelOp = repository.findById(id);
        if (modelOp.isPresent()) {
            Editora model = modelOp.get();
            return mapper.parseDTO(model);
        }

        throw new EntityNotFoundException();
    }

    public EditoraDTO criar(EditoraDTO dto) {

        Editora model = mapper.parseEntity(dto);
        model.setId(null);
        model = repository.save(model);
        return mapper.parseDTO(model);

    }

    public EditoraDTO editar(Long id, EditoraDTO dto) {

        if (repository.existsById(id)) {
            Editora model = mapper.parseEntity(dto);
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
