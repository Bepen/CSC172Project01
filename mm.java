/*
Bepen Neupane
Lab: Tuesday & Thursday 4:50-6:05
Project 1 - Master Mind
bneupane@u.rochester.edu
*/

public class mm implements MMInterface {
	public ListLinked<String[]> listOfStringArrays;
	public boolean win;
	public int colorsCorrect;
	public int positionsCorrect;

	public mm(String[] tokencolors, int positions) { // constructor
		listOfStringArrays = new ListLinked<String[]>();
	}

	@Override
	public void response(int colorsRightPositionWrong, int positionsAndColorRight) { // based on the response, arrays will be either kept or deleted from the list
		colorsCorrect = colorsRightPositionWrong; // used to compare counters for correct colors
		positionsCorrect = positionsAndColorRight; // used to compare counters for correct positions
		for (int i = 1; i < listOfStringArrays.getLength(); i++) {
			if (!codeSort(listOfStringArrays.firstArray(), listOfStringArrays.get(i))) {
				listOfStringArrays.delete(listOfStringArrays.get(i));
				i -= 1;
			}
		}
	}


	@Override
	public String[] nextMove() { // first array is returned
		return listOfStringArrays.firstArray();
	}

	public void removeFirstArray() { // gets the first array and deletes it
		listOfStringArrays.delete(listOfStringArrays.firstArray());
	}

	public boolean codeSort(String[] firstArray, String[] arrayBeingCompared) { // compares arrays to see if the code is a possible
																				//code depending on how the user answered when asked the questions
		int colorsCorrectCount = 0;
		int positionsCorrectCount = 0;
		for (int i = 0; i < firstArray.length; i++) {
			if (firstArray[i].equals(arrayBeingCompared[i])) {
				positionsCorrectCount++;
			} else {
				for (int s = 0; s < firstArray.length; s++) {
					if (firstArray[s].equals(arrayBeingCompared[i])) {
						colorsCorrectCount++;
						break;
					}
				}
			}
		}
		if ((positionsCorrectCount != positionsCorrect)
				|| (colorsCorrect != colorsCorrectCount)) 
				{
			return false;
		}

		return true;
	}

	public void printArray(String[] array) { // prints the array
		for (int i = 0; i < array.length; i++) {
			if (i < array.length - 1) {
				System.out.print(array[i] + " ");
			} else {
				System.out.print(array[i]);
			}
		}
		System.out.println();
	}

	@Override
	public void newGame(String[] tokens, int positions) { // fills the list with arrays that contain the different possible combinations of the tokens
		win = false;
		if (positions == 1) {
			for (int a = 0; a < tokens.length; a++) {
				String[] array = new String[positions];
				array[0] = tokens[a];
				listOfStringArrays.insert(array);
			}

		} else if (positions == 2) {
			for (int a = 0; a < tokens.length; a++) {
				for (int b = 0; b < tokens.length; b++) {
					String[] array = new String[positions];
					array[0] = tokens[a];
					array[1] = tokens[b];
					listOfStringArrays.insert(array);
				}
			}

		} else if (positions == 3) {
			for (int a = 0; a < tokens.length; a++) {
				for (int b = 0; b < tokens.length; b++) {
					for (int c = 0; c < tokens.length; c++) {
						String[] array = new String[positions];
						array[0] = tokens[a];
						array[1] = tokens[b];
						array[2] = tokens[c];
						listOfStringArrays.insert(array);
					}
				}
			}

		} else if (positions == 4) {
			for (int a = 0; a < tokens.length; a++) {
				for (int b = 0; b < tokens.length; b++) {
					for (int c = 0; c < tokens.length; c++) {
						for (int d = 0; d < tokens.length; d++) {
							String[] array = new String[positions];
							array[0] = tokens[a];
							array[1] = tokens[b];
							array[2] = tokens[c];
							array[3] = tokens[d];
							listOfStringArrays.insert(array);
						}
					}
				}
			}
		} else if (positions == 5) {
			for (int a = 0; a < tokens.length; a++) {
				for (int b = 0; b < tokens.length; b++) {
					for (int c = 0; c < tokens.length; c++) {
						for (int d = 0; d < tokens.length; d++) {
							for (int e = 0; e < tokens.length; e++) {
								String[] array = new String[positions];
								array[0] = tokens[a];
								array[1] = tokens[b];
								array[2] = tokens[c];
								array[3] = tokens[d];
								array[4] = tokens[e];
								listOfStringArrays.insert(array);
							}
						}
					}
				}
			}

		} else if (positions == 6) {
			for (int a = 0; a < tokens.length; a++) {
				for (int b = 0; b < tokens.length; b++) {
					for (int c = 0; c < tokens.length; c++) {
						for (int d = 0; d < tokens.length; d++) {
							for (int e = 0; e < tokens.length; e++) {
								for (int f = 0; f < tokens.length; f++) {
									String[] array = new String[positions];
									array[0] = tokens[a];
									array[1] = tokens[b];
									array[2] = tokens[c];
									array[3] = tokens[d];
									array[4] = tokens[e];
									array[5] = tokens[f];
									listOfStringArrays.insert(array);
								}
							}
						}
					}
				}
			}
		}
	}
}
