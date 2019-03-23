package br.edu.saojudas.redesocial.infraestructure.repository;

import br.edu.saojudas.redesocial.domain.persistence.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity,Long> {
}
