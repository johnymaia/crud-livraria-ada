package tech.ada.aula.web.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDTO(
		Integer id,
		@NotBlank(message="O campo nome deve estar preenchido") String nome,
		@NotNull(message="O campo preco deve estar preenchido") Double preco,
		@NotNull(message="O campo quantidade estoque deve estar preenchido") Integer quantidadeEstoque,
		String descricao) {

}
