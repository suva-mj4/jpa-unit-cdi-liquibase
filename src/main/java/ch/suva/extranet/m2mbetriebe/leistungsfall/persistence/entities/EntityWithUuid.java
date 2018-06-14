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
    private String uuid;

    public EntityWithUuid() {}

    public EntityWithUuid(String uuid) {
        this.uuid = uuid;
    }
}
