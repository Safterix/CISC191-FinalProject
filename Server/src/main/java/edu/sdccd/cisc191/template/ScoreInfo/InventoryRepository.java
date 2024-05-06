package edu.sdccd.cisc191.template.ScoreInfo;

import edu.sdccd.cisc191.template.ItemTypes.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InventoryRepository extends CrudRepository<Inventory, String> {

}
