/**
 * 
 * @author Chris Hanson
 * @author Dana Perry
 * 
 */
package edu.worcester.cs.kwurst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.worcester.cs.kwurst.Transcript.Semester;

public class StudentTest {
	private Student student1;
	

	@Before
	public void setUp() throws Exception {
		student1 = new Student ("Jane", "Smith");
	}
	@Test
	public void testGetFirstName(){
		student1.setFirstName("Joe");
		assertEquals("Joe", student1.getFirstName());
	}
	@Test
	public void testGetLastName(){
		student1.setLastName("Shmoe");
		assertEquals("Shmoe", student1.getLastName());
	}
	@Test
	public void testGetId(){
		String currentId = student1.getId();
		Student student2 = new Student("Bob", "Clark");
		int x = Integer.parseInt(currentId);
		x = x + 1;		
		currentId = String.format("%07d",x);
		assertEquals(currentId, student2.getId());
	}
	@Test
	public void testGetStudentCount(){
		int count = Student.getStudentCount();
		Student student2 = new Student ("Bob", "Clark");
		assertEquals(count +1, Student.getStudentCount());
	}
	@Test
	public void testGetLascComplete1(){
		student1.setLascComplete(true);
		assertTrue(student1.getLascComplete());
	}
	@Test
	public void testGetLascComplete2(){
		student1.setLascComplete(false);
		assertFalse(student1.getLascComplete());
	}
    @Test
	public void testGetMajorComplete1(){
		student1.setMajorComplete(true);
		assertTrue(student1.getMajorComplete());
	}
	@Test
	public void testGetMajorComplete2(){
		student1.setMajorComplete(false);
		assertFalse(student1.getMajorComplete());
	}
	/**@Test
	public void testAddCourse(){
		Course cs = new Course("CS", 140, "Programming", 3);
		Grade g1 = new Grade("A");
		Semester s1 =(Semester.SPRING);
		student1.addCourse(cs, s1, 2015, g1);
		assertEquals("CS  140 Programming 3CR SPRING2015  A" + "\n", student1.getTranscript());
	}*/
	@Test
	public void testGetGpa(){
		Course cs = new Course("CS", 140, "Programming", 3);
		Grade grade = new Grade("A");
		Semester semester = (Semester.SPRING);
		student1.addCourse(cs, semester, 2015, grade);
		assertEquals(4.0, student1.getGpa(), 0.0);
	}
	@Test
	public void testGetCurrentEarnedCredits(){
		int credits = student1.getCurrentEarnedCr();
		Course cs = new Course("CS", 140, "Programming", 3);
		Grade grade = new Grade("A");
		Semester semester = (Semester.SPRING);
		student1.addCourse(cs, semester, 2015, grade);
		assertEquals(credits+3,student1.getCurrentEarnedCr());
	}
	@Test
	public void testGetAnticipatedAdditionalCredits(){
		int credits = student1.getCurrentEarnedCr();
		Course cs = new Course("CS", 140, "Programming", 3);
		Grade grade = new Grade("IP");
		Semester semester = (Semester.SPRING);
		student1.addCourse(cs, semester, 2015, grade);
		assertEquals(credits+3,student1.getAnticipatedAdditionalCr());	
	}
	@Test
	public void testGetCurrentRemainingCredits(){
		int credits = student1.getCurrentRemainingCr();
		Course cs = new Course("CS", 140, "Programming", 3);
		Grade grade = new Grade("A");
		Semester semester = (Semester.SPRING);
		student1.addCourse(cs, semester, 2015, grade);
		assertEquals(credits-3,student1.getCurrentRemainingCr());	
	}
	@Test
	public void testGetAnticipatedRemainingCredits(){
		int credits = student1.getCurrentRemainingCr();
		Course cs = new Course("CS", 140, "Programming", 3);
		Grade grade = new Grade("IP");
		Semester semester = (Semester.SPRING);
		student1.addCourse(cs, semester, 2015, grade);
		assertEquals(credits-3,student1.getAnticipatedRemainingCr());	
	}
	@Test
	public void testReadyToGraduate(){
		Course cs = new Course("CS", 140, "Programming", 120);
		Grade grade = new Grade("A");
		Semester semester = (Semester.SPRING);
		student1.addCourse(cs, semester, 2015, grade);
		student1.setMajorComplete(true);
		student1.setLascComplete(true);
		assertTrue(student1.readyToGraduate());
	}
	
}
