package com.gameOfThrones.got;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlaceDataRepo extends JpaRepository<DataEntity, BigInteger> {


}
