package in.purabtech.hibernet;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.purabtech.entity.Student;



public class QueryStudentExample {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").list();
			
			// display the students
			displayStudents(theStudents);
			
			// query students: lastName='k'
			theStudents = session.createQuery("from Student s where s.lastName='k'").list();
			
			// display the students
			System.out.println("\n\nStudents who have last name of k");
			displayStudents(theStudents);
			
			// query students: lastName='k' OR firstName='purab'
			theStudents =
					session.createQuery("from Student s where"
							+ " s.lastName='k' OR s.firstName='Purab'").list();
			
			System.out.println("\n\nStudents who have last name of k OR first name purab");
			displayStudents(theStudents);
			
			// query students where email LIKE '%gmail.com'
			theStudents = session.createQuery("from Student s where"
					+ " s.email LIKE '%gmail.com'").list();

			System.out.println("\n\nStudents whose email ends with gmail.com");			
			displayStudents(theStudents);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}





