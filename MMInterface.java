/*
Bepen Neupane
Lab: Tuesday & Thursday 4:50-6:05
Project 1 - Master Mind
bneupane@u.rochester.edu
*/

public interface MMInterface { // interface for master mind
	public void response(int colorsRightPositionWrong, int positionsAndColorRight);
	public void newGame(String[] tokens, int positions);
	public String[] nextMove();
}
