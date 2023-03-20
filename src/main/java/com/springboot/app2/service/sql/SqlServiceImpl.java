package com.springboot.app2.service.sql;

import com.springboot.app2.dao.EmployeeRepository;
import com.springboot.app2.entity.Employee;
import com.springboot.app2.util.RandomUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
    CREATE INDEX idx_name ON employees(name);
    DROP INDEX idx_name;

    select * from employees order by "name"
    Without index - 6-7 sec
    With index - 1-2 sec
 */

@Service
public class SqlServiceImpl implements SqlService {

    private final int numberOfRecords = 100_000;

    private final EmployeeRepository employeeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public SqlServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void insertToTable() {
        Collection<Employee> employees = new ArrayList<>(numberOfRecords);
        for (int i = 0; i < numberOfRecords; i++) {
            employees.add(new Employee("emp-" + RandomUtil.generateRandomLongValue()));
        }
        employeeRepository.saveAll(employees);
    }

    // TODO remove to wiki
    public void constraints() {
        /*
        NOT NULL - Restricts NULL value from being inserted into a column.

        CHECK - Verifies that all values in a field satisfy a condition.
        create table test (
	        id serial NOT NULL PRIMARY KEY,
	        gender char(1) constraint gender_check check(gender in ('M', 'F'))
        );
        insert into test (gender) values ('F');
        insert into test (gender) values ('R'); -> ERROR: ОШИБКА:  новая строка в отношении "test" нарушает ограничение-проверку "gender_check"

        DEFAULT - Automatically assigns a default value if no value has been specified for the field.
        alter table test add column if not exists deleted boolean default false;

        UNIQUE - Ensures unique values to be inserted into the field.

        INDEX - Indexes a field providing faster retrieval of records.

        PRIMARY KEY - Uniquely identifies each record in a table.

        FOREIGN KEY - Ensures referential integrity for a record in another table.
        */
    }

    // TODO remove to wiki
    public void joins() {
        /* students
        "id","name","grade","supervisor_id"
        1,"tony",200,3380
        2,"John",7,1
        3,"Bill",10,NULL
        4,"Tony",8,3
        6,"tony3",3,NULL
        7,"stud-7",NULL,NULL
        14,"testName9190",NULL,NULL
         */

//        INNER JOIN
        String inner = "select s.id, s.name, ss.id, ss.create_date from students s " +
                "INNER join student_settings ss on ss.student_id = s.id;";

//        LEFT OUTER JOIN
        String left = "select s.id, s.name, ss.id, ss.create_date from students s " +
                "LEFT join student_settings ss on ss.student_id = s.id;";

//        RIGHT OUTER JOIN
        String right = "select s.id, s.name, ss.id, ss.create_date from students s " +
                "RIGHT join student_settings ss on ss.student_id = s.id;";

//        FULL JOIN
        String full = "select s.id, s.name, ss.id, ss.create_date from students s " +
                "FULL join student_settings ss on ss.student_id = s.id;";

//        CROSS JOIN
        String cross = "select s.id, s.name, ss.id, ss.create_date from students s " +
                "CROSS join student_settings ss;";

//        SELF JOIN
        String self_1 = "select s.id, s.name, sup.id from students s, students sup " +
                "where s.supervisor_id = sup.id;";
        String self_2 = "select s.id, s.name, sup.id from students s " +
                "inner join students sup on s.supervisor_id = sup.id;";
    }



}
