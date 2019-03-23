package br.edu.saojudas.redesocial.infraestructure.repository;

import br.edu.saojudas.redesocial.domain.persistence.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long > {
    public UsuarioEntity findOneByUsernameAndPassword(String user, String senha);
}
