package com.syzton.sunread.repository;

import java.util.ArrayList;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.syzton.sunread.model.semester.Semester;

public interface SemesterRepository extends JpaRepository<Semester,Long>{
	@Query("SELECT Distinct(s) FROM Semester s WHERE s.startTime>(:time) AND s.endTime<(:time) AND s.campus=(:campusId)")
	Semester findByTime(@Param("time")DateTime time,@Param("campusId")long campusId);
	@Query("SELECT Distinct(s) FROM Semester s WHERE s.startTime>(:startTime) AND s.endTime<(:endTime) ORDER BY s.startTime DESC AND s.campus=(:campusId)")
	ArrayList<Semester> findByDuration(@Param("startTime")DateTime startTime,@Param("endTime")DateTime endTime,@Param("campusId")long campusId);

}
