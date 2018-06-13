package ch.suva.extranet.m2mbetriebe.leistungsfall.persistence.entities.stories;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Beschreibt die Story IncapacitiesToWork.
 */
@Entity
@Table(name = "STORY_INCAPACITIES", uniqueConstraints={
        @UniqueConstraint(columnNames = {"STORY_ID", "INSURANCE_CASE_ID"})
})
public class IncapacitiesToWork extends AbstractStory {

    @OneToMany(mappedBy = "parent")
    private List<IncapacitiesToWorkEntry> entries;

    public IncapacitiesToWork() {}

    public IncapacitiesToWork(UUID uuid, String storyId, String insuranceCaseId, String geschaeftsPartner) {
        super(uuid, storyId, insuranceCaseId, geschaeftsPartner);
    }

    public List<IncapacitiesToWorkEntry> getEntries() {
        return Collections.unmodifiableList(entries);
    }
}
