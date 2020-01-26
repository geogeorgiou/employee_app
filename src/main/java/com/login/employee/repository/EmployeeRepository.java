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
    Optional<Employee> findByEmail(String email);

    Optional<Employee> findById(String id);

//    @Query(
//    value = "with recursive sub (EMP_ID,EMP_Name,EMP_Supervisor) as(" +
//    "select EMP_ID,EMP_Name,EMP_Supervisor" +
//    "from Employee" +
//    "where Employee.EMP_Supervisor = ?" +
//    ""+
//    "union all"+
//    ""+
//    "select emp.EMP_ID,emp.EMP_Name,emp.EMP_Supervisor"+
//    "from Employee emp"+
//    "inner join sub" +
//    "on emp.EMP_Supervisor = sub.EMP_ID"+
//    ")"+
//    "select * from sub",nativeQuery = true)

    @Query(
    value = "with recursive sub (EMP_ID,EMP_Name,EMP_Supervisor) as( " +
            "select EMP_ID,EMP_Name,EMP_Supervisor " +
            "from employee " +
            "where employee.EMP_Supervisor = :superId " +
            "union all " +
            "select emp.EMP_ID,emp.EMP_Name,emp.EMP_Supervisor " +
            "from employee emp " +
            "inner join sub " +
            "on emp.EMP_Supervisor = sub.EMP_ID " +
            ") " +
            "select EMP_ID from sub",nativeQuery = true)
    Set<Employee> findSubBySupervisorId(@Param("superId") String id);

    @Query(
            value = "with recursive sub (EMP_ID,EMP_Name,EMP_Supervisor) as( " +
                    "select EMP_ID,EMP_Name,EMP_Supervisor " +
                    "from employee " +
                    "where employee.EMP_Supervisor = :superId " +
                    "union all " +
                    "select emp.EMP_ID,emp.EMP_Name,emp.EMP_Supervisor " +
                    "from employee emp " +
                    "inner join sub " +
                    "on emp.EMP_Supervisor = sub.EMP_ID " +
                    ") " +
                    "select EMP_ID from sub",nativeQuery = true)
    Set<String> findSubStrBySupervisorId(@Param("superId") String id);

//    @Query(value = "with recursive sub (EMP_ID,EMP_Name,EMP_Supervisor) as(\n" +
//            "    select EMP_ID,EMP_Name,EMP_Supervisor\n" +
//            "    from employee\n" +
//            "    where employee.EMP_Supervisor = '82D58D49-72A2-42B0-A250-471E5C10D7D9'\n" +
//            "    \n" +
//            "    union all\n" +
//            "    \n" +
//            "    select emp.EMP_ID,emp.EMP_Name,emp.EMP_Supervisor\n" +
//            "    from employee emp\n" +
//            "    inner join sub\n" +
//            "    on emp.EMP_Supervisor = sub.EMP_ID\n" +
//            ")\n" +
//            "select * from sub",nativeQuery = true)
//    Set<Employee> findSubBySupervisorId(String id);

}
