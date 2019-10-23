package listeners;

import database.Skill;
import database.Sources;
import database.Users;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebListener
public class HibernateInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Logger logger = Logger.getLogger(HibernateInitializer.class.getName());

        try {
            Configuration configuration = new Configuration();
            Properties hbnProperties = new Properties();
            hbnProperties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            hbnProperties.put(Environment.URL, "jdbc:mysql://remotemysql.com:3306/kLg5mtQOnj");
            hbnProperties.put(Environment.USER, "kLg5mtQOnj");
            hbnProperties.put(Environment.PASS, "qx778Vr3Q0");
            hbnProperties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
            hbnProperties.put(Environment.SHOW_SQL, "true");
            hbnProperties.put(Environment.FORMAT_SQL, "true");
            hbnProperties.put(Environment.HBM2DDL_AUTO, "create-drop");
            configuration.setProperties(hbnProperties);

            configuration.addAnnotatedClass(Skill.class);
            configuration.addAnnotatedClass(Sources.class);
            configuration.addAnnotatedClass(Users.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Błąd komunikacji Hibernate");
        }


    }
}
