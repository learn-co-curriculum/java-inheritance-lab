# Inheritance Lab

## Learning Goals

- Use inheritance to extend a class.
- Override an inherited method.
- Call a superclass method from a subclass.

## Instructions.

Fork and clone this lesson to get the starter code.

Do not alter the `Question` class.

You will implement the following class hierarchy that represents questions on a written quiz or exam:

![task2 uml](https://curriculum-content.s3.amazonaws.com/6677/pillars/task2_uml.png)

The starter code contains the class named `Question` with the fields `text` (contains the actual question)
and `points` (number of points the question is worth), get/set methods,
and the default implementation of `displayQuestion` (prints the question text and points).

```java
public class Question {
	private String text;
	private int points;

	public void setText(String text) {this.text = text;}

	public void setPoints(int points) {this.points = points;}

	public void displayQuestion() {
		System.out.println(text + " ("+points+" points)");
	}
	
}
```

The `Main` creates a sample question and displays it:

```java
public class Main {
	public static void main(String []args)  {
		Question q1 = new Question();
		q1.setText("Which sport has been played on the moon?");
		q1.setPoints(7);
		q1.displayQuestion();
	}
}
```

Run `Main` to confirm the output:

```text
Which sport has been played on the moon? (7 points)
```

Create a subclass of `Question` named `TrueFalseQuestion`.
The `TrueFalseQuestion` class should override the `displayQuestion()` method using the following logic:

- Call the superclass `displayQuestion()` method to print the question text and points on one line.
- Add two additional print statements to print true and false choices on separate lines as shown:

```text
NFL refs receive Super Bowl rings. (2 points)
(1) True
(2) False
```

Edit `Main` to create two `TrueFalseQuestion` instances as shown:

```java
public class Main {
    public static void main(String[] args) {
        Question q1 = new Question();
        q1.setText("Which sport has been played on the moon?");
        q1.setPoints(7);
        q1.displayQuestion();

        System.out.println();
        TrueFalseQuestion q2 = new TrueFalseQuestion();
        q2.setText("NFL refs receive Super Bowl rings.");
        q2.setPoints(2);
        q2.displayQuestion();

        System.out.println();
        TrueFalseQuestion q3 = new TrueFalseQuestion();
        q3.setText("Olympic gold metals are made of silver.");
        q3.setPoints(3);
        q3.displayQuestion();
    }
}
```

Confirm the output:

```text
Which sport has been played on the moon? (7 points)

NFL refs receive Super Bowl rings. (2 points)
(1) True
(2) False

Olympic gold metals are made of silver. (3 points)
(1) True
(2) False
```

Create a subclass of `Question` named `MultipleChoiceQuestion`.

- Add an instance variable named `choices` that stores an array of strings representing the multiple choices. Add set/get methods for `choices`.
- Override the `displayQuestion()` method with the following logic:
    - Call the superclass `displayQuestion()` method to print the question text and points on one line
    - Use a loop to print each array element as a numbered choice on a separate line as shown:

```text
Which team scored the most points in the 2018 season? (5 points)
(1) Patriots
(2) Broncos
(3) Browns
(4) Steelers
```

Edit `Main` to create two `MultipleChoiceQuestion` objects and display as shown:

```java
public class Main {
	public static void main(String []args)  {
		Question q1 = new Question();
		q1.setText("Which sport has been played on the moon?");
		q1.setPoints(7);
		q1.displayQuestion();

		System.out.println();
		TrueFalseQuestion q2 = new TrueFalseQuestion();
		q2.setText("NFL refs receive Super Bowl rings.");
		q2.setPoints(2);
		q2.displayQuestion();

		System.out.println();
		TrueFalseQuestion q3 = new TrueFalseQuestion();
		q3.setText("Olympic gold metals are made of silver.");
		q3.setPoints(3);
		q3.displayQuestion();

		System.out.println();
		MultipleChoiceQuestion q4 = new MultipleChoiceQuestion();
		q4.setText("Which team scored the most points in the 2018 season?");
		q4.setPoints(5);
		q4.setChoices(new String[]{"Patriots", "Broncos", "Browns", "Steelers"});
		q4.displayQuestion();

		System.out.println();
		MultipleChoiceQuestion q5 = new MultipleChoiceQuestion();
		q5.setText("What sport did James Naismith invent?");
		q5.setPoints(10);
		q5.setChoices(new String[]{"Football", "Basketball", "Baseball"});
		q5.displayQuestion();
	}
}
```

Confirm the output:

```text
Which sport has been played on the moon? (7 points)

NFL refs receive Super Bowl rings. (2 points)
(1) True
(2) False

Olympic gold metals are made of silver. (3 points)
(1) True
(2) False

Which team scored the most points in the 2018 season? (5 points)
(1) Patriots
(2) Broncos
(3) Browns
(4) Steelers

What sport did James Naismith invent? (10 points)
(1) Football
(2) Basketball
(3) Baseball
```
