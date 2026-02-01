package com.starbattle.controller;

import com.starbattle.factory.PlayerClass;
import com.starbattle.factory.PlayerFactory;
import com.starbattle.model.entities.Player;
import com.starbattle.model.entities.Team;
import com.starbattle.model.game.Arena;
import com.starbattle.view.GameView;

public class GameController {
    private Arena arena = new Arena();
    private GameView view = new GameView();

    public GameController(){}
    
    //construtor para testes
    public GameController(Arena a, GameView v){
        this.arena = a;
        this.view = v;
    }

    public void initGame(){
        boolean running = true;

        while(running){
            boolean start = view.lobby();

            if(!start){
                view.goodbyeMessage();
                break;
            }

            RegisterResult op = registerPlayer();

            if(op == RegisterResult.START){
                runGame();
                arena.reset();
            }else{
                view.goodbyeMessage();
                running = false;
            }
        }
    }
    
    public RegisterResult registerPlayer(){
        while (true) { 
            String name = view.requestName();

            Team team = view.requestTeam();

            PlayerClass type = view.requestClass();

            arena.addPlayer(PlayerFactory.create(type, name, team), team); 

            view.createdPlayerMessage();

            int op = view.secondMenu();

            if(op ==  2){
                return RegisterResult.START;
            }else if(op == 3){
                return RegisterResult.EXIT;
            }
        }
    }

    public void runGame(){
        gameloop:
        while(arena.matchOngoing()){

            view.roundInit(arena.getRound());

            for(Team t : Team.values()){
                for(Player p : arena.getPlayers(t)){
                    view.roundInit(arena.getRound());
                    Player target = arena.getTarget(t);
                    int act = view.getAction(p, target);
                    switch (act) {
                        case 1 -> {
                            p.attack(target);
                            view.attackMessage(p);
                        } 
                        case 2 -> {
                            int i = view.getSkill(p);
                            p.useSkill(target, i);
                        }
                        default -> view.skipTurn(p);
                    }

                    if(!arena.matchOngoing()){
                        Team winner = arena.winner();
                        view.showWinner(winner);
                        break gameloop;
                    }
                }
            }
            int round = arena.nextRound();
            view.showRound(round);
        }
    }

}
