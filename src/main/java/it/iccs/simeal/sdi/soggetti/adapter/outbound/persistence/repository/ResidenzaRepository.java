package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.AnagraficaEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.ResidenzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResidenzaRepository extends JpaRepository<ResidenzaEntity, UUID>, JpaSpecificationExecutor<ResidenzaEntity> {

}
