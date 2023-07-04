package com.springboot.app2.wiki;

/**
 *
 * Count, Group By, Having
 *
 * select s.id, s.name, count(p.id)
 * from students s
 * inner join pets p on p.student_id = s.id
 * group by s.id, s.name
 * having s.grade is not null and s.grade > 100
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Sub query
 *
 * select distinct s.id, s.name
 * from students s
 * inner join pets p on p.student_id = s.id
 * where s.id in (select s2.id from students s2 where s2.grade is not null and s2.grade > 100)
 *
 * select s.id, s.name, count(p.id)
 * from students s
 * inner join pets p on p.student_id = s.id
 * group by s.id, s.name
 * having s.id in (select s2.id from students s2 where s2.grade is not null and s2.grade > 100)
 *
 */
public class SqlScripts {
}
