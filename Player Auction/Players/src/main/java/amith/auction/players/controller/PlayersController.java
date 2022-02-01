package amith.auction.players.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import amith.auction.players.customentity.CustomTeam;
import amith.auction.players.entity.Player;
import amith.auction.players.exception.CustomException;
import amith.auction.players.service.PlayerService;

@RestController
@RequestMapping(path="/players")
public class PlayersController {
	
	@Autowired
	private PlayerService service;

	public PlayersController(PlayerService service) {
		super();
		this.service = service;
	}
	
	@PostMapping(path="/add")
	public ResponseEntity<String> addPlayer(@RequestBody Player player)
	{
		try {
			return new ResponseEntity<String>(service.addNewPlayer(player),HttpStatus.OK);
		}
		catch(CustomException e)
		{
			return new ResponseEntity(e,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(path="/update/{pid}/{type}")
	public ResponseEntity<String> updatePlayer(@PathVariable Long pid,@PathVariable String type){
		try {
			return new ResponseEntity<String>(service.updateExistingPlayer(pid,type),HttpStatus.OK);
		}
		catch(CustomException e)
		{
			return new ResponseEntity(e,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="/delete/{pid}")
	public ResponseEntity<String> deletePlayer(@PathVariable Long pid){
		try {
			return new ResponseEntity<String>(service.deleteExistingPlayer(pid),HttpStatus.OK);
		}
		catch(CustomException e)
		{
			return new ResponseEntity(e,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path="/getByType/{type}")
	public ResponseEntity<Iterable<Player>> getByType(@PathVariable String type)
	{
		try {
			return new ResponseEntity<Iterable<Player>>(service.getPlayersByType(type),HttpStatus.OK);
		}
		catch(CustomException e)
		{
			return new ResponseEntity(e,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path="/getById/{pid}")
	public ResponseEntity<Player> getByType(@PathVariable Long pid)
	{
		try {
			return new ResponseEntity<Player>(service.getPlayerById(pid),HttpStatus.OK);
		}
		catch(CustomException e)
		{
			return new ResponseEntity(e,HttpStatus.NOT_FOUND);
		}
	}
}
