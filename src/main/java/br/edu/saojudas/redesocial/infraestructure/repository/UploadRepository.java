package br.edu.saojudas.redesocial.infraestructure.repository;

import br.edu.saojudas.redesocial.domain.persistence.UploadLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadRepository extends JpaRepository<UploadLogEntity,Long> {
}
