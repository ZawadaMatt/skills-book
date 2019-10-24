package dao;

import database.Source;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.logging.Logger;

public class SourceDAO extends BaseDAO {

    private Logger logger = Logger.getLogger(UserDAO.class.getName());

    SourceDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Source get(Long id) {
        return super.produceInTransaction(session -> session.get(Source.class, id));
    }

    public void save(Source source) {
        super.executeInTransaction(session -> session.save(source));
    }

    public void update(Source source) {
        super.executeInTransaction(session -> session.update(source));
    }

    public void delete(Source source) {
        super.executeInTransaction(session -> session.delete(source));
    }

    public List<Source> getAll() {
        return super.produceInTransaction(
                session -> session.createQuery("SELECT s FROM Source s", Source.class)
                        .getResultList());
    }

    public List<Source> getAllByName(String name) {
        return super.produceInTransaction(
                session -> session.createQuery("SELECT s FROM Source s WHERE s.name = :name", Source.class)
                        .setParameter("name", name)
                        .getResultList());
    }

    public List<Source> getAllByNameAndDescription(String name, String description) {
        return super.produceInTransaction(
                session -> session.createQuery("SELECT s FROM Source s WHERE s.name = :name AND s.description = :description", Source.class)
                        .setParameter("name", name)
                        .setParameter("description", description)
                        .getResultList());
    }


}
