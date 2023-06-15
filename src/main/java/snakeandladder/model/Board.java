package snakeandladder.model;

import lombok.Getter;
import lombok.Setter;
import snakeandladder.model.specialentity.Entity;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Board {
    //This holds the number of rows. Total cells would be size * size
    int size;
    //Holds the list of snake and ladders
    Map<Integer, Entity> specialEntities;

    public Board(int size) {
        this.size = size;
        specialEntities = new HashMap<>();
    }

    public void addSpecialEntity(Entity entity) throws Exception {
        if (specialEntities.containsKey(entity.getStart()))
            throw new Exception("Two entities cannot be there in one cell. Please update the places.");

        specialEntities.put(entity.getStart(), entity);
    }

    public boolean specialEntityPresent(int pos) throws Exception {
        if (pos > size * size)
            throw new Exception("Invalid position");

        return specialEntities.containsKey(pos);
    }

    public Entity getEntityAtPos(int pos) {
        return specialEntities.get(pos);
    }
}
