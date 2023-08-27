package com.example.tennis.dao;

import com.example.tennis.dao.Model.DaoTennisPlayer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TennisPlayerDaoImpl implements TennisPlayerDao {

    final HashMap<Integer, DaoTennisPlayer> playerDatabase;

    public TennisPlayerDaoImpl() {
        playerDatabase = JSONToHashMapConverter.convertJSONToHashMap("tennisPlayersList.json");
    }

    public DaoTennisPlayer getTennisPlayerById(Integer id) {
        return playerDatabase.get(id);
    }

    public List<DaoTennisPlayer> getAllTennisPlayers() {
        return new ArrayList<>(playerDatabase.values());
    }

    // other CRUD methods can be added here
}
