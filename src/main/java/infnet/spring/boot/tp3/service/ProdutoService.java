package infnet.spring.boot.tp3.service;

import infnet.spring.boot.tp3.dto.ProdutoRequestDTO;
import infnet.spring.boot.tp3.entity.Produto;

import java.util.List;

public interface ProdutoService {

    List<Produto> findAll();
    Produto findById(Long id);
    Produto save(ProdutoRequestDTO produtoRequestDTO);
    Produto update(Long id, ProdutoRequestDTO produtoRequestDTO);
    void delete(Long id);

}
