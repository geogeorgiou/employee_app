package com.login.employee.repository;

import com.login.employee.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    //Using Spring JPA functionality to get DB Data

    //SEARCH

    Optional<Employee> findById(String id);

    //recursive query (supported by MySQL 8+) that finds subordinates given supervisor ID

    @Query(
    value = "with recursive sub (EMP_ID,EMP_Name,EMP_Supervisor,EMP_Date_Of_Hire) as( " +
            "select EMP_ID,EMP_Name,EMP_Supervisor,EMP_Date_Of_Hire " +
            "from employee " +
            "where employee.EMP_Supervisor = :superId " +
            "union all " +
            "select emp.EMP_ID,emp.EMP_Name,emp.EMP_Supervisor,emp.EMP_Date_Of_Hire " +
            "from employee emp " +
            "inner join sub " +
            "on emp.EMP_Supervisor = sub.EMP_ID " +
            ") " +
            "select EMP_ID,EMP_Name,EMP_Supervisor,EMP_Date_Of_Hire from sub",nativeQuery = true)
    List<Employee> findSubBySupervisorId(@Param("superId") String id);

}
