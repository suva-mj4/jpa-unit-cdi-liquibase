package ch.suva.extranet.m2mbetriebe.leistungsfall.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 *
 */
@MappedSuperclass
public abstract class EntityWithUuid {

    @Id
    @Column(name = "UUID", nullable = false, unique = true)
    private UUID uuid;

    public EntityWithUuid() {}

    public EntityWithUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
