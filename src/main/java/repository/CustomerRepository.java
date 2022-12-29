package repository;

import entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {

    List<CustomerEntity> findByName(String name);
    List<CustomerEntity> findByPhone(String phone);
    List<CustomerEntity> findByEmail(String email);
    @Query (value = "Select c from CustomerEntity c where c.name like %?1%")
    List<CustomerEntity> getCustomerByName(String fname);
    @Query(value = "Select * from CustomerEntity c where c.phone = ?1 or c.email = ?2", nativeQuery = true)
    List<CustomerEntity> getCustomerByPhoneOrEmail(String phone, String email);

    @Query(value = "SELECT * FROM CustomerEntity as c where DATEDIFF(CURDATE(), birthdate)/365 between 20 and 30 and sex = 'men'", nativeQuery = true)
    List<CustomerEntity> getCustomerByAgeAndSex();
}
