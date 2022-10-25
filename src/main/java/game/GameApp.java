package game;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;

public class GameApp extends GameApplication {
  private GameFactory gameFactory;
  @Override
  protected void initSettings(GameSettings settings){
    settings.setWidth(1280);
    settings.setHeight(720);
  }

  @Override
  protected void initGame() {
    gameFactory = new GameFactory();
    FXGL.getGameWorld().addEntities(gameFactory.buildBackground());
    FXGL.getGameWorld().addEntity(gameFactory.newRedCard());
    FXGL.getGameWorld().addEntity(gameFactory.newRedCard());
    FXGL.getGameWorld().addEntity(gameFactory.newBlueCard());
    FXGL.getGameWorld().addEntity(gameFactory.newBlueCard());
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

}
