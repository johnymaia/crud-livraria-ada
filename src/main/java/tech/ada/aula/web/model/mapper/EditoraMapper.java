package tech.ada.aula.web.model.mapper;

import org.mapstruct.Mapper;
import tech.ada.aula.web.model.dto.EditoraDTO;
import tech.ada.aula.web.model.entity.Editora;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EditoraMapper {

    List<EditoraDTO> parseListDTO(List<Editora> editoras);

    List<Editora> parseListEntity(List<EditoraDTO> editoras);

    EditoraDTO parseDTO(Editora editora);

    Editora parseEntity(EditoraDTO editora);

}
