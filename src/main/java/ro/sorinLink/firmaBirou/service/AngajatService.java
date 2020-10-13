package ro.sorinLink.firmaBirou.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sorinLink.firmaBirou.database.Angajat;
import ro.sorinLink.firmaBirou.database.AngajatDAO;
import ro.sorinLink.firmaBirou.database.User;
import ro.sorinLink.firmaBirou.database.UserDAO;

import javax.persistence.Query;
import java.util.List;
 @Service

public class AngajatService {
     @Autowired
     AngajatDAO angajatDAO;
     @Autowired
     UserDAO userDAO;



     public void saveAngajat(String cnp, String functie, String name, String lastName, String email) {
         Angajat angajat = new Angajat();
         angajat.setEmail(email);
         angajat.setCnp(cnp);
         angajat.setName(name);
         angajat.setLastName(lastName);
         angajat.setFunctie(functie);
         User user = userDAO.findByEmail(email).get(0);
         angajat.setUser(user);
         angajatDAO.save(angajat);


     }
     public List<Angajat> findAngajatByEmail(String email) {
         return angajatDAO.findAngajatByEmail(email);
     }

    }

