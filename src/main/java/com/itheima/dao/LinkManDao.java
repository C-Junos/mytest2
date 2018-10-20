package com.itheima.dao;

import com.itheima.domain.LinkMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LinkManDao extends JpaRepository<LinkMan,Long>,JpaSpecificationExecutor<LinkMan> {

    @Query(value = "from LinkMan lm inner join fetch lm.customer c where c.custName like ?")
    List<LinkMan> findByCustomer(String s);
}
