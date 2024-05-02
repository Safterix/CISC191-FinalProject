package edu.sdccd.cisc191.template.ScoreInfo;

import edu.sdccd.cisc191.template.Characters.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepo extends CrudRepository<Player, String> {

}
