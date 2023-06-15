package snakeandladder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Player {
    String name;
    int currPos;

    public Player(String name) {
        this.name = name;
        this.currPos = 0;
    }
}
