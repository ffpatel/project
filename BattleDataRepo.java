package com.gameOfThrones.got;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattleDataRepo extends JpaRepository<DataEntity, String> {


}
