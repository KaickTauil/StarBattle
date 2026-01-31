package com.starbattle.factory;

import com.starbattle.model.entities.Clone;
import com.starbattle.model.entities.Jedi;
import com.starbattle.model.entities.Player;
import com.starbattle.model.entities.Team;
import com.starbattle.model.entities.Wookie;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class PlayerFactory {
    private static final Map<PlayerClass , BiFunction<String, Team, Player>> registry = new HashMap<>();

    static{
        registry.put(PlayerClass.JEDI, Jedi::new);
        registry.put(PlayerClass.WOOKIE, Wookie::new);
        registry.put(PlayerClass.CLONE, Clone::new);
    }

    public static Player create(PlayerClass type, String name, Team team){
        BiFunction<String, Team, Player> creator = registry.get(type);

        if(creator == null){
            throw new IllegalArgumentException("A classe "+ type+" não existe");
        }

        return creator.apply(name, team);
    }
}
