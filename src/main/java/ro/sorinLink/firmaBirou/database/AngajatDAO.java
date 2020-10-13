package ro.sorinLink.firmaBirou.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface AngajatDAO extends CrudRepository<Angajat, Long > {

    List<Angajat> findAll();
    List<Angajat> findAngajatByEmail(String email);









}
//@Autowired
//UserDAO userDAO;
//
//    @PersistenceContext
//    EntityManager entityManager;
//
//    @Transactional
//    public void saveAngajat(String cnp, String functie, String name, String lastName, String email){
//        Angajat angajat = new Angajat();
//        angajat.setCnp(cnp);
//        angajat.setFunctie(functie);
//        angajat.setName(name);
//        angajat.setLastName(lastName);
//        angajat.setEmail(email);
//
//
//        User user = userDAO.findByEmail(email).get(0);
//        angajat.setUser(user);
//
//        entityManager.persist(angajat);
//    }
//    public List<Angajat> findAngajatByEmail(String email) {
//        Query queryAngajat = entityManager.createNativeQuery("select * from angajat where email = '" + email + "'", Angajat.class);
//        return queryAngajat.getResultList();
//    }
//}