package game.components;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.TransformComponent;
import com.almasb.fxgl.entity.components.ViewComponent;

import javafx.scene.input.MouseEvent;

public class NobleComponent extends Component{
	private static boolean[] grid = new boolean[5];
	private TransformComponent position;
	private ViewComponent view;
	private int gridX;
	
	 @Override
	  public void onAdded() {
		 view.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> pop());
		 view.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, e -> restore());
		 for (int i = 0; i < grid.length; i++) {
		        if (!grid[i]) {
		        	gridX = i;
		          grid[i] = true;
		          break;
		        }
		      }
		 
		 position.setPosition(620+138*gridX, 105);
	 }
	 
	private void pop(){
		    position.setScaleX(0.18);
		    position.setScaleY(0.18);
		  }

	private void restore(){
		    position.setScaleX(0.15);
		    position.setScaleY(0.15);
		  }
}
