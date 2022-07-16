package br.univille.dacs2022.service.impl;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.dacs2022.dto.MedicoDTO;
import br.univille.dacs2022.entity.Medico;
import br.univille.dacs2022.mapper.MedicoMapper;
import br.univille.dacs2022.repository.MedicoRepository;
import br.univille.dacs2022.service.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService{
    
    @Autowired
    private MedicoRepository repository;

    private MedicoMapper mapper = Mappers.getMapper(MedicoMapper.class);

    @Override
    public List<MedicoDTO> getAll() {
        return mapper.mapListMedico(repository.findAll());
    }

    @Override
    public MedicoDTO save(MedicoDTO medico) {
        Medico medicoEntity = mapper.mapMedicoDTO(medico);
        medicoEntity = repository.save(medicoEntity);
        return mapper.mapMedico(medicoEntity);
    }

    @Override
    public MedicoDTO findById(long id) {
        Optional<Medico> MedicoEntity = 
            repository.findById(id);

        if (MedicoEntity.isPresent()){
            return mapper.mapMedico(MedicoEntity.get());
        }

        return new MedicoDTO();
    }

    @Override
    public MedicoDTO delete(long id) {
        Optional<Medico> MedicoEntity = 
            repository.findById(id);

        if (MedicoEntity.isPresent()){
            Medico medico  = MedicoEntity.get();
            repository.delete(medico);
            return mapper.mapMedico(medico);
        }
        return null;
    }
}