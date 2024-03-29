package br.univille.coredacs2022.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 500)
    private String nome;
    private String CRM;

    
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private List<Medico> listaDeMedicos = new ArrayList<>();

    
    // public List<Medico> getListaDeMedicos() {
    //     return listaDeMedicos;
    // }
    // public void setListaDeMedicos(List<Medico> listaDeMedicos) {
    //     this.listaDeMedicos = listaDeMedicos;
    // }
    
    public long getId() {
        return id;
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
    public String getCRM() {
        return CRM;
    }
    public void setCRM(String CRM) {
        this.CRM = CRM;
    }
    
}
