package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "sdi_comune")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Accessors(chain = true)
public class ComuneEntity implements Serializable {
    //public class AnagraficaEntity  extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "comune" )
    private String comune;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "cap")
    private String cap;

    @Column(name = "localita")
    private LocalDate localita;

    @Column(name = "belfiore")
    private String belfiore;

    @Column(name = "regione")
    private String regione;

    @Column(name = "codiceRegione")
    private String codiceRegione;

    @Column(name = "id_nazione")
    private String idNazione;

    @Column(name = "istat")
    private String istat;

    @Column(name = "flagProvincia")
    private Boolean flagProvincia;

    @Column(name = "flag_elimina")
    private Short flagElimina;
    
}
