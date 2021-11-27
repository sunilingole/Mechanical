package com.csi.dao;

import com.csi.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDaoImpl  implements  EmployeeDao{
private static SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
    @Override
    public void addData(Employee employee) {
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(employee);
        transaction.commit();
    }

    @Override
    public List<Employee> getDataByusingAnyOutput(Employee employee) {
        Session session=factory.openSession();
        List<Employee>emplist=new ArrayList<>();
        List<Employee>employeeList=session.createQuery("from Employee").list();
        for(Employee ee:employeeList){
            if(ee.getEmpId()==employee.getEmpId()
                ||ee.getEmpFirstName().equals(employee.getEmpFirstName())
                    ||ee.getEmpLastName().equals(employee.getEmpLastName())
                ||ee.getEmpEmailId().equals(employee.getEmpEmailId())
                    ||ee.getEmpuId()==employee.getEmpuId()
                ||ee.getEmpContactNumber()==employee.getEmpContactNumber())
            {
                emplist.add(ee);
            }
        }
        return emplist;
    }
}
