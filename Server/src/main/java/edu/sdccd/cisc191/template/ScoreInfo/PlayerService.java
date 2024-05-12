package edu.sdccd.cisc191.template.ScoreInfo;

import edu.sdccd.cisc191.template.Characters.NPC;
import edu.sdccd.cisc191.template.Characters.Player;

import edu.sdccd.cisc191.template.Characters.Character;
import edu.sdccd.cisc191.template.ItemTypes.Inventory;
import edu.sdccd.cisc191.template.ItemTypes.Item;
import edu.sdccd.cisc191.template.ScoreInfo.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
//    @Autowired
//    PlayerRepository<Player> playerRepo;
//    @Autowired
//    InventoryRepository invRepo;
//    @Autowired
//////    ItemRepository itemRepo;
//    @Autowired
//    CharacterRepository<NPC> npcRepository;
//    @Autowired
//    GoodsRepository goodsRepository;
//    @Autowired
//    ConsumableRepository consumableRepo;
////    @Autowired
//    KnowlegeRepository knowledgeRepo;
    @Autowired
    NPCRepository NPCrepo;



    public NPC save(NPC npc){
        return NPCrepo.save(npc);
    }
//    public Character save(Character character){
//        return characterRepo.save(character);
//    }
//    public Inventory save(Inventory inventory){
//
//        return invRepo.save(inventory);
//    }
//
//    public Item save(Item item){
//
//        return itemRepo.save(item);
//    }

    public List<NPC> findAll() {
        return (List<NPC>) NPCrepo.findAll(); }

}
