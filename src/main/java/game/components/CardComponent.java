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
      position.translateX(speed*2);
      position.translateY(speed);
    } else {
      moving = false;
    }
  }

  @Override
  public void onAdded() {
    view.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> trigger());
  }

  public void trigger() {
    if(!purchased) {
      Button button = new Button("Buy");
      button.setTranslateX(600);
      button.setTranslateY(300);
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

