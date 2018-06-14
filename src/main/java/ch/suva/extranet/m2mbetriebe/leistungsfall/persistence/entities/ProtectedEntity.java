package ch.suva.extranet.m2mbetriebe.leistungsfall.persistence.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * Beschreibt eine via VPD abgesicherte Basis-Entität. Jede Entity, welche via VPD abgesichert sein soll kann einfach von
 * dieser abstrakten Basisklasse abgeleitet werden. Sie beinhaltet lediglich das Attribut "geschaeftsPartner", welches
 * strikt auf das Tabellen-Feld "GESCHAEFTS_PARTNER" abgebildet wird.
 *
 * Initialisiert wird eine solche Entität mittels Konstruktor-Aufruf. Ableitende Klassen können diesen Konstruktor entweder
 * überschreiben, oder in einem neuen Konstruktur aufrufen.
 */
@MappedSuperclass
public abstract class ProtectedEntity extends EntityWithUuid {

    @Column(name = "GESCHAEFTS_PARTNER", nullable = false)
    private String geschaeftsPartner;

    public ProtectedEntity() {}

    public ProtectedEntity(String uuid, String geschaeftsPartner) {
        super(uuid);
        this.geschaeftsPartner = geschaeftsPartner;
    }
}
