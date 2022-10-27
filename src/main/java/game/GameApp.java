package game;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.core.collection.PropertyMap;
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

import java.util.Map;
import java.util.Stack;

public class GameApp extends GameApplication {
  private GameFactory gameFactory;

  private Stack<Integer> level_one = new Stack<>();
  private Stack<Integer> level_two = new Stack<>();
  private Stack<Integer> level_three = new Stack<>();
  private Stack<Integer> nobles = new Stack<>();

  private static int[] level_one_list = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39};
  private static int[] level_two_list = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29};
  private static int[] level_three_list = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
  private static int[] noble_list = {0,1,2,3,4};
  

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
    for(int i = 0; i < noble_list.length; i++){
        nobles.push(noble_list[i]);
      }

    FXGL.getGameWorld().addEntities(gameFactory.buildBackground());
    FXGL.getGameWorld().addEntities(gameFactory.buildMat());
    FXGL.getGameWorld().addEntities(gameFactory.levelOne());
    FXGL.getGameWorld().addEntities(gameFactory.levelTwo());
    FXGL.getGameWorld().addEntities(gameFactory.levelThree());
    for(int i = 0; i < 4; i++) {
      addLevelOneCard();
      addLevelTwoCard();
      addLevelThreeCard();
    }
    for(int i = 0; i < 5; i++) {
      FXGL.getGameWorld().addEntity(gameFactory.newNoble(nobles.pop()));
    }
  }

  @Override
  protected void initUI() {
	  Text level_one_quantity = new Text();
	  level_one_quantity.setFill(Color.WHITE);
	  level_one_quantity.setFont(Font.font(50));
	  level_one_quantity.setTranslateX(450);
	  level_one_quantity.setTranslateY(getAppHeight() - 370);
	  level_one_quantity.textProperty().bind(getip("level_one_quantity").asString());
	  addUINode(level_one_quantity);
	  Text level_two_quantity = new Text();
	  level_two_quantity.setFill(Color.WHITE);
	  level_two_quantity.setFont(Font.font(50));
	  level_two_quantity.setTranslateX(450);
	  level_two_quantity.setTranslateY(getAppHeight() - 575);
	  level_two_quantity.textProperty().bind(getip("level_two_quantity").asString());
	  addUINode(level_two_quantity);
	  Text level_three_quantity = new Text();
	  level_three_quantity.setFill(Color.WHITE);
	  level_three_quantity.setFont(Font.font(50));
	  level_three_quantity.setTranslateX(450);
	  level_three_quantity.setTranslateY(getAppHeight() - 780);
	  level_three_quantity.textProperty().bind(getip("level_three_quantity").asString());
	  addUINode(level_three_quantity);
  }

  @Override
  protected void initInput() {
	  
  }
  
  @Override
  protected void initGameVars(Map<String, Object> vars) {
      vars.put("level_one_quantity", 40);
      vars.put("level_two_quantity", 30);
      vars.put("level_three_quantity", 20);
  }

  @Override
  protected void onUpdate(double tpf) {
	  PropertyMap state = FXGL.getWorldProperties();
	  state.setValue("level_three_quantity", level_three.size());
	  state.setValue("level_two_quantity", level_two.size());
	  state.setValue("level_one_quantity", level_one.size());
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
