package infnet.spring.boot.tp3.service.impl;

import infnet.spring.boot.tp3.dto.ClienteRequestDTO;
import infnet.spring.boot.tp3.entity.Cliente;
import infnet.spring.boot.tp3.exception.ResourceNotFoundException;
import infnet.spring.boot.tp3.repository.ClienteRepository;
import infnet.spring.boot.tp3.service.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID: " + id));
    }

    @Override
    public Cliente save(ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteRequestDTO, cliente);
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Long id, ClienteRequestDTO clienteRequestDTO) {
        Cliente clienteDB = findById(id);
        BeanUtils.copyProperties(clienteRequestDTO, clienteDB, "id");
        return clienteRepository.save(clienteDB);
    }

    @Override
    public void delete(Long id) {
        var client = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID: " + id));
        clienteRepository.delete(client);
    }
}
