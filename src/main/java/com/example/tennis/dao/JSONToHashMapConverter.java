package com.example.tennis.dao;

import com.example.tennis.dao.Model.DaoTennisPlayer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class JSONToHashMapConverter {
        public static HashMap<Integer, DaoTennisPlayer> convertJSONToHashMap(String filePath) {
            HashMap<Integer, DaoTennisPlayer> playersMap = new HashMap<>();
            ObjectMapper objectMapper = new ObjectMapper();

            try {
                ClassLoader classLoader = JSONToHashMapConverter.class.getClassLoader();
                InputStream inputStream = classLoader.getResourceAsStream(filePath);

                if (inputStream == null) {
                    throw new IllegalArgumentException("File not found: " + filePath);
                }

                TennisPlayerData data = objectMapper.readValue(inputStream, TennisPlayerData.class);

                for (DaoTennisPlayer player : data.getPlayers()) {
                    playersMap.put(player.getId(), player);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return playersMap;
        }
    }
class TennisPlayerData {
    private List<DaoTennisPlayer> players;

    public List<DaoTennisPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<DaoTennisPlayer> players) {
        this.players = players;
    }
}



