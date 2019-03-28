import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ItemDAO {
    private static SessionFactory sessionFactory;

    public  Item save (Item object){
        Session session=null;
        Transaction transaction=null;
        try{
            session=createSessionFactory().openSession();
            transaction=session.getTransaction();
            transaction.begin();
            session.save(object);
            transaction.commit();
            System.out.println("Save is done");
        }catch (Exception e) {
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
            if (transaction != null)
                transaction.rollback();
        } finally {
            if (session != null)
                session.close();
        }

        return object;
    }

    public  void delete(Item object) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.delete(object);

            tr.commit();
            System.out.println("Delete is done");
        } catch (Exception e) {
            System.err.println("Delete is failed");
            System.err.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null)
                session.close();
        }

    }
    public Item update(Item object) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.update(object);
            tr.commit();
            System.err.println("Update is done");
        } catch (Exception e) {
            System.err.println("Update is failed");
            System.err.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null)
                session.close();
        }

        return object;
    }

    public Item findById(long id){
        Session session=null;
        try {
            session = createSessionFactory().openSession();
            Item item=session.get(Item.class,id);
            return item;
        }catch(Exception e){
            System.err.println("Search is failed");
            System.err.println(e.getMessage());
        }finally {
            if (session!=null)
                session.close();
        }
        return null;
    }



    protected   static SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

}
