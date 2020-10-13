package ro.sorinLink.firmaBirou.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sorinLink.firmaBirou.database.User;
import ro.sorinLink.firmaBirou.database.UserDAO;



@Service
public class UserRoleService {

    @Autowired
    UserDAO userDAO;


    public void saveRole(String acces, String email) throws Exception {

        User user;

        if (userDAO.findByEmail(email).size()==0){
            throw new Message("Email not be found!");
        }else {
            user = userDAO.findByEmail(email).get(0);

        }

        user.setRole(acces);
        userDAO.save(user);

    }
}
