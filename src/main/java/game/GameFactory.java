package game;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.Spawns;
import game.components.CardComponent;

public class GameFactory implements EntityFactory {

  @Spawns("card")

  public Entity newCard(){
    return FXGL.entityBuilder()
        .at(100,100)
        .view("sample.png")
        .with(new CardComponent())
        .build();
  }
}
