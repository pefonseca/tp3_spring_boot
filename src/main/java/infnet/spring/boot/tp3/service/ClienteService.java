package infnet.spring.boot.tp3.service;

import infnet.spring.boot.tp3.dto.ClienteRequestDTO;
import infnet.spring.boot.tp3.entity.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> findAll();
    Cliente findById(Long id);
    Cliente save(ClienteRequestDTO clienteRequestDTO);
    Cliente update(Long id, ClienteRequestDTO clienteRequestDTO);
    void delete(Long id);

}
