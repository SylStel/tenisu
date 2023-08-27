package com.example.tennis.Service;
import com.example.tennis.Service.Model.TennisPlayer;
import com.example.tennis.dao.Model.DaoTennisPlayer;
import com.example.tennis.dao.TennisPlayerDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
public class TennisPlayerServiceTest {
    @Mock
    private TennisPlayerDao tennisPlayerDao;

    @InjectMocks
    private TennisPlayerService tennisPlayerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    //these tests need an object builder to easily create test object
 /*   @Test
    void testGetTennisPlayerInfo() {
        int[] last = {1, 0};
        DaoTennisPlayer daoTennisPlayer = new DaoTennisPlayer.DaoTennisPlayerBuilder()
                .withId(1)
                .withFirstname("Jean")
                        .withLastname("Dupont")
                .withCountry(new DaoTennisPlayer.Country("picture", "FR"))
                .withData(new DaoTennisPlayer.PlayerData(2, 2542, 80000, 188, 31, last))
                        .build();


        when(tennisPlayerDao.getTennisPlayerById(1)).thenReturn(daoTennisPlayer);

        String playerInfo = tennisPlayerService.getTennisPlayerInfo(1);

        assertEquals("id : 1<br>firstname : Jean<br>lastname : Dupont<br>shortname : null<br>sex : null<br>country.picture : picture<br>country.code : FR<br>picture : null<br>data.rank : 2<br>data.points : 2542<br>data.weight : 80000<br>data.height : 188<br>data.age : 31<br>data.last : [1, 0]\n", playerInfo);

        verify(tennisPlayerDao).getTennisPlayerById(1);
    }*/

 /*   @Test
    public void testGetAllTennisPlayersSortedByRank() {
        List<TennisPlayer> fakePlayers = new ArrayList<>();
   //     fakePlayers.add(new TennisPlayerBuilder().withData(new DataBuilder().withRank(2).build()).build());
     //   fakePlayers.add(new TennisPlayerBuilder().withData(new DataBuilder().withRank(1).build()).build());
    //    fakePlayers.add(new TennisPlayerBuilder().withData(new DataBuilder().withRank(3).build()).build());

        when(tennisPlayerDao.getAllTennisPlayers()).thenReturn(fakePlayers);

        String result = tennisPlayerService.getAllTennisPlayersSortedByRank();

        String expected = "Player: rank=1\nPlayer: rank=2\nPlayer: rank=3\n";
        assertEquals(expected, result);
    }*/
}
