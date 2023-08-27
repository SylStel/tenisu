package com.example.tennis.dao;

import com.example.tennis.dao.Model.DaoTennisPlayer;

import java.util.List;

public interface TennisPlayerDao {

    DaoTennisPlayer getTennisPlayerById(Integer id);
    List<DaoTennisPlayer> getAllTennisPlayers();

    // other CRUD methods can be added here
}
