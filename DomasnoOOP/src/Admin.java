import java.util.List;

public class Admin extends User {

	Admin(String name, int age) {
		super(name, age);
	}

	@Override
	void print() {
		System.out.println(name + ", admin");

	}
	
	public static Admin find(List<User> users, String name) {
		for(User user: users) {
				if (user instanceof Admin && user.name == name) {
				return (Admin) user;
			}
		}
		return null;
	}

}
