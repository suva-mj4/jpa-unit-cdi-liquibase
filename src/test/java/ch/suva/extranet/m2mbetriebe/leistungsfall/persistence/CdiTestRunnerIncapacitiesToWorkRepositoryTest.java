package ch.suva.extranet.m2mbetriebe.leistungsfall.persistence;

import ch.suva.extranet.m2mbetriebe.leistungsfall.persistence.entities.stories.IncapacitiesToWork;
import ch.suva.extranet.m2mbetriebe.leistungsfall.persistence.repositories.IncapacitiesToWorkRepository;
import eu.drus.jpa.unit.api.Bootstrapping;
import eu.drus.jpa.unit.api.InitialDataSets;
import eu.drus.jpa.unit.api.JpaUnitRule;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.*;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RunWith(CdiTestRunner.class)
public class CdiTestRunnerIncapacitiesToWorkRepositoryTest {

    @Rule
    public JpaUnitRule rule = new JpaUnitRule(getClass());

    @PersistenceContext(unitName = "unittest")
    private static EntityManager em;

    @Inject
    private IncapacitiesToWorkRepository repository;

    @Bootstrapping
    public static void prepareDataBase(final DataSource ds) throws LiquibaseException, SQLException {
        Connection connection = ds.getConnection();
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
        Liquibase liquibase = new Liquibase("ch/suva/extranet/m2mbetriebe/leistungsfall/db/master.xml", new ClassLoaderResourceAccessor(), database);
        liquibase.dropAll();
        liquibase.update("!test-data");
    }

    @Before
    public void setup() throws LiquibaseException {
        repository.setEntityManager(em);
    }

    @Test
    @InitialDataSets("datasets/TestGetAll.json")
    public void testGetAll() {
        List<IncapacitiesToWork> liste = repository.getAll();
        Assert.assertEquals(1, liste.size());
    }
}
