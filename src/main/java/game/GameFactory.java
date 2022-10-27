package game;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import game.components.CardComponent;
import game.components.NobleComponent;

public class GameFactory implements EntityFactory {

  private String levelOne = "level_one";
  private String levelTwo = "level_two";
  private String levelThree = "level_three";
  
  public Entity newLevelOneCard(int i){
    return FXGL.entityBuilder()
        .at(410, 665)
        .view(levelOne+i+".png")
        .scale(0.15, 0.15)
        .with(new CardComponent(Level.ONE))
        .build();
  }

  public Entity newLevelTwoCard(int i){
    return FXGL.entityBuilder()
        .at(410, 460)
        .view(levelTwo+i+".png")
        .scale(0.15, 0.15)
        .with(new CardComponent(Level.TWO))
        .build();
  }

  public Entity newLevelThreeCard(int i){
    return FXGL.entityBuilder()
        .at(410, 255)
        .view(levelThree+i+".png")
        .scale(0.15, 0.15)
        .with(new CardComponent(Level.THREE))
        .build();
  }

  public Entity levelThree(){
    return FXGL.entityBuilder()
        .at(410, 255)
        .view("level_three.png")
        .scale(0.15, 0.15)
        .build();
  }

  public Entity levelTwo(){
    return FXGL.entityBuilder()
        .at(410, 460)
        .view("level_two.png")
        .scale(0.15, 0.15)
        .build();
  }

  public Entity levelOne(){
    return FXGL.entityBuilder()
        .at(410, 665)
        .view("level_one.png")
        .scale(0.15, 0.15)
        .build();
  }
  
  public Entity newNoble(int i) {
	  return FXGL.entityBuilder()
		 .view("noble"+i+".png")
		 .with(new NobleComponent())
		 .scale(0.15, 0.15)
		 .build();
  }
  public Entity buildMat() {
    return FXGL.entityBuilder()
        .at(400,100)
        .view("mat.png")
        .scale(0.6, 0.6)
        .build();
  }

  public Entity buildBackground() {
    return FXGL.entityBuilder()
        .at(0,0)
        .view("background.png")
        .scale(1, 1)
        .build();
  }

}
