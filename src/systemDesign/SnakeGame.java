package systemDesign;

import java.util.LinkedList;

public class SnakeGame {
	class Snake {
        LinkedList<Integer> coordinates;

        public Snake() {
            this.coordinates = new LinkedList<Integer>();
            this.coordinates.add(0);
        }
    }

	private int width;
	private int height;
    private int[][] food;

    private Snake snake;
    private int foodIndex;
    private int score;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
		this.width = width;
		this.height = height;
        this.food = food;

        this.snake = new Snake();
        this.foodIndex = 0;
        this.score = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int head = this.snake.coordinates.getLast();
        int row = head / this.width;
        int col = head % this.width;

        switch(direction) {
        case "U": row --;
    			  break;
        case "L": col --;
    			  break;
        case "R": col ++;
    			  break;
        case "D": row ++;
    			  break;
        }

        if(!isValid(row, col)) return -1;
        if(this.foodIndex < this.food.length && row == this.food[this.foodIndex][0] && col == this.food[this.foodIndex][1]) {
    		this.score ++;
    		this.foodIndex ++;
        }
        else {
    		this.snake.coordinates.removeFirst();
        }
    	this.snake.coordinates.add(row * this.width + col);

    	return this.score;
    }

    private boolean isValid(int row, int col) {
		int index = this.snake.coordinates.indexOf(row * this.width + col);
		return (index <= 0)
				&& row < this.height
				&& row >= 0
				&& col < this.width
				&& col >= 0;
    }
}
