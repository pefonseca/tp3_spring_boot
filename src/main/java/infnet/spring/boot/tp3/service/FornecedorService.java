package infnet.spring.boot.tp3.service;

import infnet.spring.boot.tp3.dto.FornecedorRequestDTO;
import infnet.spring.boot.tp3.entity.Fornecedor;

import java.util.List;

public interface FornecedorService {

    List<Fornecedor> findAll();
    Fornecedor findById(Long id);
    Fornecedor save(FornecedorRequestDTO fornecedorRequestDTO);
    Fornecedor update(Long id, FornecedorRequestDTO fornecedorRequestDTO);
    void delete(Long id);

}
