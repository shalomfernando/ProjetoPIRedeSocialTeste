package br.edu.saojudas.redesocial.infraestructure.repository;

import br.edu.saojudas.redesocial.domain.persistence.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagEntity,Long> {
}
