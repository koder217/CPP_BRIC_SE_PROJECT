//package edu.cpp.brcm.impl;

import edu.cpp.brcm.common.Hibernate;
import edu.cpp.brcm.dtos.RevenueDto;
import edu.cpp.brcm.repositories.RevenueReportRepository;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

//@Repository
//public class RevenueReportRepositoryImpl implements RevenueReportRepository {
//    @Override
//    public List<RevenueDto> getRevenueReport(String customerType, LocalDate dtStart, LocalDate dtEnd) {
//        var session = Hibernate.getSession();
//        Query<RevenueDto> q = session.createQuery("select o.customerType, sum(o.totalprice), MONTH(o.date), year(o.date) from Order o where o.customerType = :customerType and o.date between :dtStart and :dtEnd group by month, year",RevenueDto.class);
//        q.setParameter("customerType", customerType);
//        q.setParameter("dtStart", dtStart);
//        q.setParameter("dtEnd", dtEnd);
//        return q.getResultList();
//    }
//}
