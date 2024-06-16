package infnet.spring.boot.tp3.service.impl;

import infnet.spring.boot.tp3.dto.FuncionarioRequestDTO;
import infnet.spring.boot.tp3.entity.Funcionario;
import infnet.spring.boot.tp3.repository.FuncionarioRepository;
import infnet.spring.boot.tp3.service.FuncionarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    @Override
    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario findById(Long id) {
        return funcionarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Funcionario not found"));
    }

    @Override
    public Funcionario save(FuncionarioRequestDTO funcionarioRequestDTO) {
        Funcionario funcionario = new Funcionario();
        BeanUtils.copyProperties(funcionarioRequestDTO, funcionario);
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Funcionario update(Long id, FuncionarioRequestDTO funcionarioRequestDTO) {
        var funcionarioDB = findById(id);
        BeanUtils.copyProperties(funcionarioRequestDTO, funcionarioDB, "id");
        return funcionarioRepository.save(funcionarioDB);
    }

    @Override
    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
