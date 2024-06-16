package infnet.spring.boot.tp3.service;

import infnet.spring.boot.tp3.dto.FuncionarioRequestDTO;
import infnet.spring.boot.tp3.entity.Funcionario;

import java.util.List;

public interface FuncionarioService {

    List<Funcionario> findAll();
    Funcionario findById(Long id);
    Funcionario save(FuncionarioRequestDTO funcionarioRequestDTO);
    Funcionario update(Long id, FuncionarioRequestDTO funcionarioRequestDTO);
    void delete(Long id);

}
