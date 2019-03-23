package br.edu.saojudas.redesocial.domain.persistence.User;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String ano_Nascimento;
    private String endereco;

    //@OneToMany(cascade = CascadeType.ALL)
   // @JoinColumn(nullable = false, name = "id_user", foreignKey = @ForeignKey(name = "FK_ID_USER_ON_UPLOAD_USER"))
    private long id_user;


    public Usuario() {
    }

    public Usuario(Long id, String nome, String ano_Nascimento, String endereco, long id_user) {
        this.id = id;
        this.nome = nome;
        this.ano_Nascimento = ano_Nascimento;
        this.endereco = endereco;
        this.id_user = id_user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAno_Nascimento() {
        return ano_Nascimento;
    }

    public void setAno_Nascimento(String ano_Nascimento) {
        this.ano_Nascimento = ano_Nascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }
}
