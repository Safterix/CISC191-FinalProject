package edu.sdccd.cisc191.template.ScoreInfo;

import edu.sdccd.cisc191.template.ItemTypes.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository extends CrudRepository<Item, String> {

}
