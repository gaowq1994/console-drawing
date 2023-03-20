package creditsuisse.codingchallenge.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EntityFactoryTest {
    private EntityFactory entityFactory;

    @BeforeEach
    public void setUp() {
        entityFactory = new EntityFactory();
    }

    @Test
    void testGetEntityNull() {
        assertNull(entityFactory.getEntity(null));
    }
}
