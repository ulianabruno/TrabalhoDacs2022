package br.univille.dacs2022.service.impl;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.dacs2022.dto.ProcedimentoDTO;
import br.univille.coredacs2022.entity.Procedimento;
import br.univille.dacs2022.mapper.ProcedimentoMapper;
import br.univille.coredacs2022.repository.ProcedimentoRepository;
import br.univille.dacs2022.service.ProcedimentoService;

@Service
public class ProcedimentoServiceImpl implements ProcedimentoService{

    @Autowired
    private ProcedimentoRepository repository;

    private ProcedimentoMapper mapper = Mappers.getMapper(ProcedimentoMapper.class);

    @Override
    public List<ProcedimentoDTO> getAll() {
        return mapper.mapListProcedimento(repository.findAll());
    }

    @Override
    public ProcedimentoDTO save(ProcedimentoDTO procedimento) {
        Procedimento procedimentoEntity = mapper.mapProcedimentoDTO(procedimento);
        procedimentoEntity = repository.save(procedimentoEntity);
        return mapper.mapProcedimento(procedimentoEntity);
    }

    @Override
    public ProcedimentoDTO findById(long id) {
        Optional<Procedimento> procedimentoEntity = 
            repository.findById(id);

        if (procedimentoEntity.isPresent()){
            return mapper.mapProcedimento(procedimentoEntity.get());
        }

        return new ProcedimentoDTO();
    }

    @Override
    public ProcedimentoDTO delete(long id) {
        Optional<Procedimento> procedimentoEntity = 
            repository.findById(id);

        if (procedimentoEntity.isPresent()){
            Procedimento procedimento  = procedimentoEntity.get();
            repository.delete(procedimento);
            return mapper.mapProcedimento(procedimento);
        }
        return null;
    }
    
}
