package amith.auction.teams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import amith.auction.teams.entity.Team;
import amith.auction.teams.service.TeamService;

@RestController
@RequestMapping(path="/teams")
public class TeamsController 
{
	@Autowired
	private TeamService service;

	public TeamsController(TeamService service) {
		super();
		this.service = service;
	}
	
	@PostMapping(path="/add")
	public ResponseEntity<String> addTeam(@RequestBody Team team)
	{
		return new ResponseEntity<String>(service.addNewTeam(team),HttpStatus.OK);
	}
	
	@GetMapping(path="/get")
	public ResponseEntity<Iterable<Team>> getTeams()
	{
		return new ResponseEntity<Iterable<Team>>(service.getAllTeams(),HttpStatus.OK);
	}
	
	@GetMapping(path="/getByName/{name}")
	public ResponseEntity<Team> getTeamByName(@PathVariable String name)
	{
		return new ResponseEntity<Team>(service.getByName(name),HttpStatus.OK);
	}
	
	@PutMapping(path="/update/{name}/{budget}")
	public ResponseEntity<String> updateBudget(@PathVariable String name, @PathVariable float budget)
	{
		return new ResponseEntity<String>(service.updateBudgetByName(name,budget),HttpStatus.OK);
	}
	
	@PutMapping(path="/updatecount/{name}/{count}")
	public ResponseEntity<String> updateNoOfPlayers(@PathVariable String name, @PathVariable Boolean count)
	{
		return new ResponseEntity<String>(service.updateCountByName(name,count),HttpStatus.OK);
	}
}
