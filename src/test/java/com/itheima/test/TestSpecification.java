package com.itheima.test;

import com.itheima.dao.CustomerDao;
import com.itheima.dao.LinkManDao;
import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Customer;
import com.itheima.domain.LinkMan;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Set;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestSpecification {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testSpec() {

        /*Customer one = customerDao.getOne(5L);
        System.out.println(one);

        Set<LinkMan> linkMans = one.getLinkMans();
        for (LinkMan linkMan : linkMans) {
            System.out.println(linkMan);
        }*/

        /*LinkMan one = linkManDao.findOne(2L);
        System.out.println(one);

        Customer customer = one.getCustomer();
        System.out.println(customer);*/

        /*Specification<LinkMan> specification = new Specification<LinkMan>() {
            public Predicate toPredicate(Root<LinkMan> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<LinkMan, Customer> join = root.join("customer", JoinType.INNER);

                return criteriaBuilder.like(join.<String>get("custName"), "%新%");
            }
        };

        List<LinkMan> all = linkManDao.findAll(specification);
        for (LinkMan linkMan : all) {
            System.out.println(linkMan);
        }*/

        List<LinkMan> list = linkManDao.findByCustomer("%新%");

        for (LinkMan linkMan : list) {
            System.out.println(linkMan);
        }

    }
}
