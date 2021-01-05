/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

import com.sg.classroster.models.Course;
import com.sg.classroster.models.Student;
import com.sg.classroster.models.Teacher;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author nacer
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CourseDAODBTest {
    
    @Autowired
    TeacherDAO teacherDao;
    
    @Autowired
    StudentDAO studentDao;
    
    @Autowired
    CourseDAO courseDao;
    
    public CourseDAODBTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        List<Teacher> teachers = teacherDao.getAllTeachers();
        for(Teacher teacher : teachers) {
            teacherDao.deleteTeacherById(teacher.getId());
        }
        
        List<Student> students = studentDao.getAllStudents();
        for(Student student : students) {
            studentDao.deleteStudentById(student.getId());
        }
        
        List<Course> courses = courseDao.getAllCourses();
        for(Course course : courses) {
            courseDao.deleteCourseById(course.getId());
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getCourseById method, of class CourseDAODB.
     */
    @Test
    public void testGetCourseById() {
    }
    /**
     * Test of addCourse method, of class CourseDAODB.
     */
    @Test
    public void testAddCourse() {
    }
    
    @Test
    public void testAddAndGetCourse() {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Test Teacher First");
        teacher.setLastName("Test Teacher Last");
        teacher.setSpecialty("Test Teacher Specialty");
        teacher = teacherDao.addTeacher(teacher);
        
        Student student = new Student();
        student.setFirstName("Test Student First");
        student.setLastName("Test Student Last");
        student = studentDao.addStudent(student);
        
        List<Student> students = new ArrayList<>();
        students.add(student);
        
        Course course = new Course();
        course.setName("Test Course Name");
        course.setTeacher(teacher);
        course.setStudents(students);
        course = courseDao.addCourse(course);
        
        Course fromDao = courseDao.getCourseById(course.getId());
        assertEquals(course, fromDao);
    }

    /**
     * Test of getAllCourses method, of class CourseDAODB.
     */
    @Test
    public void testGetAllCourses() {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Test Teacher First");
        teacher.setLastName("Test Teacher Last");
        teacher.setSpecialty("Test Teacher Specialty");
        teacher = teacherDao.addTeacher(teacher);
        
        Student student = new Student();
        student.setFirstName("Test Student First");
        student.setLastName("Test Student Last");
        student = studentDao.addStudent(student);
        
        List<Student> students = new ArrayList<>();
        students.add(student);
        
        Course course = new Course();
        course.setName("Test Course Name");
        course.setTeacher(teacher);
        course.setStudents(students);
        course = courseDao.addCourse(course);
        
        Course course2 = new Course();
        course2.setName("Test Course Name 2");
        course2.setTeacher(teacher);
        course2.setStudents(students);
        course2 = courseDao.addCourse(course2);
        
        List<Course> courses = courseDao.getAllCourses();
        assertEquals(2, courses.size());
        assertTrue(courses.contains(course));
        assertTrue(courses.contains(course2));
    }

    /**
     * Test of updateCourse method, of class CourseDAODB.
     */
    @Test
    public void testUpdateCourse() {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Test Teacher First");
        teacher.setLastName("Test Teacher Last");
        teacher.setSpecialty("Test Teacher Specialty");
        teacher = teacherDao.addTeacher(teacher);
        
        Student student = new Student();
        student.setFirstName("Test Student First");
        student.setLastName("Test Student Last");
        student = studentDao.addStudent(student);
        
        List<Student> students = new ArrayList<>();
        students.add(student);
        
        Course course = new Course();
        course.setName("Test Course Name");
        course.setTeacher(teacher);
        course.setStudents(students);
        course = courseDao.addCourse(course);
        
        Course fromDao = courseDao.getCourseById(course.getId());
        assertEquals(course, fromDao);
        
        course.setName("New Test Course Name");
        Student student2 = new Student();
        student2.setFirstName("Test Student First 2");
        student2.setLastName("Test Student Last 2");
        student2 = studentDao.addStudent(student2);
        students.add(student2);
        course.setStudents(students);
        
        courseDao.updateCourse(course);
        
        assertNotEquals(course, fromDao);
        
        fromDao = courseDao.getCourseById(course.getId());
        assertEquals(course, fromDao);
    }

    /**
     * Test of deleteCourseById method, of class CourseDAODB.
     */
    @Test
    public void testDeleteCourseById() {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Test Teacher First");
        teacher.setLastName("Test Teacher Last");
        teacher.setSpecialty("Test Teacher Specialty");
        teacher = teacherDao.addTeacher(teacher);
        
        Student student = new Student();
        student.setFirstName("Test Student First");
        student.setLastName("Test Student Last");
        student = studentDao.addStudent(student);
        
        List<Student> students = new ArrayList<>();
        students.add(student);
        
        Course course = new Course();
        course.setName("Test Course Name");
        course.setTeacher(teacher);
        course.setStudents(students);
        course = courseDao.addCourse(course);
        
        Course fromDao = courseDao.getCourseById(course.getId());
        assertEquals(course, fromDao);
        
        courseDao.deleteCourseById(course.getId());
        
        fromDao = courseDao.getCourseById(course.getId());
        assertNull(fromDao);
    }

    /**
     * Test of getCoursesForTeacher method, of class CourseDAODB.
     */
    @Test
    public void testGetCoursesForTeacher() {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Test Teacher First");
        teacher.setLastName("Test Teacher Last");
        teacher.setSpecialty("Test Teacher Specialty");
        teacher = teacherDao.addTeacher(teacher);
        
        Teacher teacher2 = new Teacher();
        teacher2.setFirstName("Test Teacher First 2");
        teacher2.setLastName("Test Teacher Last 2");
        teacher2.setSpecialty("Test Teacher Specialty 2");
        teacher2 = teacherDao.addTeacher(teacher2);
        
        Student student = new Student();
        student.setFirstName("Test Student First");
        student.setLastName("Test Student Last");
        student = studentDao.addStudent(student);
        
        List<Student> students = new ArrayList<>();
        students.add(student);
        
        Course course = new Course();
        course.setName("Test Course Name");
        course.setTeacher(teacher);
        course.setStudents(students);
        course = courseDao.addCourse(course);
        
        Course course2 = new Course();
        course2.setName("Test Course Name");
        course2.setTeacher(teacher2);
        course2.setStudents(students);
        course2 = courseDao.addCourse(course2);
        
        Course course3 = new Course();
        course3.setName("Test Course Name");
        course3.setTeacher(teacher);
        course3.setStudents(students);
        course3 = courseDao.addCourse(course3);
        
        List<Course> courses = courseDao.getCoursesForTeacher(teacher);
        assertEquals(2, courses.size());
        assertTrue(courses.contains(course));
        assertFalse(courses.contains(course2));
        assertTrue(courses.contains(course3));
    }

    /**
     * Test of getCoursesForStudent method, of class CourseDAODB.
     */
    @Test
    public void testGetCoursesForStudent() {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Test Teacher First");
        teacher.setLastName("Test Teacher Last");
        teacher.setSpecialty("Test Teacher Specialty");
        teacher = teacherDao.addTeacher(teacher);
        
        Student student = new Student();
        student.setFirstName("Test Student First");
        student.setLastName("Test Student Last");
        student = studentDao.addStudent(student);
        
        Student student2 = new Student();
        student2.setFirstName("Test Student First 2");
        student2.setLastName("Test Student Last 2");
        student2 = studentDao.addStudent(student2);
        
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student2);
        
        List<Student> students2 = new ArrayList<>();
        students2.add(student2);
        
        Course course = new Course();
        course.setName("Test Course Name");
        course.setTeacher(teacher);
        course.setStudents(students);
        course = courseDao.addCourse(course);
        
        Course course2 = new Course();
        course2.setName("Test Course Name");
        course2.setTeacher(teacher);
        course2.setStudents(students2);
        course2 = courseDao.addCourse(course2);
        
        Course course3 = new Course();
        course3.setName("Test Course Name");
        course3.setTeacher(teacher);
        course3.setStudents(students);
        course3 = courseDao.addCourse(course3);
        
        List<Course> courses = courseDao.getCoursesForStudent(student);
        assertEquals(2, courses.size());
        assertTrue(courses.contains(course));
        assertFalse(courses.contains(course2));
        assertTrue(courses.contains(course3));
    }
    
}
