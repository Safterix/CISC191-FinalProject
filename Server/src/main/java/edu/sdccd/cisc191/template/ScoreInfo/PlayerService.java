package edu.sdccd.cisc191.template.ScoreInfo;

import edu.sdccd.cisc191.template.Characters.Player;
import edu.sdccd.cisc191.template.ItemTypes.Inventory;
import edu.sdccd.cisc191.template.ItemTypes.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepo;
    @Autowired
    InventoryRepository invRepo;
    @Autowired
    ItemRepository itemRepo;
    @Autowired
    CharacterRepository characterRepo;

    public Player save(Player player){
        return playerRepo.save(player);
    }
    public Character save(Character character){
        return characterRepo.save(character);
    }
    public Inventory save(Inventory inventory){

        return invRepo.save(inventory);
    }

    public Item save(Item item){

        return itemRepo.save(item);
    }

    public List<Player> findAll() {
        return (List<Player>) playerRepo.findAll(); }
}
