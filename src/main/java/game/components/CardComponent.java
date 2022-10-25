package game.components;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.TransformComponent;
import game.GameApp;
import game.Level;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import com.almasb.fxgl.entity.components.ViewComponent;

public class CardComponent extends Component {
  private ViewComponent view;
  private TransformComponent position;
  private boolean moving = false;

  private boolean adding = false;
  private int gridX;
  private boolean purchased = false;

  private static boolean[] level_one_grid = new boolean[4];
  private static boolean[] level_two_grid = new boolean[4];
  private static boolean[] level_three_grid = new boolean[4];

  private Level level;

  public CardComponent(Level aLevel){
    this.level = aLevel;
  }

  @Override
  public void onUpdate(double tpf) {
    if (moving) {
      double diff = 900 - position.getY();

      if (diff > 0) {
        position.translateY(10);
      } else {
        moving = false;
        view.setVisible(false);
      }

    } else if (adding) {
      double diff = (540 + 138 * gridX) - position.getX();

      if (diff > 0) {
        position.translateX(5);
      } else {
        adding = false;
      }
    } else {
      return;
    }
  }

  @Override
  public void onAdded() {
    view.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> trigger());
    view.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> pop());
    view.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, e -> restore());
    adding = true;
    switch(level){
      case ONE:
        addToMat(level_one_grid);
        break;
      case TWO:
        addToMat(level_two_grid);
        break;
      case THREE:
        addToMat(level_three_grid);
        break;
    }
  }

  public void trigger() {
    if (!purchased) {
      Button button = new Button("Buy");
      button.setTranslateX(800);
      button.setTranslateY(800);
      button.setOnAction(e -> {
        cardAnimation();
        button.setVisible(false);
        switch(level){
          case ONE:
            level_one_grid[gridX] = false;
            FXGL.<GameApp>getAppCast().addLevelOneCard();
            break;
          case TWO:
            level_two_grid[gridX] = false;
            FXGL.<GameApp>getAppCast().addLevelTwoCard();
            break;
          case THREE:
            level_three_grid[gridX] = false;
            FXGL.<GameApp>getAppCast().addLevelThreeCard();
            break;
        }
      });
      FXGL.getGameScene().addUINode(button);
    }
  }

  public void pop(){
    position.setScaleX(0.18);
    position.setScaleY(0.18);
  }

  public void restore(){
    position.setScaleX(0.15);
    position.setScaleY(0.15);
  }

  public void cardAnimation(){
    moving = true;
    purchased = true;
    }

    private void addToMat(boolean[] aGrid){
      for (int i = 0; i < aGrid.length; i++) {
        if (!aGrid[i]) {
          gridX = i;
          aGrid[i] = true;
          break;
        }
      }
    }
  }

