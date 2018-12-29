import java.util.ArrayList;
import java.util.List;

public class Student extends User {
	ArrayList<Integer> grades;
	int fNum;
	ArrayList<String> subjects;
	Student(String name, int age, int fNum) {
		//super(name,age, Title.STUDENT);
		super(name,age);
		this.grades = new ArrayList<Integer>();
		this.fNum = fNum;
		this.subjects = new ArrayList<String>();

	}
	public void learnSubject(String subject) {
		subjects.add(subject);
	}
	public void haveGrade(Integer grade) throws Exception {
		if (grade < 2 || grade >6) {
			throw new Exception ("Grade must be in interval from 2 to 6 ");
		}
		grades.add(grade);
	}

	public static Student find(List<User> users, String name) {
		for(User user: users) {
			if (user instanceof Student && user.name == name) {
				return (Student) user;
			}
		}
		return null;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println(name + ",student, grades: " + gradesToString(grades) + ", Subjects: " + subjectsToString(subjects));

	}

}
