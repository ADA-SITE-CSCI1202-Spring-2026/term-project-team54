package com.team54.airportdispatchtycoonteam54.core.Services;

import java.util.ArrayList;

public class CrewManager {
    ArrayList<IGroundService> groundService;

    public CrewManager(){
        groundService = new ArrayList<>();
    }

    public void AddCrew(IGroundService crew){
        groundService.add(crew);
    }
}
