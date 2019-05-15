package bjtu.edu.javaee.a2.service;

import bjtu.edu.javaee.a2.domain.User;
import bjtu.edu.javaee.a2.repository.UserRepository;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setContactRepository(UserRepository userRepository) {
        this.userRepository = userRepository;

    }
    @Override
    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    @Cacheable("users")
    public User getUserById(Integer id) {

        simulateSlowService();
//        return this.contactRepository.findById(id).orElse(null);
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User contact) {
        return this.userRepository.save(contact);
    }

    @Override
    public void deleteUser(Integer id) {
        this.userRepository.deleteById(id);

    }

    @Override
    public User getUserDetail(int id) {
        return this.userRepository.findById(id).orElse(null);
    }

    //    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 2000L;
            Thread.sleep(time);
            System.out.println("sleep 2s");
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }


}
