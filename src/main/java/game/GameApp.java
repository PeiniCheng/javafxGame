package game;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static com.almasb.fxgl.dsl.FXGL.addUINode;
import static com.almasb.fxgl.dsl.FXGL.getAppWidth;
import static com.almasb.fxgl.dsl.FXGL.getAppHeight;
import static com.almasb.fxgl.dsl.FXGL.getGameController;
import static com.almasb.fxgl.dsl.FXGL.geti;
import static com.almasb.fxgl.dsl.FXGL.getip;
import static com.almasb.fxgl.dsl.FXGL.getop;
import static com.almasb.fxgl.dsl.FXGL.inc;

import java.util.Stack;

public class GameApp extends GameApplication {
  private GameFactory gameFactory;

  private Stack<Integer> level_one = new Stack<>();
  private Stack<Integer> level_two = new Stack<>();
  private Stack<Integer> level_three = new Stack<>();

  private static int[] level_one_list = {4,7,3,2,8,13,15,20,11};
  private static int[] level_two_list = {22,5,6,14,7,3,2,8,13,15};
  private static int[] level_three_list = {4,7,3,2,8,13,15,12,6};
  

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

    FXGL.getGameWorld().addEntities(gameFactory.buildBackground());
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
	  Text level_one_quantity = new Text();
	  level_one_quantity.setFill(Color.WHITE);
	  level_one_quantity.setFont(Font.font(50));
	  level_one_quantity.setTranslateX(450);
	  level_one_quantity.setTranslateY(getAppHeight() - 370);
	  level_one_quantity.textProperty().bind(new SimpleIntegerProperty(level_one.size()).asString());
	  addUINode(level_one_quantity);
  }

  @Override
  protected void initInput() {
	  
  }

  @Override
  protected void onUpdate(double tpf) {

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
