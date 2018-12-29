import java.util.ArrayList;
import java.util.List;

public class Teacher extends User {
	ArrayList<String> subjects;

	public Teacher(String name, int age) {
		super(name,age);
		this.subjects = new ArrayList<String>();
	}

	public void teachSubject(String subject) {
		subjects.add(subject);
	}

	public static Teacher find(List<User> users, String name) {
		for(User user: users) {
		//	if (user.title == User.Title.TEACHER)
			if (user instanceof Teacher && user.name == name) {
				return (Teacher) user;
			}
		}
		return null;
	}

	public static Teacher findBySubject(List<User> users, String subject) {
		for(User user: users) {
		//	if (user.title == User.Title.TEACHER)
			if (user instanceof Teacher) {
				Teacher teacher = (Teacher) user;
				if (teacher.subjects.contains(subject)) return teacher;
			}
		}
		return null;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println(name + ",lecturer, Subjects: " + subjectsToString(subjects));


	}

}
