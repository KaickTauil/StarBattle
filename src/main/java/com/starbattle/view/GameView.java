package com.starbattle.view;

import java.util.Scanner;

import com.starbattle.factory.PlayerClass;
import com.starbattle.model.abilities.SpecialSkill;
import com.starbattle.model.entities.ManaUser;
import com.starbattle.model.entities.Player;
import com.starbattle.model.entities.Team;

public class GameView {
    private Scanner input = new Scanner(System.in);

    public boolean lobby(){
        while(true){
            System.out.println("========= BEM VINDOS À ARENA!! =========\nO que deseja fazer?\n1- Iniciar partida\n2- Sair");
            try {
                int op = Integer.parseInt(input.nextLine());

                if (op == 1) {
                    System.out.println("Ótimo!! Vamos iniciar adicionando os combatentes: ");
                    return true;
                }else{
                    return false;
                }
            } catch (NumberFormatException e) {
                System.out.println("##################### Informe um valor numérico válido #####################");
            }
        }
    }
    
    public String requestName(){
        System.out.println("\n---> Insira o nome do jogador: ");
        return input.nextLine();
    }

    public Team requestTeam(){
        while(true){
            try {
                System.out.println("---> Insira o time do jogador ("+ Team.LIGHT.name() + " | " + Team.DARK.name() + "):");
                return Team.valueOf(input.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("##################### Informe um tipo válido de time: ("+ Team.listTeams() +") #####################");
            }
        }
    }

    public PlayerClass requestClass(){
        while (true) { 
            try {
                System.out.println("Selecione a classe do jogador: (Jedi | Wookie | Clone)");
                return PlayerClass.valueOf(input.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Informe um tipo válido de time: ("+ PlayerClass.listClasses() +")");
            }
        }
    }

    public void createdPlayerMessage(){
        System.out.println("\nO jogador foi criado!!\n");
    }

    public int secondMenu(){
        while(true){
            try {
                System.out.println("\nO que deseja fazer agora?\n1- Cadastrar novo jogador\n2- Iniciar partida\n3- Sair");
                return Integer.parseInt(input.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("##################### Informe um valor numérico válido #####################");
            }
        } 
    }

    public void goodbyeMessage(){
        System.out.println("Tchau tchau !!");
    }
    
    public void showRound(int round){
        System.out.println("\n=====> ROUND "+ round);
    }

    public void roundInit(int round){
        System.out.println("SISTEMA: Round "+round+" iniciado!");
    }

    public int getAction(Player user, Player target){
        while (true) { 
            int act;

            try {
                if(user.getSkills() != null){
                    System.out.println("\n---> PLAYER:  "+user.getName()+"\n---> ALVO: "+target.getName()+"!!!\nO que quer fazer?\n1-Atacar\n2-Usar skill\n3- Pular vez");
                    act = Integer.parseInt(input.nextLine());
                }else{
                    System.out.println("\n---> PLAYER:  "+user.getName()+"\n---> ALVO: "+target.getName()+"!!!\nO que quer fazer?\n1-Atacar\n2- Pular vez");
                    act = Integer.parseInt(input.nextLine());
                }
                return act;

            } catch (NumberFormatException e) {
                System.out.println("##################### Informe um valor numérico válido #####################");
            }
        }
    }

    public int getSkill(Player user){
       while (true) { 
            try {
                if(user instanceof ManaUser manaUser){
                    String txt = "";
                    for(SpecialSkill s : user.getSkills()){
                        int i = 1;
                        txt = i + "- " + s.getName() + "\n";
                    }
                    System.out.println("Selecione a skill que deseja usar: \n"+txt);
                    int i = Integer.parseInt(input.nextLine());

                    return i-1;
                }else{
                    System.out.println("SISTEMA: Ops... parece que você não tem nenhuma skill ativa, realizando um ataque normal !");
                    return -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("##################### Informe um valor numérico válido #####################");
            }
       }
    }

    public void attackMessage(Player user){
        System.out.println(user.attackDesc());
    }

    public void skillMessage(Player user,SpecialSkill skill,double dmg, int manaCost){
        if(!(user instanceof ManaUser manaUser)){
            System.out.println("SISTEMA: O combatente tem que ser um usuário de mana para usar isso !");
        }else if(!manaUser.hasMana(manaCost)){
            System.out.println("SISTEMA: Você não tem mana o suficiente!");
            
        }else{
            System.out.println(skill.skillDesc(user, dmg));
        }
    }

    public String skipTurn(Player user){
        return "Sistema: " + user.getName() + ": Melhor deixar para lá...";
    }

    public void damageMessage(Player reciever, double dam){
        reciever.damageDesc(dam);
    }

    public void noSkillAvaible(){
        System.out.println("SISTEMA: Eita, parece que você não tem nenhuma habilidade ativa no momento...");
    }

    public void showWinner(Team winner){
        System.out.println("O time " + winner.name() + " triunfou sobre seus inimigos !!\nA arena os consagra vencedores.");
    }
}
