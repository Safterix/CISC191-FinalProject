package edu.sdccd.cisc191.template.ScoreInfo;

import edu.sdccd.cisc191.template.ItemTypes.Knowlege;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KnowlegeRepository extends CrudRepository<Knowlege, String> {

}
