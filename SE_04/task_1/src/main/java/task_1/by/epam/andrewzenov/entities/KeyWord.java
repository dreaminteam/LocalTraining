package task_1.by.epam.andrewzenov.entities;

public class KeyWord {

	private String keyWord;
	private int quantity;

	public KeyWord(String keyWord, int quantity) {
		this.keyWord = keyWord;
		this.quantity = quantity;
	}


	public String getKeyWord() {
		return keyWord;
	}

	public int getQuantity() {
		return quantity;
	}


	@Override
	public String toString() {
		return String.format("%s(%s)", keyWord,quantity);
	}
	
	

}
