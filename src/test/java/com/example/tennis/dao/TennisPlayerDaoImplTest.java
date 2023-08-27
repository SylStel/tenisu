package com.example.tennis.dao;
import com.example.tennis.dao.Model.DaoTennisPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TennisPlayerDaoImplTest {

    private TennisPlayerDaoImpl tennisPlayerDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        tennisPlayerDao = new TennisPlayerDaoImpl();
    }

    @Test
    public void testGetTennisPlayerById() {

        DaoTennisPlayer retrievedPlayer = tennisPlayerDao.getTennisPlayerById(52);
        assertNotEquals(retrievedPlayer, null);
        assertEquals(retrievedPlayer.getFirstname(), "Novak");
    }

    @Test
    public void testGetAllTennisPlayers() {

        List<DaoTennisPlayer> players = tennisPlayerDao.getAllTennisPlayers();
        assertNotEquals(players, null);
        assertEquals(5, players.size());
    }
}
