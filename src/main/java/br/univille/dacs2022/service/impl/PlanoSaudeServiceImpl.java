package br.univille.dacs2022.service.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.dacs2022.dto.PlanoSaudeDTO;
// import br.univille.dacs2022.entity.PlanoSaude;
import br.univille.dacs2022.mapper.PlanoSaudeMapper;
import br.univille.dacs2022.repository.PlanoSaudeRepository;
import br.univille.dacs2022.service.PlanoSaudeService;

@Service
public class PlanoSaudeServiceImpl implements PlanoSaudeService{

    @Autowired
    private PlanoSaudeRepository repository;
    private PlanoSaudeMapper mapper = Mappers.getMapper(PlanoSaudeMapper.class);

    @Override
    public List<PlanoSaudeDTO> getAll() {
        var listaPlanoSaude = repository.findAll();
        return mapper.mapListPlanoSaude(listaPlanoSaude);
    }

    @Override
    public PlanoSaudeDTO getById(long id) {
        var plano = repository.findById(id);
        return mapper.mapPlanoSaude(plano.get());
    }
    
}
