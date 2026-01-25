package com.starbattle.game;

import com.starbattle.entities.Player;
import com.starbattle.entities.Team;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Arena {
    private final Map<Team, List<Player>> teams = new HashMap<>();
    private int round;
    private Team winner;

    public Arena(){
        for(Team t : Team.values()){
            teams.put(t, new ArrayList<>());
        }
        round = 1;
    }

    public int getRound(){
        return round;
    }

    public void addPlayer(Player p, Team t){
        teams.get(t).add(p);
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

    public void nextRound(){
        if(!match()){
            System.out.println("O time " + winner + "triunfou sobre seus inimigos !!\nA arena os consagra vencedores.");
            return;
        }
        round++;
        System.out.println("Round "+round+" iniciado!");
    }

    public boolean match(){
        return playersAlive(Team.LIGHT) > 0 && playersAlive(Team.DARK) > 0;
    }

    public Player getTarget(Team t){
        List<Player> alive = new ArrayList<>();

        for(Player p : teams.get(t.next())){
            if(p.getClife() > 0){
                alive.add(p);
            }
        }

        if(alive.isEmpty()){
            winner = t;
            return null;
        }

        int i = ThreadLocalRandom.current().nextInt(alive.size());
        return alive.get(i);
    }
}
