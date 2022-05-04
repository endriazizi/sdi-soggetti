package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "sdi_nazione")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Accessors(chain = true)
public class NazioneEntity implements Serializable {
    //public class AnagraficaEntity  extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "nazione" )
    private String nazione;

    @Column(name = "sigla")
    private String sigla;

    @Column(name = "belfiore")
    private String belfiore;

    @Column(name = "nazionalita")
    private LocalDate nazionalita;

    @Column(name = "sigla3")
    private String sigla3;

    @Column(name = "iso3166")
    private String iso3166;

    @Column(name = "iso3166_alpha2")
    private String iso3166_alpha2;

    @Column(name = "iso3166_alpha3")
    private String iso3166_alpha3;

    @Column(name = "flag_elimina")
    private Short flagElimina;

}
