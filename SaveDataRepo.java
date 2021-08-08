package com.gameOfThrones.got;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaveDataRepo extends JpaRepository<DataEntity, String> {

}
