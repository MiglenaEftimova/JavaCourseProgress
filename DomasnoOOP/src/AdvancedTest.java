import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AdvancedTest {

	@Test
	void setup() throws Exception {
		System.out.println("Social Network setup");
		SocialNetwork sn = new SocialNetwork();
		sn.AddStudent("Studentcho", 40, 123);
		sn.AddStudent("Studentka", 23, 69);
		sn.AddLecturer("Elka", 60);
		sn.AddLecturer("Newtona", 90);
		sn.AddAdmin("Master", 980);

		System.out.println("\nSocial Network positive test");
		sn.AddSubject("Math", "Elka");
		sn.AddSubject("Physics", "Newtona");

		assertTrue(sn.StudySubject("Studentcho", "Math"));
		assertTrue(sn.StudySubject("Studentcho", "Physics"));
		assertTrue(sn.StudySubject("Studentka", "Physics"));

		assertTrue(sn.AddGrade("Elka", "Studentcho", "Math", 6));
		assertTrue(sn.AddGrade("Elka", "Studentcho", "Math", 5));
		assertTrue(sn.AddGrade("Newtona", "Studentcho", "Physics", 2));
		assertTrue(sn.AddGrade("Newtona", "Studentka", "Physics", 4));

		System.out.println("Social Network positive test result\n");
		sn.print();

		System.out.println("\nSocial Network negative test");
		try {
			sn.AddSubject("Math", "Unknown Teacher");
			fail("Exception expected but not caught");
		} catch (Exception e) {
			System.out.println("Expected exception caught: " + e.getMessage());
		}
		assertFalse(sn.StudySubject("Studentka", "Unknown Subject"));
		assertFalse(sn.StudySubject("Unknown Student", "Unknown Subject"));
		assertFalse(sn.StudySubject("Unknown Student", "Math"));

		assertFalse(sn.AddGrade("Elka", "Studentcho", "Math", 1));
		assertFalse(sn.AddGrade("Elka", "Studentcho", "Math", 7));
		assertFalse(sn.AddGrade("Newtona", "Studentcho", "Math", 2));
		assertFalse(sn.AddGrade("Elka", "Studentcho", "Physics", 5));
		assertFalse(sn.AddGrade("Elka", "Studentka", "Math", 3));
		assertFalse(sn.AddGrade("Unknown Teacher", "Unknown Student", "Unknown Subject", 4));

		System.out.println("Social Network negative test result\n");
		sn.print();

	}

}
