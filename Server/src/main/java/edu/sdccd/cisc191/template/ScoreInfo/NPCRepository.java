package edu.sdccd.cisc191.template.ScoreInfo;

import edu.sdccd.cisc191.template.Characters.NPC;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NPCRepository extends CrudRepository<NPC, String> {

}
