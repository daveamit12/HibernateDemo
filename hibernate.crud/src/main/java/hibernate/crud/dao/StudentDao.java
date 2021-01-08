package hibernate.crud.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.crud.model.Student;
import hibernate.crud.util.HibernateUtil;

public class StudentDao {
	
	//save Student
	
	public void saveStudents(Student s) {
		
		
		Transaction tx=null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			tx=session.beginTransaction();
			
			session.save(s);
			
			//commit tx:
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(tx !=null)
			tx.rollback();
		}
	}
	
	//getAlllStudents
	
@SuppressWarnings("unchecked")
public List<Student> getStudents( ) {
		
		
		Transaction tx=null;
		List<Student> StudentList=null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			tx=session.beginTransaction();
			
			StudentList=session.createQuery("FROM STUDENT").list();
			//or we can use load method
			//	s2=session.load(Student.class, id);
			
			
			//commit tx:
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(tx !=null)
			tx.rollback();
		}
		return StudentList;
	}
	
	
	//Get By Id
public Student getStudents(long id) {
		
		
		Transaction tx=null;
		Student s2=null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			tx=session.beginTransaction();
			s2=session.get(Student.class, id);
			//or we can use load method
			//	s2=session.load(Student.class, id);
			
			
			//commit tx:
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(tx !=null)
			tx.rollback();
		}
		return s2;
	}
	
	//Update by Id
	
public void updateStudent(Student s) {
		
		
		Transaction tx=null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			tx=session.beginTransaction();
			
			session.saveOrUpdate(s);
			
			//commit tx:
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(tx !=null)
			tx.rollback();
		}
	}
	
	//Delete student.

@SuppressWarnings("unchecked")
public void delete(long id ) {
		
		
		Transaction tx=null;
		Student stu=null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			tx=session.beginTransaction();
			
			stu=session.get(Student.class, id);
			session.delete(stu);
			//or we can use load method
			//	s2=session.load(Student.class, id);
			
			
			//commit tx:
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(tx !=null)
			tx.rollback();
		}
	}

}
