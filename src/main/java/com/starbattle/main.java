package com.starbattle;

import com.starbattle.entities.*;
import com.starbattle.game.Arena;
import java.util.Scanner;

public class main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        Player j1 = new Jedi("kaick", Team.LIGHT);
        Player j2 = new Wookie("Chewe", Team.DARK);
        Player j3 = new Clone("Rex", Team.LIGHT);
        Player j4 = new Jedi("Anakin", Team.DARK);

        Arena arena = new Arena();

        arena.addPlayer(j3, j3.getTeam());
        arena.addPlayer(j2, j2.getTeam());
        arena.addPlayer(j1, j1.getTeam());
        arena.addPlayer(j4, j4.getTeam());

        System.out.println("============== BEM VINDOS À ARENA !! ===================");
        System.out.println("TIME DA LUZ: "+arena.getPlayers(Team.LIGHT));
        System.out.println("TIME DA LUZ: "+arena.getPlayers(Team.DARK));
        System.out.println("\n______________________________________________________________________________\n");
        
        gameloop:
        while(true){
            System.out.println("=====> ROUND "+arena.getRound());

                for(Team t : Team.values()){
                for(Player p : arena.getPlayers(t)){
                    Player target = arena.getTarget(t);
                    System.out.println("\nVEZ DO JOGADOR "+p.getName()+", seu alvo é "+target.getName()+"!!!\nO que quer fazer?\n1-Atacar\n2-Usar skill\n3- Pular vez");
                    int act = input.nextInt();
                    switch (act) {
                        case 1 -> p.attack(target);
                        case 2 -> {
                            if(p.hasSkill()){
                                p.useSkill(target);
                            }else{
                                System.out.println("SISTEMA: Ops! Você não tem nenhuma skill ativa, executando ataque normal...");
                                p.attack(target);
                            }
                        }
                        default -> System.out.println(p.getName() + ": Melhor deixar pra la...");
                    }
                    if(!arena.matchOngoing()){
                        arena.winner();
                        break gameloop;
                    }
                }
            }
            arena.nextRound();                
        }
    }
}
