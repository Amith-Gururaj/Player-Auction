package amith.auction.players.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import amith.auction.players.customentity.CustomTeam;
import amith.auction.players.entity.Player;
import amith.auction.players.exception.DataNotFoundException;
import amith.auction.players.exception.LimitExceededException;
import amith.auction.players.repository.PlayerRepository;
import amith.auction.players.service.PlayerService;

@Service
public class PlayerServiceImplementation implements PlayerService
{
	@Autowired
	private PlayerRepository playerrepo;
	
	@Autowired
	private RestTemplate restTemplate;

	public PlayerServiceImplementation(PlayerRepository playerrepo, RestTemplate restTemplate) {
		super();
		this.playerrepo = playerrepo;
		this.restTemplate = restTemplate;
	}

	@Override
	public String addNewPlayer(Player player) throws LimitExceededException,DataNotFoundException {
		CustomTeam cteam = restTemplate.getForObject("http://localhost:9002/teams/getByName/"+player.getTname(), CustomTeam.class);
		if(cteam!=null)
		{
			if(cteam.getNoofplayers()!=11)
			{
				List<Player> players = playerrepo.findByTname(player.getTname());
				float expenditure = 0;
				for(int i=0;i<players.size();i++)
				{
					expenditure= expenditure+ players.get(i).getAmount();
				}
				if((expenditure+player.getAmount())<=cteam.getMaxbudget())
				{
					playerrepo.save(player);
					restTemplate.put("http://localhost:9002/teams/updatecount/"+player.getTname()+"/"+true,Player.class);
					return "Player Added Successfully";
				}
				else
					throw new LimitExceededException("Maximum Budget Limit Exceeded in this Team");
			}
			else
				throw new LimitExceededException("Number of Player's Limit Exceeded in this Team");
		}
		else
			throw new DataNotFoundException("No such team is there in the database");
	}

	@Override
	public String updateExistingPlayer(Long pid, String type) throws DataNotFoundException {
		Player player = playerrepo.findByPid(pid);
		if(player!=null)
		{
			playerrepo.updatePlayerData(pid,type);
			return "Player Data Updated Successfully";
		}
		else
			throw new DataNotFoundException("No Such Player there in the database");
	}

	@Override
	public String deleteExistingPlayer(Long pid) throws DataNotFoundException {
		Player player = playerrepo.findByPid(pid);
		if(player!=null)
		{
			playerrepo.deleteById(pid);
			return "Player Data Deleted Successfully";
		}
		else
			throw new DataNotFoundException("No Such Player there in the database");
	}

	@Override
	public Iterable<Player> getPlayersByType(String type) throws DataNotFoundException {
		List<Player> players = playerrepo.findByPtype(type);
		if(players.size()>0)
		{
			return players;
		}
		else
			throw new DataNotFoundException("No Such Type of Player there in the database");
	}

	@Override
	public Player getPlayerById(Long pid) throws DataNotFoundException {
		Player player = playerrepo.findByPid(pid);
		if(player!=null)
		{
			return player;
		}
		else
			throw new DataNotFoundException("No Such Player there in the database");
	}
	
}
