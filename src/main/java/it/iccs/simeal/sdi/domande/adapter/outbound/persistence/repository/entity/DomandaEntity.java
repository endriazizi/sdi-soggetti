package it.iccs.simeal.sdi.domande.adapter.outbound.persistence.repository.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "sdi_dmn_domanda")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Accessors(chain = true)
public class DomandaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "flag_elimina")
    private Short flagElimina;
}
