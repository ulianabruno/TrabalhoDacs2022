package br.univille.dacs2022.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.dacs2022.dto.PlanoSaudeDTO;
import br.univille.dacs2022.entity.PlanoSaude;

@Mapper
public interface PlanoSaudeMapper {
    List<PlanoSaudeDTO> mapListPlanoSaude(List<PlanoSaude> planoSaude);
    List<PlanoSaude> mapListPlanoSaudeDTO(List<PlanoSaudeDTO> planoSaude);
    
    PlanoSaudeDTO mapPlanoSaude(PlanoSaude planoSaude);
    PlanoSaude mapPlanoSaudeDTO(PlanoSaudeDTO planoSaude);
}
