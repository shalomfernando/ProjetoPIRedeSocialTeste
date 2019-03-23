package br.edu.saojudas.redesocial.domain.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USUARIO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;
    @Column(name = "USER_USERNAME")
    private String username;
    @Column(name = "USER_PASSWORD")
    private String password;
    @Column(name = "USER_NAME")
    private String name;
    @OneToMany(cascade= CascadeType.ALL)
    private List<UploadLogEntity> logEntities;

}
