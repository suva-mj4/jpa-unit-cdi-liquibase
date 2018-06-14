package ch.suva.extranet.m2mbetriebe.leistungsfall.persistence.entities.stories;

import ch.suva.extranet.m2mbetriebe.leistungsfall.persistence.entities.ProtectedEntity;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * Beschreibt einen IncapacitiesToWork-Eintrag.
 */
@Entity
@Table(name = "STORY_INCAPACITIES_ENTRY")
public class IncapacitiesToWorkEntry extends ProtectedEntity {

    @Column(name = "PERCENTAGE", nullable = false)
    private Double percentage;

    @Column(name = "FROM", nullable = false)
    @Temporal(TemporalType.DATE)
    private GregorianCalendar from;

    @Column(name = "TO")
    @Temporal(TemporalType.DATE)
    private GregorianCalendar to;

    @Column(name = "TAKE_WORK_UP_FULLY_DATE")
    @Temporal(TemporalType.DATE)
    private GregorianCalendar takeWorkUpFullyDate;

    @JoinColumn(name = "PARENT")
    @ManyToOne(optional = false)
    private IncapacitiesToWork parent;

    public IncapacitiesToWorkEntry() {}

    public IncapacitiesToWorkEntry(String uuid, String geschaeftsPartner, IncapacitiesToWork parent, Double percentage, GregorianCalendar from) {
        super(uuid, geschaeftsPartner);
        this.percentage = percentage;
        this.from = from;
        this.parent = parent;
    }

    public Double getPercentage() {
        return percentage;
    }

    public GregorianCalendar getFrom() {
        return from;
    }

    public GregorianCalendar getTo() {
        return to;
    }

    public GregorianCalendar getTakeWorkUpFullyDate() {
        return takeWorkUpFullyDate;
    }

    public IncapacitiesToWork getParent() {
        return parent;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public void setFrom(GregorianCalendar from) {
        this.from = from;
    }

    public void setTo(GregorianCalendar to) {
        this.to = to;
    }

    public void setTakeWorkUpFullyDate(GregorianCalendar takeWorkUpFullyDate) {
        this.takeWorkUpFullyDate = takeWorkUpFullyDate;
    }
}
