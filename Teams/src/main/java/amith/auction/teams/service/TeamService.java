package amith.auction.teams.service;

import amith.auction.teams.entity.Team;
import amith.auction.teams.exception.CustomException;

public interface TeamService {

	public String addNewTeam(Team team) throws CustomException;

	public Iterable<Team> getAllTeams();

	public Team getByName(String name) throws CustomException;

	public String updateBudgetByName(String name, float budget)throws CustomException;

	public String updateCountByName(String name, Boolean count)throws CustomException;

}
