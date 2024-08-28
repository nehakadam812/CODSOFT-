package codSoft_5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class StudentCourseRegistrationSystem {
	private static List<Course> courses = new ArrayList<>();
	private static List<Student> students = new ArrayList<>();

	public static void main(String[] args) {
		StudentCourseRegistrationSystem srs = new StudentCourseRegistrationSystem();
		courses.add(srs.new Course("SQ1", "SQL", "SQL Database", 60));
		courses.add(srs.new Course("J101", "Java", "Core java.", 30));
		courses.add(srs.new Course("P102", "Python", "Basics Python", 30));
		courses.add(srs.new Course("W103", "Webtec", "Html,css & java script", 60));
		courses.add(srs.new Course("T104", "Tsting", "Test cases", 30));
		courses.add(srs.new Course("AJ105", "J2EE", "Advance java", 30));
		courses.add(srs.new Course("S106", "Selenium", "Selenium ", 30));

		students.add(srs.new Student("1", "Vani Pavar"));
		students.add(srs.new Student("2", "Akash Jadhav"));
		students.add(srs.new Student("3", "Pooja Bhosale"));
		students.add(srs.new Student("4", "Manisha Bhide"));
		students.add(srs.new Student("5", "Kiran Magar"));

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("1. List of Courses");
			System.out.println("2. Register for the Course");
			System.out.println("3. for Drop Course");
			System.out.println("4. for List Students");
			System.out.println("5. Student prsent or not");
			System.out.println("6. Exit");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				listCourses();
				break;
			case 2:
				registerForCourse(scanner);
				break;
			case 3:
				dropCourse(scanner);
				break;
			case 4:
				listStudents();
				break;

			case 5:
				System.out.println("The Student info:");
				Student s = StudentCourseRegistrationSystem.findStudentById(null);
				System.out.println(s);
			case 6:
				System.out.println("You Are Exit___!");
				scanner.close();
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void listCourses() {
		System.out.println("Available Courses:");
		for (Course course : courses) {
			System.out.println(course);
		}
	}

	private static void registerForCourse(Scanner scanner) {
		System.out.println("Enter student ID:");
		String studentId = scanner.nextLine();
		Student student = findStudentById(studentId);
		if (student == null) {
			System.out.println("Student not found.");
			return;
		}

		System.out.println("Enter course code:");
		String courseCode = scanner.nextLine();
		Course course = findCourseByCode(courseCode);
		if (course == null) {
			System.out.println("Course not found.");
			return;
		}

		if (student.registerCourse(course)) {
			System.out.println("Registered successfully__!");
		} else {
			System.out.println("Failed to register. Course may be full.");
		}
	}

	private static void dropCourse(Scanner scanner) {
		System.out.println("Enter student ID:");
		String studentId = scanner.nextLine();
		Student student = findStudentById(studentId);
		if (student == null) {
			System.out.println("Student not found___!");
			return;
		}

		System.out.println("Enter course code:");
		String courseCode = scanner.nextLine();
		Course course = findCourseByCode(courseCode);
		if (course == null) {
			System.out.println("Course not found___!");
			return;
		}

		if (student.dropCourse(course)) {
			System.out.println("Dropped successfully___!");
		} else {
			System.out.println("Failed___! Student may not be registered.");
		}
	}

	private static void listStudents() {
		System.out.println("Students:");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private static Course findCourseByCode(String courseCode) {
		for (Course course : courses) {
			if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
				return course;
			}
		}
		return null;
	}

	private static Student findStudentById(String studentId) {
		for (Student student : students) {
			if (student.getStudentId().equalsIgnoreCase(studentId)) {
				return student;
			}
		}
		return null;
	}

	public class Course {
		private String courseCode;
		private String title;
		private String description;
		private int capacity;
		private int enrolled;

		public Course(String courseCode, String title, String description, int capacity) {
			this.courseCode = courseCode;
			this.title = title;
			this.description = description;
			this.capacity = capacity;
			this.enrolled = 0;
		}

		public String getCourseCode() {
			return courseCode;
		}

		public String getTitle() {
			return title;
		}

		public String getDescription() {
			return description;
		}

		public int getCapacity() {
			return capacity;
		}

		public int getAvailableSlots() {
			return capacity - enrolled;
		}

		public boolean enrollStudent() {
			if (getAvailableSlots() > 0) {
				enrolled++;
				return true;
			}
			return false;
		}

		public boolean dropStudent() {
			if (enrolled > 0) {
				enrolled--;
				return true;
			}
			return false;
		}

		@Override
		public String toString() {
			return "Course [courseCode=" + courseCode + ", title=" + title + ", description=" + description
					+ ", capacity=" + capacity + ", enrolled=" + enrolled + "]";
		}

	}

	public class Student {
		private String studentId;
		private String name;
		private Set<String> registeredCourses;

		public Student(String studentId, String name) {
			this.studentId = studentId;
			this.name = name;
			this.registeredCourses = new HashSet<>();
		}

		public String getStudentId() {
			return studentId;
		}

		public String getName() {
			return name;
		}

		public boolean registerCourse(Course course) {
			if (course.enrollStudent()) {
				registeredCourses.add(course.getCourseCode());
				return true;
			}
			return false;
		}

		public boolean dropCourse(Course course) {
			if (registeredCourses.contains(course.getCourseCode()) && course.dropStudent()) {
				registeredCourses.remove(course.getCourseCode());
				return true;
			}
			return false;
		}

		@Override
		public String toString() {
			return "Student [studentId=" + studentId + ", name=" + name + ", registeredCourses=" + registeredCourses
					+ "]";
		}

	}

}
