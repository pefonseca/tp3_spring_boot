package infnet.spring.boot.tp3.controller;

import infnet.spring.boot.tp3.dto.ImovelRequestDTO;
import infnet.spring.boot.tp3.entity.Imovel;
import infnet.spring.boot.tp3.service.ImovelService;
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
@RequestMapping("/imovel")
public class ImovelController {

    @Autowired
    private ImovelService imovelService;

    @GetMapping
    public ResponseEntity<List<Imovel>> findAll() {
        List<Imovel> imoveis = imovelService.findAll();
        return ResponseEntity.ok(imoveis);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imovel> findById(@PathVariable Long id) {
        Imovel imovel = imovelService.findById(id);
        return ResponseEntity.ok(imovel);
    }

    @PostMapping
    public ResponseEntity<Imovel> save(@RequestBody ImovelRequestDTO imovelRequestDTO) {
        Imovel imovelSaved = imovelService.save(imovelRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(imovelSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imovel> update(@PathVariable Long id, @RequestBody ImovelRequestDTO imovelRequestDTO) {
        Imovel imovelSaved = imovelService.update(id, imovelRequestDTO);
        return ResponseEntity.ok(imovelSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        imovelService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
