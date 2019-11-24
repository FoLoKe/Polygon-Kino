package polygon.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.Building;

import java.util.List;

@Transactional
@Repository
public class BuildingDAOImpl implements BuildingDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Building> getAllBuildings() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Building").list();
    }

    @Override
    public void add(Building building) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(building);
    }

    @Override
    public void delete(Building building) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(building);
    }

    @Override
    public void edit(Building building) {
        Session session = sessionFactory.getCurrentSession();
        session.update(building);
    }

    @Override
    public Building getByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Building.class, id);
    }
}
