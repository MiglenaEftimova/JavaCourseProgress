import org.junit.jupiter.api.Test;

class simpleTest {

	@Test
	void testAddStudent() {
		SocialNetwork sn = new SocialNetwork();
		sn.AddStudent("Simple Student", 40, 123);
		sn.print();
	}

	@Test
	void testAddLecturer() {
		SocialNetwork sn = new SocialNetwork();
		sn.AddLecturer("Advanced Lecturer", 90);
		sn.print();
	}

	@Test
	void testAddAdmin() {
		SocialNetwork sn = new SocialNetwork();
		sn.AddAdmin("Mega Admin", 980);
		sn.print();
	}

}