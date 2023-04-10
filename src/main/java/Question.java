public class Question {
	private String text;
	private int points;

	public void setText(String text) {this.text = text;}

	public void setPoints(int points) {this.points = points;}

	public void displayQuestion() {
		System.out.println(text + " ("+points+" points)");
	}
	
}
