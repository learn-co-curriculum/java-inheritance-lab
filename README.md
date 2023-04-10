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

## `TrueFalseQuestion`

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


Edit the Junit class named `QuestionTest` in the directory `src\test\java`.
Add the two test methods `trueFalseQuestion1` and `trueFalseQuestion2` as shown
below.

```java
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void trueFalseQuestion1() {
        String expectedOutput = "NFL refs receive Super Bowl rings. (2 points)\n" +
                "(1) True\n" +
                "(2) False\n";

        TrueFalseQuestion q = new TrueFalseQuestion();
        q.setText("NFL refs receive Super Bowl rings.");
        q.setPoints(2);
        q.displayQuestion();

        //compare expected output with actual output
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    void trueFalseQuestion2() {
        String expectedOutput = "Olympic gold metals are made of silver. (3 points)\n" +
                "(1) True\n" +
                "(2) False\n";

        TrueFalseQuestion q = new TrueFalseQuestion();
        q.setText("Olympic gold metals are made of silver.");
        q.setPoints(3);
        q.displayQuestion();

        //compare expected output with actual output
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
    
}
```

Run `QuestionTest` and confirm your output matches the exact
expected output and all tests pass.

### `MultipleChoiceQuestion`

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

Edit the Junit class named `QuestionTest` to
add the two test methods `multipleChoiceQuestion1` and `multipleChoiceQuestion2` as shown
below.

```java
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    //... setup, teardown, other test methods

    @Test
    void multipleChoiceQuestion1() {
        String expectedOutput = "Which team scored the most points in the 2018 season? (5 points)\n" +
                "(1) Patriots\n" +
                "(2) Broncos\n" +
                "(3) Browns\n" +
                "(4) Steelers\n";

        MultipleChoiceQuestion q = new MultipleChoiceQuestion();
        q.setText("Which team scored the most points in the 2018 season?");
        q.setPoints(5);
        q.setChoices(new String[]{"Patriots", "Broncos", "Browns", "Steelers"});
        q.displayQuestion();

        //compare expected output with actual output
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    void multipleChoiceQuestion2() {
        String expectedOutput = "What sport did James Naismith invent? (10 points)\n" +
                "(1) Football\n" +
                "(2) Basketball\n" +
                "(3) Baseball\n";

        MultipleChoiceQuestion q = new MultipleChoiceQuestion();
        q.setText("What sport did James Naismith invent?");
        q.setPoints(10);
        q.setChoices(new String[]{"Football", "Basketball", "Baseball"});
        q.displayQuestion();

        //compare expected output with actual output
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}
```

Run `QuestionTest` and confirm your output matches the exact
expected output and all tests pass.

![inheritance lab junit tests pass](https://curriculum-content.s3.amazonaws.com/6677/pillars/inheritance_lab_junit.png)