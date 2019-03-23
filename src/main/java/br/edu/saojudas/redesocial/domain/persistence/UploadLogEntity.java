package br.edu.saojudas.redesocial.domain.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "UPLOAD_LOG")
public class UploadLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ARQ_ID")
    private Long id;
    @Column(name = "ARQ_NOME")
    private String nome;
    @Column(name = "ARQ_DESC")
    private String descricao;
    @Column(name = "ARQ_LOCAL")
    private String caminho;
    @Column(name = "ARQ_DATA")
    private String data;
    @Column(name = "ARQ_TIPO")
    private String tipo;

    @ManyToMany(cascade= CascadeType.ALL)
    @JoinColumn(nullable = false, name= "TAG_ID", foreignKey = @ForeignKey(name = "FK_TAG_ON_UPLOAD_LOG"))
    private List<TagEntity> tagEntity;

    @OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(nullable = false, name = "CATE_ID", foreignKey = @ForeignKey(name = "FK_CATEGORIA_ON_UPDATE_LOG"))
    private CategoriaEntity categoriaEntity;
}
