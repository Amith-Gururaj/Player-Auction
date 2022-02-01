package amith.auction.teams.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amith.auction.teams.entity.Team;
import amith.auction.teams.exception.CustomException;
import amith.auction.teams.repository.TeamRepository;
import amith.auction.teams.service.TeamService;

@Service
public class TeamServiceImplementation implements TeamService
{
	@Autowired
	private TeamRepository teamrepo;

	public TeamServiceImplementation(TeamRepository teamrepo) {
		super();
		this.teamrepo = teamrepo;
	}

	@Override
	public String addNewTeam(Team team) throws CustomException
	{
		Team checkteam = teamrepo.findByName(team.getName());
		if(checkteam!=null)
		{
			throw new CustomException(team.getName()+" Team is already Exists");
		}
		else
		{
			teamrepo.save(team);
			return team.getName()+" Team Added Successfully";
		}		
	}

	@Override
	public Iterable<Team> getAllTeams() {
		return teamrepo.findAll();
	}

	@Override
	public Team getByName(String name) throws CustomException {
		Team team = teamrepo.findByName(name);
		if(team!=null)
		{
			return team;
		}
		else
		{
			throw new CustomException("No such team is there in the database");
		}
	}

	@Override
	public String updateBudgetByName(String name, float budget) throws CustomException {
		Team team = teamrepo.findByName(name);
		if(team!=null)
		{
			teamrepo.updateBudgetOfTeam(name,budget);
			return "Budget Updated Successfully";
		}
		else
		{
			throw new CustomException("No such team is there in the database");
		}
	}

	@Override
	public String updateCountByName(String name, Boolean count) throws CustomException {
		Team team = teamrepo.findByName(name);
		if(team!=null)
		{
			if(count)
			{
				
			}
			else
			{
				
			}
			return "No.Of Players Updated Successfully";
		}
		else
		{
			throw new CustomException("No such team is there in the database");
		}
	}
	
	
}
