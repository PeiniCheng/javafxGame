package game.components;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.TransformComponent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import com.almasb.fxgl.entity.components.ViewComponent;

public class CardComponent extends Component {
  private ViewComponent view;
  private TransformComponent position;

  private static boolean grid[] = new boolean[4];
  private int speed = 30;
  private boolean moving = false;

  private boolean purchased = false;

  @Override
  public void onUpdate(double tpf) {
    if (!moving)
      return;

    double diff = 500 - position.getY();

    if (diff > 0) {
      speed *= 0.97;
      position.translateY(speed);
    } else {
      moving = false;
      view.setVisible(false);
    }
  }

  @Override
  public void onAdded() {
    view.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> trigger());
    for(int i = 0; i < grid.length; i++){
        if (!grid[i]){
          position.setPosition(270+116*i, 190);
          grid[i] = true;
          break;
      }
    }
  }

  public void trigger() {
    if(!purchased) {
      Button button = new Button("Buy");
      button.setTranslateX(600);
      button.setTranslateY(500);
      button.setOnAction(e -> {
        cardAnimation();
        button.setVisible(false);
      });
      FXGL.getGameScene().addUINode(button);
    }
  }

  public void cardAnimation(){
    moving = true;
    purchased = true;
    }
  }

