import com.arief.hibernate.config.HibernateSetup;
import com.arief.hibernate.dao.OwnerDAO;
import com.arief.hibernate.dao.PetDAO;
import com.arief.hibernate.dao.impl.OwnerDAOImpl;
import com.arief.hibernate.dao.impl.PetDAOImpl;
import com.arief.hibernate.entity.Owner;
import com.arief.hibernate.entity.Pet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;


public class HibernateWebTestApp {



//    @Test
    public void testLoadDataPetOnlyName(){
        SessionFactory sessionFactory = HibernateSetup.sessionFactoryInstance();
        Session session = sessionFactory.openSession();

        List list = session.createQuery("select  p.petName from  Pet p").list();

        session.close();
    }

    @Test
    public void testLoadDataOwnerWithPet() throws Exception {
        SessionFactory sessionFactory = HibernateSetup.sessionFactoryInstance();
        OwnerDAO ownerDAO = new OwnerDAOImpl(sessionFactory);
        List<Owner> ownerList = ownerDAO.getOwners();
    }
}
