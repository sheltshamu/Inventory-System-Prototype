package zw.co.afrosoft.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zw.co.afrosoft.domain.ProductStockTake;

import java.time.LocalDate;

@Repository
public interface ProductStockTakeRepository extends BaseRepository<ProductStockTake>{

}
