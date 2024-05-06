package edu.sdccd.cisc191.template.ScoreInfo;

import edu.sdccd.cisc191.template.ItemTypes.Consumable;
import edu.sdccd.cisc191.template.ItemTypes.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConsumableRepository extends CrudRepository<Consumable, String> {

}
