package edu.cpp.brcm.repositories;

import edu.cpp.brcm.dtos.OrderDto;
import edu.cpp.brcm.dtos.RevenueDto;
import edu.cpp.brcm.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.time.LocalDate;
import java.util.List;


@Repository
public interface RevenueReportRepository extends JpaRepository<Order, Integer> {
    @Query("select o.customerType as customerType, sum(o.totalprice) as totalRevenue, MONTH(o.date) as bymonth, year(o.date) as byyear from Order o where o.customerType = :customerType and o.date between :dtStart and :dtEnd group by o.customerType, bymonth, byyear")
    List<Tuple> getRevenueReport(String customerType, LocalDate dtStart, LocalDate dtEnd);
}
