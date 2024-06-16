package infnet.spring.boot.tp3.controller;

import infnet.spring.boot.tp3.dto.FuncionarioRequestDTO;
import infnet.spring.boot.tp3.entity.Funcionario;
import infnet.spring.boot.tp3.service.FuncionarioService;
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
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll() {
        List<Funcionario> funcionarios = funcionarioService.findAll();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable Long id) {
        Funcionario funcionario = funcionarioService.findById(id);
        return ResponseEntity.ok(funcionario);
    }

    @PostMapping
    public ResponseEntity<Funcionario> save(@RequestBody FuncionarioRequestDTO funcionarioRequestDTO) {
        Funcionario fornecedorSaved = funcionarioService.save(funcionarioRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable Long id, @RequestBody FuncionarioRequestDTO funcionarioRequestDTO) {
        Funcionario funcionarioSaved = funcionarioService.update(id, funcionarioRequestDTO);
        return ResponseEntity.ok(funcionarioSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        funcionarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
