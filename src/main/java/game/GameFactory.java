package game;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.Spawns;
import game.components.CardComponent;
import game.components.LevelThreeCardComponent;
import game.components.LevelTwoCardComponent;

public class GameFactory implements EntityFactory {

  @Spawns("card")

  public Entity newLevelTwoCard(){
    return FXGL.entityBuilder()
        .at(410, 455)
        .view("sample_red.png")
        .scale(0.15, 0.15)
        .with(new LevelTwoCardComponent())
        .build();
  }

  public Entity newLevelThreeCard(){
    return FXGL.entityBuilder()
        .at(410, 255)
        .view("sample_blue.png")
        .scale(0.15, 0.15)
        .with(new LevelThreeCardComponent())
        .build();
  }

  public Entity levelThree(){
    return FXGL.entityBuilder()
        .at(410, 255)
        .view("level_three.png")
        .scale(0.15, 0.15)
        .build();
  }

  public Entity buildBackground() {
    return FXGL.entityBuilder()
        .at(400,100)
        .view("mat.png")
        .scale(0.6, 0.6)
        .build();
  }

}
