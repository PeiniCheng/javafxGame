package game;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.Spawns;
import game.components.CardComponent;

public class GameFactory implements EntityFactory {

  @Spawns("card")

  public Entity newRedCard(){
    return FXGL.entityBuilder()
        .view("sample_red.png")
        .scale(0.12, 0.12)
        .with(new CardComponent())
        .build();
  }

  public Entity newBlueCard(){
    return FXGL.entityBuilder()
        .view("sample_blue.png")
        .scale(0.12, 0.12)
        .with(new CardComponent())
        .build();
  }

  public Entity buildBackground() {
    return FXGL.entityBuilder()
        .at(150,50)
        .view("mat.png")
        .scale(0.5, 0.5)
        .build();
  }

}
