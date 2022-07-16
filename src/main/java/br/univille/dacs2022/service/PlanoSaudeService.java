package br.univille.dacs2022.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.dacs2022.dto.PlanoSaudeDTO;

@Service
public interface PlanoSaudeService {
    public List<PlanoSaudeDTO> getAll();
    public PlanoSaudeDTO getById(long id);
}
