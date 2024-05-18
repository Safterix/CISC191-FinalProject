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
    @Autowired
    PlayerRepository playerRepo;

    @Autowired
    NPCRepository NPCrepo;



    public NPC save(NPC npc){
        return NPCrepo.save(npc);
    }
    public Player save(Player player){
        return playerRepo.save(player);
    }
    public List<Player> findAllPlayer() {
        return (List<Player>) playerRepo.findAll(); }

    public List<NPC> findAllNPC() {
        return (List<NPC>) NPCrepo.findAll(); }

}
