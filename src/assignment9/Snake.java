package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double headX, headY; //
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		//FIXME - set up the segments instance variable
		segments = new LinkedList<>();
        segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE)); // Initial segment at center
        
		deltaX = 0;
		deltaY = 0;
		headX = segments.getFirst().getX();//
	    headY = segments.getFirst().getY();//
	}
	
	public void changeDirection(int direction) { // changes direction of snake based on the input direction by updating values of delta x and delta y 
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		 double newX = segments.getFirst().getX() + deltaX; // update x position based on current direction
	     double newY = segments.getFirst().getY() + deltaY; // update y position based on current direction

	        segments.addFirst(new BodySegment(newX, newY, SEGMENT_SIZE)); // new body segment (head) added to the front of the list
	        
	        if (!eatFood(null)) {// snake hasn't eaten food
	            segments.removeLast(); //last segment removed
	        }
	        headX = segments.getFirst().getX();// updates x position of snakes head
	        headY = segments.getFirst().getY();// updates y position of snakes head
		//FIXME
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for (BodySegment segment : segments) {
            segment.draw();
        }
		//FIXME
	}
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		//FIXME
		if (f != null) {
	        double foodX = f.getX(); // Get the x-coordinate of the food
	        double foodY = f.getY(); // Get the y-coordinate of the food

	        double distance = Math.sqrt(Math.pow(headX - foodX, 2) + Math.pow(headY - foodY, 2));
	        double minDistance = SEGMENT_SIZE * 2;
	        
	        // Check if the head of the snake is at the same position as the food
	        if (distance <= minDistance) {
	            // If the head is at the same position as the food, grow the snake
	            double tailX = segments.getLast().getX(); // Get the x-coordinate of the last segment
	            double tailY = segments.getLast().getY(); // Get the y-coordinate of the last segment

	           
	           segments.addLast(new BodySegment(headX, headY, SEGMENT_SIZE)); // Add a segment to the snake

	            
	            return true; // Snake has eaten the food
	        }
	    }
	    return false; // Snake did not eat the food
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {

        double headX = segments.getFirst().getX();
        double headY = segments.getFirst().getY();
        return headX >= 0 && headX <= 1 && headY >= 0 && headY <= 1;
    
		//FIXME
		
	}
}