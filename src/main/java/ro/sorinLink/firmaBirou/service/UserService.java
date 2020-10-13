package ro.sorinLink.firmaBirou.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sorinLink.firmaBirou.database.User;
import ro.sorinLink.firmaBirou.database.UserDAO;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public List<User> getUserList() {
        return userDAO.findAll();
    }

    public List<User> getUserByEmail(String email) {
        return userDAO.findByEmail(email);
    }



    public void save(String email, String password, String password2) throws Message {

        if (!password.equals(password2)) {
            throw new Message("Parole nu sunt identice!");

        }
        if (password.length() < 5) {
            throw new Message("parola trebuie sa aibe peste 5 caractere");
        }

       if (userDAO.findByEmail(email).size() > 1) {
            throw new Message("exista deja un utilizator cu acest email");

       }
        if (userDAO.findByEmail(email).size() == 1) {

            //folosim functia md5 pentru a 'cripta' parola
            String passwordMD5 = DigestUtils.md5Hex(password);
            User user = new User();
            user.setEmail(email);
            user.setPassword(passwordMD5);
            userDAO.save(user);
        }
    }
        public List<User>findByEmail(String email){
            return userDAO.findByEmail(email);
        }
    }


