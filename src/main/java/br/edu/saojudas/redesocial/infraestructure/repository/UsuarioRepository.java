package br.edu.saojudas.redesocial.infraestructure.repository;

import br.edu.saojudas.redesocial.domain.persistence.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long> {
}
