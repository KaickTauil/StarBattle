package com.starbattle.game;

import com.starbattle.entities.Player;
import com.starbattle.entities.Team;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Arena {
    private List<Player> teamLight = new ArrayList<>();
    private List<Player> teamDark = new ArrayList<>();
    private final Map<Team, List<Player>> teams = new HashMap<>();

    public Arena(){
        for(Team t : Team.values()){
            teams.put(t, new ArrayList<>());
        }
    }

    public void addPlayer(Player p, Team t){
        teams.get(t).add(p);
    }

    public boolean allies(Player p1, Player p2){
        return p1.getTeam().equals(p2.getTeam());
    }
}
