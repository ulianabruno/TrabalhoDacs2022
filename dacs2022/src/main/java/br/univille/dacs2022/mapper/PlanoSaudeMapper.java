package br.univille.dacs2022.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.dacs2022.dto.PlanoSaudeDTO;
import br.univille.coredacs2022.entity.PlanoDeSaude;

@Mapper
public interface PlanoSaudeMapper {
    List<PlanoSaudeDTO> mapListPlanoSaude(List<PlanoDeSaude> planoSaude);

    List<PlanoDeSaude> mapListPlanoSaudeDTO(List<PlanoSaudeDTO> planoSaude);

    PlanoSaudeDTO mapPlanoSaude(PlanoDeSaude planoSaude);

    PlanoDeSaude mapPlanoSaudeDTO(PlanoSaudeDTO planoSaude);
}
