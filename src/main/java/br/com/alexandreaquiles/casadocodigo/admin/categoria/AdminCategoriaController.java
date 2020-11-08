package br.com.alexandreaquiles.casadocodigo.admin.categoria;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/admin/categorias")
public class AdminCategoriaController {

    private final CategoriaRepository categoriaRepository;

    public AdminCategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<NovaCategoriaResponse> novaCategoria(@RequestBody @Valid NovaCategoriaRequest novaCategoriaRequest) {
        Categoria categoria = novaCategoriaRequest.toEntity();
        categoriaRepository.save(categoria);
        return ResponseEntity.ok(new NovaCategoriaResponse(categoria));
    }

}