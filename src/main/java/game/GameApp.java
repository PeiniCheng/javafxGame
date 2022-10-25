package game;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import java.util.Stack;

public class GameApp extends GameApplication {
  private GameFactory gameFactory;

  private Stack<Integer> level_one = new Stack<>();
  private Stack<Integer> level_two = new Stack<>();
  private Stack<Integer> level_three = new Stack<>();

  private static int[] level_one_list = {1,0,0,0,1,1,0,1,1,1};
  private static int[] level_two_list = {1,0,0,0,1,1,0,1,0,0};
  private static int[] level_three_list = {1,0,0,0,1,1,0,0,0,1};

  @Override
  protected void initSettings(GameSettings settings){
    settings.setWidth(1920);
    settings.setHeight(1080);
  }

  @Override
  protected void initGame() {
    gameFactory = new GameFactory();
    for(int i = 0; i < level_one_list.length; i++){
      level_one.push(level_one_list[i]);
    }
    for(int i = 0; i < level_two_list.length; i++){
      level_two.push(level_two_list[i]);
    }
    for(int i = 0; i < level_three_list.length; i++){
      level_three.push(level_three_list[i]);
    }
    FXGL.getGameWorld().addEntities(gameFactory.buildMat());
    FXGL.getGameWorld().addEntities(gameFactory.levelOne());
    FXGL.getGameWorld().addEntities(gameFactory.levelTwo());
    FXGL.getGameWorld().addEntities(gameFactory.levelThree());
    for(int i = 0; i < 4; i++) {
      FXGL.getGameWorld().addEntity(gameFactory.newLevelOneCard(level_one.pop()));
      FXGL.getGameWorld().addEntity(gameFactory.newLevelTwoCard(level_two.pop()));
      FXGL.getGameWorld().addEntity(gameFactory.newLevelThreeCard(level_three.pop()));
    }
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
    if(!level_three.empty()) FXGL.getGameWorld().addEntity(gameFactory.newLevelThreeCard(level_three.pop()));
  }

  public void addLevelTwoCard(){
    if(!level_two.empty()) FXGL.getGameWorld().addEntity(gameFactory.newLevelTwoCard(level_two.pop()));
  }

  public void addLevelOneCard(){
    if(!level_one.empty()) FXGL.getGameWorld().addEntity(gameFactory.newLevelOneCard(level_one.pop()));
  }
}
