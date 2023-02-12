package tech.ada.aula.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.aula.web.model.dto.EditoraDTO;
import tech.ada.aula.web.service.EditoraService;

@RestController
@RequestMapping("/editora")
public class EditoraController extends BaseController<EditoraDTO, EditoraService> {

    public EditoraController(EditoraService service) {
        super(service);
    }

}
