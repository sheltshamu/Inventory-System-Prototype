package zw.co.afrosoft.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import zw.co.afrosoft.domain.Employee;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee> {

    ResponseEntity findEmployeeByEmail(String email);

}
