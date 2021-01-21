package ma.pfa.springsecurity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.pfa.springsecurity.service.model.Userorder;

public interface UserOrderRepository extends JpaRepository<Userorder, Long> {
    @Query(" SELECT e from userorder e where e.user.id=:id ")
    List<Userorder> findByUser(@Param("id") Long id);
}
