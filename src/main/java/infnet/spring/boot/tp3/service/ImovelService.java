package infnet.spring.boot.tp3.service;

import infnet.spring.boot.tp3.dto.ImovelRequestDTO;
import infnet.spring.boot.tp3.entity.Imovel;

import java.util.List;

public interface ImovelService {

    List<Imovel> findAll();
    Imovel findById(Long id);
    Imovel save(ImovelRequestDTO imovelRequestDTO);
    Imovel update(Long id, ImovelRequestDTO imovelRequestDTO);
    void delete(Long id);

}
