package infnet.spring.boot.tp3.service.impl;

import infnet.spring.boot.tp3.dto.FornecedorRequestDTO;
import infnet.spring.boot.tp3.entity.Fornecedor;
import infnet.spring.boot.tp3.repository.FornecedorRepository;
import infnet.spring.boot.tp3.service.FornecedorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Override
    public List<Fornecedor> findAll() {
        return fornecedorRepository.findAll();
    }

    @Override
    public Fornecedor findById(Long id) {
        return fornecedorRepository.findById(id).orElseThrow(() -> new RuntimeException("Fornecedor not found"));
    }

    @Override
    public Fornecedor save(FornecedorRequestDTO fornecedorRequestDTO) {
        Fornecedor fornecedor = new Fornecedor();
        BeanUtils.copyProperties(fornecedorRequestDTO, fornecedor);
        return fornecedorRepository.save(fornecedor);
    }

    @Override
    public Fornecedor update(Long id, FornecedorRequestDTO fornecedorRequestDTO) {
        var fornecedorId = findById(id);
        BeanUtils.copyProperties(fornecedorRequestDTO, fornecedorId, "id");
        return fornecedorRepository.save(fornecedorId);
    }

    @Override
    public void delete(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
