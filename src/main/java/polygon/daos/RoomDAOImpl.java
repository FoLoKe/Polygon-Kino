package polygon.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.Room;

import java.util.List;

@Transactional
@Repository
public class RoomDAOImpl implements RoomDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Room> allRooms() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Room").list();
    }

    @Override
    public void add(Room room) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(room);
    }

    @Override
    public void delete(Room room) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(room);
    }

    @Override
    public void edit(Room room) {
        Session session = sessionFactory.getCurrentSession();
        session.update(room);
    }

    @Override
    public Room getByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Room.class, id);
    }
}
