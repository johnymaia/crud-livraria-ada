package tech.ada.aula.web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivroDTO {

    private Long id;

    private Long editoraId;

    private Long categoriaId;

    private String nome;

    private String isbn;

}
