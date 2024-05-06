package edu.sdccd.cisc191.template.ScoreInfo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CharacterRepository extends CrudRepository<Character, String> {

}
