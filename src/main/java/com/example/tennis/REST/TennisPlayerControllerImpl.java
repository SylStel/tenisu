package com.example.tennis.REST;

import com.example.tennis.Service.TennisPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TennisPlayerControllerImpl implements TennisPlayerController {

    private final TennisPlayerService tennisPlayerService;

    @Autowired
    public TennisPlayerControllerImpl(TennisPlayerService tennisPlayerService) {
        this.tennisPlayerService = tennisPlayerService;
    }

    @Override
    public String getTennisPlayer(String id) {
        Integer intId = Integer.valueOf(id);
        return tennisPlayerService.getTennisPlayerInfo(intId);
    }

    @Override
    public String getTennisPlayersList() {
        return tennisPlayerService.getAllTennisPlayersSortedByRank();
    }

    @Override
    public String getTennisPlayerStats() {
        return tennisPlayerService.getTennisPlayerStats();
    }
}

