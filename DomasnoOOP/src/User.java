import java.util.ArrayList;

public abstract class User {
	//enum Title { TEACHER, STUDENT, ADMIN };

	String name;
	int age;
	//Title title;

	User(String name, int age)//, Title title)
	{
		this.name = name;
		this.age = age;
		//this.title = title;
	}
	abstract void print();

	static String gradesToString(ArrayList<Integer> grades) {
		String result = null;
		for (Integer grade : grades) {
			if (result == null) {
				result = grade.toString();
			} else {
				result += " " + grade.toString();
			}
		}
		return result;
	}

	static String subjectsToString(ArrayList<String> subjects) {
		String result = null;
		for (String subject : subjects) {
			if (result == null) {
				result = subject.toString();
			} else {
				result += ", " + subject.toString();
			}
		}
		return result;
	}

}
