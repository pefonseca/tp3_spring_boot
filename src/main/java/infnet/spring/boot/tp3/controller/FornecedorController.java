package infnet.spring.boot.tp3.controller;

import infnet.spring.boot.tp3.dto.FornecedorRequestDTO;
import infnet.spring.boot.tp3.entity.Fornecedor;
import infnet.spring.boot.tp3.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<Fornecedor>> findAll() {
        List<Fornecedor> fornecedors = fornecedorService.findAll();
        return ResponseEntity.ok(fornecedors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable Long id) {
        Fornecedor fornecedor = fornecedorService.findById(id);
        return ResponseEntity.ok(fornecedor);
    }

    @PostMapping
    public ResponseEntity<Fornecedor> save(@RequestBody FornecedorRequestDTO fornecedorRequestDTO) {
        Fornecedor fornecedorSaved = fornecedorService.save(fornecedorRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> update(@PathVariable Long id, @RequestBody FornecedorRequestDTO fornecedorRequestDTO) {
        Fornecedor fornecedorUpdated = fornecedorService.update(id, fornecedorRequestDTO);
        return ResponseEntity.ok(fornecedorUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        fornecedorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
