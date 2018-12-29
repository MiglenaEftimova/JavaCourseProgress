import java.util.ArrayList;

public class SocialNetwork {
	ArrayList<User> users;

	public SocialNetwork() {
		users = new ArrayList<User>();
	}

	public void AddStudent(String name, int age, int fn) {
		User student = new Student(name, age, fn);
		users.add(student);
	}
	public void AddLecturer(String name, int age) {
		User teacher = new Teacher(name, age);
		users.add(teacher);
	}
	public void AddAdmin(String name, int age) {
		User admin = new Admin(name, age);
		users.add(admin);
	}
	public void AddSubject(String subject, String lec) throws Exception {
		Teacher teacher = Teacher.find(users, lec);
		if (teacher == null)
			throw new Exception("Teacher " + lec + " not found");
		teacher.teachSubject(subject);
	}

	public boolean StudySubject(String stud, String subject) {
		Student student = Student.find(users, stud);
		if (student == null)
			return false;
		Teacher teacher = Teacher.findBySubject(users, subject);
		if (teacher == null)
			return false;

		student.learnSubject(subject);
		return true;
	}

	public boolean AddGrade(String lec, String stud, String subject, int grade) throws Exception {
		Teacher teacher = Teacher.find(users, lec);
		if (teacher == null)
			return false;
		Student student = Student.find(users, stud);
		if (student == null)
			return false;
		if (student.subjects.contains(subject) &&
				teacher.subjects.contains(subject) &&
				(grade>=2 && grade<= 6)) {
			student.haveGrade(grade);
			return true;
		} else
			return false;
	}

	public void print() {
		for (User user : users) {
			user.print();
		}
	}

	public void RemoveUser(String adm, String name) throws Exception {
		Admin admin = Admin.find(users, adm);
		if (admin == null) {
			throw new Exception ("Admin " + adm +" not found" );
		}
		User user = Student.find(users, name);
		if (user == null)
			user = Teacher.find(users, name);
		if (user == null) {
			throw new Exception ("User " + name + " not found");
		}
		users.remove(user);
	}
}
