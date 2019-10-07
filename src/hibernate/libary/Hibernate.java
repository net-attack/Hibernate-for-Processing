package hibernate.libary;


import java.util.List;
import java.util.Properties;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.cfg.AvailableSettings;

import processing.core.*;

/**
 * This is a template class and can be used to start a new processing Library.
 * Make sure you rename this class as well as the name of the example package 'template' 
 * to your own Library naming convention.
 * 
 * (the tag example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 * @example Hello 
 */

public class Hibernate {
	
	// myParent is a reference to the parent sketch
	PApplet myParent;

	int myVariable = 0;
	
	public final static String VERSION = "##library.prettyVersion##";
	
	private SessionFactory factory;
	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the Library.
	 * 
	 * @example Hello
	 * @param theParent the parent PApplet
	 */
	public Hibernate(PApplet theParent, final String path, List<Class> annotatedClasses) {
		myParent = theParent;
		welcome();
		try {
			final Configuration configuration = new Configuration();
			final Properties prop = new Properties();
			prop.setProperty(AvailableSettings.DRIVER, "net.ucanaccess.jdbc.UcanaccessDriver");
			prop.setProperty(AvailableSettings.URL, "jdbc:ucanaccess://" + path);
			prop.setProperty(AvailableSettings.USER, "");
			prop.setProperty(AvailableSettings.PASS, "");
			prop.setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.SQLServerDialect");
			prop.put(AvailableSettings.SHOW_SQL, "true");
			configuration.setProperties(prop);
			
			for(Class c : annotatedClasses) {
				configuration.addAnnotatedClass(c);
			}

			final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
					.build();

			try {
				this.factory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		} catch (final Exception ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	
	private void welcome() {
		System.out.println("##library.name## ##library.prettyVersion## by ##author##");
	}
	
	
	public String sayHello() {
		return "Hibernate library.";
	}
	/**
	 * return the version of the Library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}

	/**
	 * 
	 * @param theA the width of test
	 * @param theB the height of test
	 */
	public void setVariable(int theA, int theB) {
		myVariable = theA + theB;
	}

	/**
	 * 
	 * @return int
	 */
	public int getVariable() {
		return myVariable;
	}
}

