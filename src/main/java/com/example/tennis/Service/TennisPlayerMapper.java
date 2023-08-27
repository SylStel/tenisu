package com.example.tennis.Service;
import com.example.tennis.Service.Model.TennisPlayer;
import com.example.tennis.dao.Model.DaoTennisPlayer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TennisPlayerMapper {

    public static List<TennisPlayer> mapListToService(List<DaoTennisPlayer> daoPlayers) {
        List<TennisPlayer> servicePlayers = new ArrayList<>();

        for (DaoTennisPlayer daoPlayer : daoPlayers) {
            TennisPlayer servicePlayer = mapToServiceTennisPlayer(daoPlayer);
            servicePlayers.add(servicePlayer);
        }

        return servicePlayers;
    }
    public static TennisPlayer mapToServiceTennisPlayer(DaoTennisPlayer daoTennisPlayer) {
        TennisPlayer tennisPlayer = new TennisPlayer();
        tennisPlayer.setId(daoTennisPlayer.getId());
        tennisPlayer.setFirstname(daoTennisPlayer.getFirstname());
        tennisPlayer.setLastname(daoTennisPlayer.getLastname());
        tennisPlayer.setShortname(daoTennisPlayer.getShortname());
        tennisPlayer.setSex(daoTennisPlayer.getSex());
        tennisPlayer.setCountry(mapCountry(daoTennisPlayer.getCountry()));
        tennisPlayer.setPicture(daoTennisPlayer.getPicture());
        tennisPlayer.setData(mapData(daoTennisPlayer.getData()));
        return tennisPlayer;
    }

    private static TennisPlayer.Country mapCountry(DaoTennisPlayer.Country daoCountry) {
        TennisPlayer.Country playerCountry = new TennisPlayer.Country();
        playerCountry.setPicture(daoCountry.getPicture());
        playerCountry.setCode(daoCountry.getCode());
        return playerCountry;
    }

    private static TennisPlayer.PlayerData mapData(DaoTennisPlayer.PlayerData daoData) {
        TennisPlayer.PlayerData playerData = new TennisPlayer.PlayerData();
        playerData.setRank(daoData.getRank());
        playerData.setPoints(daoData.getPoints());
        playerData.setWeight(daoData.getWeight());
        playerData.setHeight(daoData.getHeight());
        playerData.setAge(daoData.getAge());
        playerData.setLast(daoData.getLast());
        return playerData;
    }
}
