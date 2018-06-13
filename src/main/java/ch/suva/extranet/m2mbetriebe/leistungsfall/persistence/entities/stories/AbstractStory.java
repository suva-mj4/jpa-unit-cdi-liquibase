package ch.suva.extranet.m2mbetriebe.leistungsfall.persistence.entities.stories;

import ch.suva.extranet.m2mbetriebe.leistungsfall.persistence.entities.ProtectedEntity;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * Beschreibt eine abstrakte Story. Ein Story bezieht sich immer auf einen Leistungsfall eines Geschäftspartner und hat
 * eine eindeutige (frei wählbare) ID innerhalb dieses Leistungsfall. Optional kann ein technischer Identifier des
 * Aufrufers mit übergeben werden, die sog. Incident Case ID. Diese wird primär vom KLEE-Receiver gesetzt, wenn die Story
 * über die Swissdec-Schnittstelle angeliefert wurde.
 */
@MappedSuperclass
public abstract class AbstractStory extends ProtectedEntity {

    @Column(name = "STORY_ID", nullable = false)
    private String storyId;

    @Column(name = "INSURANCE_CASE_ID", nullable = false)
    private String insuranceCaseId;

    @Column(name = "INCIDENT_CASE_ID")
    private String incidentCaseId;

    @Column(name = "CREATION_DATE", nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private GregorianCalendar creationDate;

    public AbstractStory() {}

    public AbstractStory(UUID uuid, String geschaeftsPartner, String insuranceCaseId, String storyId) {
        super(uuid, geschaeftsPartner);
        this.insuranceCaseId = insuranceCaseId;
        this.storyId = storyId;
        this.creationDate = new GregorianCalendar();
    }

    public AbstractStory(UUID uuid, String geschaeftsPartner, String insuranceCaseId, String incidentCaseId, String storyId) {
        super(uuid, geschaeftsPartner);
        this.insuranceCaseId = insuranceCaseId;
        this.incidentCaseId = incidentCaseId;
        this.storyId = storyId;
        this.creationDate = new GregorianCalendar();
    }

    public GregorianCalendar getCreationDate() {
        return creationDate;
    }
}
