package br.univille.dacs2022.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

// import br.univille.dacs2022.entity.Cidade;

public class PacienteDTO {
    private long id;
    
    @NotBlank(message="O campo nome nao pode ser deixado em branco")
    @NotNull
    private String nome;

    @Pattern(regexp = "Masculino|Feminino", flags = Pattern.Flag.CANON_EQ, message = "Resposta invalida, apenas 'Masculino', ou 'Feminino'")
    private String sexo;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    private long cidadeId;
    private CidadeDTO cidade;

    private List<PlanoSaudeDTO> listaPlanoSaude = new ArrayList<>();
    private long planoSaudeId;
    
    public long getCidadeId() {
        return cidadeId;
    }
    public void setCidadeId(long cidadeId) {
        this.cidadeId = cidadeId;
    }
    public List<PlanoSaudeDTO> getListaPlanoSaude() {
        return listaPlanoSaude;
    }
    public void setListaPlanoSaude(List<PlanoSaudeDTO> listaPlanoSaude) {
        this.listaPlanoSaude = listaPlanoSaude;
    }
    public long getPlanoSaudeId() {
        return planoSaudeId;
    }
    public void setPlanoSaudeId(long planoSaudeId) {
        this.planoSaudeId = planoSaudeId;
    }
    public CidadeDTO getCidade() {
        return cidade;
    }
    public void setCidade(CidadeDTO cidade) {
        this.cidade = cidade;
    }
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
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
}
