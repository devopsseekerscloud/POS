package lk.ijse.pos.POS.repo;

import lk.ijse.pos.POS.dto.query_interface.CustomerDataInterface;
import lk.ijse.pos.POS.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer,String> {

    @Query(value = "SELECT id AS id,name AS name,address AS address,salary AS salary FROM Customer WHERE name LIKE %?1% OR address LIKE %?1% ", nativeQuery = true)
    Page<CustomerDataInterface> getAllCustomers(
            String searchText, Pageable pageable
    );

    @Query(value = "SELECT COUNT(id) FROM Customer WHERE name LIKE %?1% OR address LIKE %?1% ", nativeQuery = true)
    int getAllCustomersCount(String searchText);



}
