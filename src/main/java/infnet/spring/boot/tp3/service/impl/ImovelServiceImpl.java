package infnet.spring.boot.tp3.service.impl;

import infnet.spring.boot.tp3.dto.ImovelRequestDTO;
import infnet.spring.boot.tp3.entity.Imovel;
import infnet.spring.boot.tp3.exception.ResourceNotFoundException;
import infnet.spring.boot.tp3.repository.ImovelRepository;
import infnet.spring.boot.tp3.service.ImovelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImovelServiceImpl implements ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    @Override
    public List<Imovel> findAll() {
        return imovelRepository.findAll();
    }

    @Override
    public Imovel findById(Long id) {
        return imovelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Imovel not found"));
    }

    @Override
    public Imovel save(ImovelRequestDTO imovelRequestDTO) {
        Imovel imovel = new Imovel();
        BeanUtils.copyProperties(imovelRequestDTO, imovel);
        return imovelRepository.save(imovel);
    }

    @Override
    public Imovel update(Long id, ImovelRequestDTO imovelRequestDTO) {
        var imovelDB = findById(id);
        BeanUtils.copyProperties(imovelRequestDTO, imovelDB, "id");
        return imovelRepository.save(imovelDB);
    }

    @Override
    public void delete(Long id) {
        imovelRepository.deleteById(id);
    }
}
