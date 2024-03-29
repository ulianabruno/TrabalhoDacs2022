package br.univille.apidacs2022.service;

import java.util.List;

import br.univille.coredacs2022.entity.Consulta;
import br.univille.coredacs2022.entity.Paciente;

public interface ConsultaService {
    public List<Consulta> getAll();

    public Consulta save(Consulta consulta);

    public Consulta findById(long id);

    public Consulta delete(long id);

    public List<Consulta> getByPaciente(Paciente paciente);
}
