package com.starbattle.view;

import com.starbattle.factory.PlayerClass;
import com.starbattle.model.abilities.SpecialSkill;
import com.starbattle.model.entities.ManaUser;
import com.starbattle.model.entities.Player;
import com.starbattle.model.entities.Team;
import java.util.Scanner;

public class GameView {
    private Scanner input = new Scanner(System.in);

    public boolean lobby(){
        System.out.println("========= BEM VINDOS À ARENA!! =========\nO que deseja fazer?\n1- Iniciar partida\n2- Sair");
        int op = Integer.parseInt(input.nextLine());

        if (op == 1) {
            System.out.println("Ótimo!! Vamos iniciar adicionando os combatentes: \n");
            return true;
        }else{
            return false;
        }     
    }
    
    public String requestName(){
        System.out.println("\n---> Insira o nome do jogador: ");
        return input.nextLine();
    }

    public Team requestTeam(){
        System.out.println("---> Insira o time do jogador ("+ Team.LIGHT.name() + " | " + Team.DARK.name() + "):");
        return Team.valueOf(input.nextLine().toUpperCase());
    }

    public PlayerClass requestClass(){
        System.out.println("Selecione a classe do jogador: (Jedi | Wookie | Clone)");
        return PlayerClass.valueOf(input.nextLine().toUpperCase());
    }

    public int secondMenu(){
        System.out.println("\nO jogador foi criado!!\n\nO que deseja fazer agora?\n1- Cadastrar novo jogador\n2- Iniciar partida\n3- Sair");
        return Integer.parseInt(input.nextLine());
    }

    public void goodbyeMessage(){
        System.out.println("Tchau tchau !!");
    }
    
    public void showRound(int round){
        System.out.println("=====> ROUND "+ round);
    }

    public void roundInit(int round){
        System.out.println("SISTEMA: Round "+round+" iniciado!");
    }

    public int getAction(Player user, Player target){
        int act;
        
        if(user.getSkills() != null){
            System.out.println("\n---> PLAYER:  "+user.getName()+"\n---> ALVO: "+target.getName()+"!!!\nO que quer fazer?\n1-Atacar\n2-Usar skill\n3- Pular vez");
            act = Integer.parseInt(input.nextLine());
        }else{
            System.out.println("\n---> PLAYER:  "+user.getName()+"\n---> ALVO: "+target.getName()+"!!!\nO que quer fazer?\n1-Atacar\n2- Pular vez");
            act = Integer.parseInt(input.nextLine());
        }
        
        return act;
    }

    public int getSkill(Player user){
        String txt = "";
        for(SpecialSkill s : user.getSkills()){
            int i = 1;
            txt = i + "- " + s.getName() + "\n";
        }
        System.out.println("Selecione a skill que deseja usar: \n"+txt);
        int i = Integer.parseInt(input.nextLine());

        return i-1;
    }

    public void attackMessage(Player user){
        user.attackDesc();
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
