package infnet.spring.boot.tp3.service.impl;

import infnet.spring.boot.tp3.dto.ProdutoRequestDTO;
import infnet.spring.boot.tp3.entity.Produto;
import infnet.spring.boot.tp3.exception.ResourceNotFoundException;
import infnet.spring.boot.tp3.repository.ProdutoRepository;
import infnet.spring.boot.tp3.service.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto not found."));
    }

    @Override
    public Produto save(ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoRequestDTO, produto);
        return produtoRepository.save(produto);
    }

    @Override
    public Produto update(Long id, ProdutoRequestDTO produtoRequestDTO) {
        var produtoDB = findById(id);
        BeanUtils.copyProperties(produtoRequestDTO, produtoDB, "id");
        return produtoRepository.save(produtoDB);
    }

    @Override
    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
