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
	@Test
	public void testAddCourse(){
		Course cs = new Course("CS", 140, "Programming", 3);
		Grade g1 = new Grade("A");
		student1.addCourse(cs, "Spring", 2015, g1);
		student1.getTranscript();
	}

}
