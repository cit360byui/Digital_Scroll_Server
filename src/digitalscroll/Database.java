package digitalscroll;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Database {
	private static final SessionFactory sessionFactory;
	private static final String USERNAME = "student", 
			PASSWORD = "student", 
			DB_NAME = "scroll", 
			SHOW_SQL = "false";
	static {
		try {
			Configuration config = new Configuration();
			
			// PROPERTIES
			config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
			config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
			config.setProperty("hibernate.connection.username", USERNAME);
			config.setProperty("hibernate.connection.password", PASSWORD);
			config.setProperty("hibernate.connection.pool_size", "1");
			config.setProperty("hibernate.connection.autocommit", "true");
			config.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
			config.setProperty("hibernate.show_sql", SHOW_SQL);
			config.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
			config.setProperty("hibernate.current_session_context_class", "thread");
			
			// ANNOTATED CLASSES THAT MATCH DATABASE TABLES
			config.addAnnotatedClass(Article.class);
			sessionFactory = config.buildSessionFactory(null);
		}
		catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	// make a private default constructor so that no other hibernate utility can be
	// created.

	private Database() {

	}
}
