package customer_province.repository;

import customer_province.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceRepository extends JpaRepository<Province, Integer> {
    Page<Province> findAllByProvinceName(String name, Pageable pageable);
}
