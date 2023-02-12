package tech.ada.aula.web.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.aula.web.model.dto.CategoriaDTO;
import tech.ada.aula.web.model.dto.LivroDTO;
import tech.ada.aula.web.service.CategoriaService;
import tech.ada.aula.web.service.LivroService;

import java.util.List;

@RestController
@RequestMapping("/livro")
@Slf4j
public class LivroController extends BaseController<LivroDTO, LivroService> {

    @Autowired
    private LivroService service;

    public LivroController(LivroService service) {
        super(service);
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<LivroDTO>> buscarPorCategoria(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(service.buscarPorCategoria(id));

        } catch (EntityNotFoundException ex) {

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception ex) {

            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/editora/{id}")
    public ResponseEntity<List<LivroDTO>> buscarPorEditora(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(service.buscarPorEditora(id));

        } catch (EntityNotFoundException ex) {

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception ex) {

            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/nome-ou-isbn")
    public ResponseEntity<List<LivroDTO>> buscarPorNomeOuIsbn(@RequestParam(value = "nome", required = false) String nome,
                                                              @RequestParam(value = "isbn", required = false) String isbn) {
        try {
            return ResponseEntity.ok(service.buscarPorNomeOuIsbn(nome, isbn));

        } catch (EntityNotFoundException ex) {

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception ex) {

            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
