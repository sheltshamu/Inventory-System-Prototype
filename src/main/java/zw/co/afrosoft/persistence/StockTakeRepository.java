package zw.co.afrosoft.persistence;

import org.springframework.stereotype.Repository;
import zw.co.afrosoft.domain.StockTake;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StockTakeRepository extends BaseRepository<StockTake> {
    List<StockTake> findAllByDate(LocalDate date);
}
