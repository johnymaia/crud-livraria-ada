package tech.ada.aula.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.aula.web.model.dto.CategoriaDTO;
import tech.ada.aula.web.model.dto.EditoraDTO;
import tech.ada.aula.web.service.CategoriaService;
import tech.ada.aula.web.service.EditoraService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController extends BaseController<CategoriaDTO, CategoriaService> {

    public CategoriaController(CategoriaService service) {
        super(service);
    }

}
