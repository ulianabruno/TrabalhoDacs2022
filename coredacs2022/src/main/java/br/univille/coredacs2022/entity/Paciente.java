package br.univille.coredacs2022.entity;

import java.util.Date;
// import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 500) //Aumentar numero de caracteres (nome)
    private String nome;
    private String sexo;

    @Temporal(value = TemporalType.DATE)
    private Date dataNascimento;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Cidade cidade;

    public long getId() {
        return id;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    public Cidade getCidade() {
        return cidade;
    }
    // public void setListaPlanos(String cidade) {
    //     this.cidade = cidade;
    // }
    // public String getListaPlanos() {
    //     return cidade;
    // }

    // public List<PlanoSaude> getListaPlanos() {
    //     return listaPlanos;
    // }
    // public void setListaPlanoSaude(List<PlanoSaudeDTO> listaPlanoSaude) {
    //     this.listaPlanoSaude = listaPlanoSaude;
    // }
    
}
