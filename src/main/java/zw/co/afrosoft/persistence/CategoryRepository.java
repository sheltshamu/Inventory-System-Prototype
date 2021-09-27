package zw.co.afrosoft.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zw.co.afrosoft.domain.Category;
@Repository
public interface CategoryRepository extends BaseRepository<Category> {
}
