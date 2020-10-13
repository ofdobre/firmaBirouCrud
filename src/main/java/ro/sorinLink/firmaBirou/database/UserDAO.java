package ro.sorinLink.firmaBirou.database;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface UserDAO extends CrudRepository<User, Long> {
      List<User> findAll();
      List<User> findByEmail(String email);
      List<User> findByEmailAndRole(String email, String role);





}
//
//    @PersistenceContext
//    EntityManager entityManager;
//
//    @Transactional
//    public void save(String email, String password) {
//        User user = new User();
//        user.setEmail(email);
//        user.setPassword(password);
//
//        entityManager.persist(user);
//    }
//
//    public List<User> findByEmail(String email) {
//      Query query = entityManager.createNativeQuery("select * from users where email = '" + email + "'", User.class);
//        return query.getResultList();
//
//    }
//}





