package tech.ada.aula.web.model.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.ada.aula.web.model.dto.LivroDTO;
import tech.ada.aula.web.model.entity.Livro;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LivroMapper {

    List<LivroDTO> parseListDTO(List<Livro> livros);

    List<Livro> parseListEntity(List<LivroDTO> livros);

    @Mapping(source = "categoria.id", target = "categoriaId")
    @Mapping(source = "editora.id", target = "editoraId")
    LivroDTO parseDTO(Livro livro);

    @Mapping(source = "categoriaId", target = "categoria.id")
    @Mapping(source = "editoraId", target = "editora.id")
    Livro parseEntity(LivroDTO livro);

}
