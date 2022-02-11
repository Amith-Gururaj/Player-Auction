package amith.auction.players.service;

import amith.auction.players.entity.Player;
import amith.auction.players.exception.DataNotFoundException;
import amith.auction.players.exception.LimitExceededException;

public interface PlayerService {

	public String addNewPlayer(Player player) throws LimitExceededException,DataNotFoundException ;

	public String updateExistingPlayer(Long pid, String type) throws DataNotFoundException;

	public String deleteExistingPlayer(Long pid) throws DataNotFoundException;

	public Iterable<Player> getPlayersByType(String type) throws DataNotFoundException;

	public Player getPlayerById(Long pid) throws DataNotFoundException;

}
