package br.edu.saojudas.redesocial.domain.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioTO {

    private Long id;
    private String username;
    private String password;
    private String name;
    private String lastName;


}
