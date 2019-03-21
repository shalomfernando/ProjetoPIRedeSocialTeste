package br.edu.saojudas.redesocial.domain.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "UPLOAD_LOG")
public class UploadLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ARQ")
    private Long id;
    @Column(name = "NOME_ARQ")
    private String nome;
    @Column(name = "LOCAL_ARQ")
    private String caminho;
    @Column(name = "DATA_ARQ")
    private String data;
    @Column(name = "TIPO_ARQ")
    private String tipo;
}
