package game;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;

public class GameApp extends GameApplication {
  private GameFactory gameFactory;

  private int[] level_one = {1,2,1,1,2,1,1,2,2,2};
  private int[] level_two = {1,2,1,1,2,1,1,2,2,2};
  private int[] level_three = {1,2,1,1,2,1,1,2,2,2};

  @Override
  protected void initSettings(GameSettings settings){
    settings.setWidth(1920);
    settings.setHeight(1080);
  }

  @Override
  protected void initGame() {
    gameFactory = new GameFactory();
    FXGL.getGameWorld().addEntities(gameFactory.buildBackground());
    FXGL.getGameWorld().addEntities(gameFactory.levelThree());
    FXGL.getGameWorld().addEntity(gameFactory.newLevelTwoCard());
    FXGL.getGameWorld().addEntity(gameFactory.newLevelTwoCard());
    FXGL.getGameWorld().addEntity(gameFactory.newLevelThreeCard());
    FXGL.getGameWorld().addEntity(gameFactory.newLevelThreeCard());
  }

  @Override
  protected void initUI() {

  }

  @Override
  protected void initInput() {

  }

  public static void main(String[] args){
    launch(args);
  }

  public void addLevelThreeCard(){
    FXGL.getGameWorld().addEntity(gameFactory.newLevelThreeCard());
  }

  public void addLevelTwoCard(){
    FXGL.getGameWorld().addEntity(gameFactory.newLevelTwoCard());
  }
}
