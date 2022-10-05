package br.univille.dacs2022.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.dacs2022.dto.ProcedimentoDTO;
import br.univille.coredacs2022.entity.Procedimento;

@Mapper
public interface ProcedimentoMapper {
    List<ProcedimentoDTO> mapListProcedimento(List<Procedimento> procedimento);
    List<Procedimento> mapListProcedimentoDTO(List<ProcedimentoDTO> procedimento);
    
    ProcedimentoDTO mapProcedimento(Procedimento procedimento);
    Procedimento mapProcedimentoDTO(ProcedimentoDTO procedimento);


    // public List<ProcedimentoDTO> mapListProcedimento(List<Procedimento> findAll) {
    //     return null;
    // }
    // // List<ProcedimentoDTO> mapListProcedimento(List<Procedimento> procedimento);
    // // List<Procedimento> mapListProcedimentoDTO(List<ProcedimentoDTO> procedimento);

    // public Procedimento mapPacienteDTO(ProcedimentoDTO procedimento) {
    //     return null;
    // }

    // public ProcedimentoDTO mapPaciente(Procedimento procedimentoEntity) {
    //     return null;
    // }

    // // ProcedimentoDTO mapProcedimento(Procedimento procedimento);
    // // Procedimento mapProcedimentoDTO(ProcedimentoDTO procedimento);
}
