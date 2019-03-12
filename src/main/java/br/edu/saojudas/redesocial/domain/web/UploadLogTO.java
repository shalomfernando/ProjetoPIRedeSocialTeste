package br.edu.saojudas.redesocial.domain.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UploadLogTO {

    private Long id;
    private String nome;
    private String caminho;
    private String data;
}
