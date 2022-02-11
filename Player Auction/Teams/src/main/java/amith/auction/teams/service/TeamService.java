package amith.auction.teams.service;

import amith.auction.teams.entity.Team;
import amith.auction.teams.exception.ResourceAlreadyExistException;
import amith.auction.teams.exception.ResourceNotFoundException;

public interface TeamService {

	public String addNewTeam(Team team) throws ResourceAlreadyExistException;

	public Iterable<Team> getAllTeams();

	public Team getByName(String name) throws ResourceNotFoundException;

	public String updateBudgetByName(String name, float budget)throws ResourceNotFoundException;

	public String updateCountByName(String name, Boolean count)throws ResourceNotFoundException;

}
