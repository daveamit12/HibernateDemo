package hibernate.crud.test;

import java.util.List;

import hibernate.crud.dao.StudentDao;
import hibernate.crud.model.Student;

public class Test {

	public static void main(String[] args) {

		StudentDao dao=new StudentDao();
		Student s=new Student("ABC","DEF","a@com");
		//saveStudent();
		dao.saveStudents(s);
		//update:
		s.setFirstName("AMI");
		dao.updateStudent(s);
		//get by Id:
		Student s2=dao.getStudents(s.getId());
		
		//getAll:
		List<Student> s3=dao.getStudents();
		s3.forEach(s4 -> System.out.println(s4.getId()));
	//delete:
		dao.delete(s.getId());
	
	}

}
