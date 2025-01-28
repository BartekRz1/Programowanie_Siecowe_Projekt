package API.SWIFT.repository;

import API.SWIFT.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
    Bank findBySwiftCode(String swiftCode);

    @Query(value = "SELECT * FROM bank b WHERE b.swift_code LIKE CONCAT(:prefix, '%') AND b.swift_code NOT LIKE CONCAT(:prefix, '%XXX')", nativeQuery = true)
    List<Bank> findAllBranches(@Param("prefix") String prefix);


}
