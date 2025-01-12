package Mapping.OneToOne.repo;

import org.springframework.stereotype.Repository;

import Mapping.OneToOne.entity.Instructor;
import Mapping.OneToOne.entity.InstructorDetail;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AppRepository  extends JpaRepository<InstructorDetail,Long>{

}
