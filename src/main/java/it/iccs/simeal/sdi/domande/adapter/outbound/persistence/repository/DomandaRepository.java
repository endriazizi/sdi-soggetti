package it.iccs.simeal.sdi.domande.adapter.outbound.persistence.repository;

import it.iccs.simeal.sdi.domande.adapter.outbound.persistence.repository.entity.DomandaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DomandaRepository extends JpaRepository<DomandaEntity, UUID>, JpaSpecificationExecutor<DomandaEntity> {

}
