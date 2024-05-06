package edu.sdccd.cisc191.template.ScoreInfo;

import edu.sdccd.cisc191.template.Characters.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends CrudRepository<Player, String> {

}
