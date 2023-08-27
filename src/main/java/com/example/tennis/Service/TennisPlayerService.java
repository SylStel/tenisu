package com.example.tennis.Service;

import com.example.tennis.REST.TennisPlayerController;
import com.example.tennis.Service.Model.TennisPlayer;
import com.example.tennis.dao.TennisPlayerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TennisPlayerService {

    private final TennisPlayerDao tennisPlayerDao;

    @Autowired
    public TennisPlayerService(TennisPlayerDao tennisPlayerDao) {
        this.tennisPlayerDao = tennisPlayerDao;
    }

    public String getTennisPlayerInfo(Integer id) {
        TennisPlayer tennisPlayer = TennisPlayerMapper.mapToServiceTennisPlayer(tennisPlayerDao.getTennisPlayerById(id));
        return tennisPlayer.getTennisPlayerInfo();
    }

    public String getAllTennisPlayersSortedByRank() {
        List<TennisPlayer> players = TennisPlayerMapper.mapListToService(tennisPlayerDao.getAllTennisPlayers());
        List<TennisPlayer> sortedPlayers = players.stream()
                .sorted(Comparator.comparingInt(player -> player.getData().getRank()))
                .toList();

        return formatPlayers(sortedPlayers);
    }

    private static String formatPlayers(List<TennisPlayer> players) {
        StringBuilder result = new StringBuilder();

        for (TennisPlayer player : players) {
            int id = player.getId();
            String firstname = player.getFirstname();
            String lastname = player.getLastname();
            int rank = player.getData().getRank();

            result.append(id).append(" ").append(firstname).append(" ").append(lastname).append(" ").append(rank).append("<br>");
        }

        return result.toString();
    }

    public String getTennisPlayerStats() {
        List<TennisPlayer> players = TennisPlayerMapper.mapListToService(tennisPlayerDao.getAllTennisPlayers());
        String countryWithHighestWinRatio = findCountryWithHighestWinRatio(players);
        double averageBMI = calculateAverageBMI(players);
        double medianHeight = calculateMedianHeight(players);
        return "Players Statistics"
                + "<br>Country With Highest Win Ratio : " + countryWithHighestWinRatio
                + "<br>Average BMI : " + averageBMI
                + "<br>Median Height : " + medianHeight;
    }

    public static String findCountryWithHighestWinRatio(List<TennisPlayer> players) {
        Map<String, Integer> winsByCountry = new HashMap<>();
        Map<String, Integer> matchesPlayedByCountry = new HashMap<>();

        for (TennisPlayer player : players) {
            String countryCode = player.getCountry().getCode();
            int[] lastGames = player.getData().getLast();

            int wins = 0;
            for (int gameResult : lastGames) {
                if (gameResult == 1) {
                    wins++;
                }
            }

            winsByCountry.put(countryCode, winsByCountry.getOrDefault(countryCode, 0) + wins);
            matchesPlayedByCountry.put(countryCode, matchesPlayedByCountry.getOrDefault(countryCode, 0) + lastGames.length);
        }

        double maxWinRatio = 0.0;
        String countryWithHighestRatio = "";

        for (String countryCode : winsByCountry.keySet()) {
            int wins = winsByCountry.get(countryCode);
            int matchesPlayed = matchesPlayedByCountry.get(countryCode);

            double winRatio = (double) wins / matchesPlayed;

            if (winRatio > maxWinRatio) {
                maxWinRatio = winRatio;
                countryWithHighestRatio = countryCode;
            }
        }

        return countryWithHighestRatio;
    }

    public static double calculateAverageBMI(List<TennisPlayer> players) {
        double totalBMI = 0.0;
        int numPlayers = players.size();
        if (numPlayers == 0) {
            return 0.0;
        }

        for (TennisPlayer player : players) {
            double weightKg = player.getData().getWeight() / 1000.0; // we want kg
            double heightM = player.getData().getHeight() / 100.0; // we want meters

            double bmi = weightKg / (heightM * heightM);
            totalBMI += bmi;
        }

        return totalBMI / numPlayers;
    }

    public static double calculateMedianHeight(List<TennisPlayer> players) {
        int numPlayers = players.size();

        if (numPlayers == 0) {
            return 0.0;
        }

        players.sort((p1, p2) -> Integer.compare(p1.getData().getHeight(), p2.getData().getHeight()));

        if (numPlayers % 2 == 0) {
            int middleIndex1 = (numPlayers / 2) - 1;
            int middleIndex2 = numPlayers / 2;
            int height1 = players.get(middleIndex1).getData().getHeight();
            int height2 = players.get(middleIndex2).getData().getHeight();
            return (height1 + height2) / 2.0;
        } else {
            int middleIndex = numPlayers / 2;
            return players.get(middleIndex).getData().getHeight();
        }
    }

}
