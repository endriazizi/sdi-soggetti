package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.DomicilioEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.DomicilioStoricoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DomicilioStoricoRepository extends JpaRepository<DomicilioStoricoEntity, UUID>, JpaSpecificationExecutor<DomicilioStoricoEntity> {

}
