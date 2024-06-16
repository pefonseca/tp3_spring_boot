package infnet.spring.boot.tp3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorRequestDTO {

    private Long id;
    private String nome;
    private String numeroDocumento;
    private String endereco;
    private String cidade;
    private String estado;
    private String cep;
    private String telefone;

}
