package com.crudoperationRestApi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsreRepo extends JpaRepository<User, Long>{

}
