package com.starbattle.model.game;

import com.starbattle.model.entities.Player;
import com.starbattle.model.entities.Team;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Arena {
    private final Map<Team, List<Player>> teams = new HashMap<>();
    private List<Player> players = new ArrayList<>();
    private int round;
    private Team winner;

    public Arena(){
        for(Team t : Team.values()){
            teams.put(t, new ArrayList<>());
        }
        round = 1;
    }

    public void reset(){
        teams.clear();
        round = 1;
    }

    public int getRound(){
        return round;
    }

    public void addPlayer(Player p, Team t){
        teams.get(t).add(p);
    }

    public void removePlayer(Player p, Team t){
        teams.get(t).remove(p);
    }

    public List<Player> getPlayers(Team t){
        return teams.get(t);
    }

    public int playersAlive(Team t){
        int alive = 0;
        for(Player p : teams.get(t)){
            if(p.getClife() > 0){
                alive++;
            }
        }
        return alive;
    }

    public int nextRound(){
        round++;
        return round;
    }

    public boolean matchOngoing(){
        return playersAlive(Team.LIGHT) > 0 && playersAlive(Team.DARK) > 0;

    }

    public Team winner(){
        if(playersAlive(Team.DARK) > 0 && playersAlive(Team.LIGHT) == 0){
            winner = Team.DARK;
        }else if(playersAlive(Team.LIGHT) > 0 && playersAlive(Team.DARK) == 0){
            winner = Team.LIGHT;
        }
        return winner;
    }

    public Player getTarget(Team t){
        List<Player> alive = new ArrayList<>();

        for(Player p : teams.get(t.next())){
            if(p.getClife() > 0){
                alive.add(p);
            }else{
                removePlayer(p, t);
            }
        }

        if(alive.isEmpty()){
            winner = t;
        }

        int i = ThreadLocalRandom.current().nextInt(alive.size());
        return alive.get(i);
    }
}
