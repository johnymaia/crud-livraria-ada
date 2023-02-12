package tech.ada.aula.web.model.mapper;

import org.mapstruct.Mapper;
import tech.ada.aula.web.model.dto.CategoriaDTO;
import tech.ada.aula.web.model.entity.Categoria;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    List<CategoriaDTO> parseListDTO(List<Categoria> categorias);

    List<Categoria> parseListEntity(List<CategoriaDTO> categorias);

    CategoriaDTO parseDTO(Categoria categoria);

    Categoria parseEntity(CategoriaDTO categoria);

}
