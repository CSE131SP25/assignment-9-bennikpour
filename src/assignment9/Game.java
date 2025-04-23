package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Snake snake;
    private Food food;
  
    
	public Game() {
		StdDraw.enableDoubleBuffering();
		snake = new Snake();
	    food = new Food();
		//FIXME - construct new Snake and Food objects
	}
	
	public void play() {
		StdDraw.clear();
	    StdDraw.text(0.5, 0.7, "SNAKE GAME");
	    StdDraw.text(0.5, 0.5, "Press WASD to start");
	    StdDraw.show();

	    // Wait for a key press to start the game
	    while (!StdDraw.hasNextKeyTyped()) {
	        // Wait for a key press
	    }

	    
		while (snake.isInbounds()) { //TODO: Update this condition to check if snake is in bounds
			int dir = getKeypress(); //obtains user input
			
			 if (dir != -1) {// if direction isn't -1
	                snake.changeDirection(dir);// change direction
	            }

	            snake.move();// updates the position of the snake based on the current direction
	            if (snake.eatFood(food)) { // if snake eats the food
	           
	                food = new Food(); // Generate new food after being eaten
	            }
	            updateDrawing(); //updates screen
	            StdDraw.pause(50);
	           
	            StdDraw.show(); // shows screen
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
		}
		StdDraw.clear();
		//String s=Integer.toString(score);
		StdDraw.text(0.5, 0.5, "Game Over!");
		System.out.println("Game Over!");
		StdDraw.show();
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		//FIXME
		StdDraw.clear();
        snake.draw();
        food.draw();
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}