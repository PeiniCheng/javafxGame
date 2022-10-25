package game.components;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.TransformComponent;
import game.GameApp;
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

  @Override
  public void onUpdate(double tpf) {

  }

  @Override
  public void onAdded() {

  }

  public void trigger() {

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
  }

