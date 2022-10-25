package game.components;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.components.TransformComponent;
import com.almasb.fxgl.entity.components.ViewComponent;
import game.GameApp;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class LevelThreeCardComponent extends CardComponent {
  private static boolean grid[] = new boolean[4];

  private ViewComponent view;
  private TransformComponent position;
  private boolean moving = false;

  private boolean adding = false;
  private int gridX;
  private boolean purchased = false;

  @Override
  public void onAdded() {
    view.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> trigger());
    view.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> pop());
    view.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, e -> restore());
    adding = true;
    for (int i = 0; i < grid.length; i++) {
      if (!grid[i]) {
        gridX = i;
        grid[i] = true;
        break;
      }
    }
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

  public void trigger() {
    if (!purchased) {
      Button button = new Button("Buy");
      button.setTranslateX(800);
      button.setTranslateY(800);
      button.setOnAction(e -> {
        cardAnimation();
        button.setVisible(false);
        grid[gridX] = false;
        FXGL.<GameApp>getAppCast().addLevelThreeCard();
      });
      FXGL.getGameScene().addUINode(button);
    }
  }
  public void cardAnimation(){
    moving = true;
    purchased = true;
  }
}

