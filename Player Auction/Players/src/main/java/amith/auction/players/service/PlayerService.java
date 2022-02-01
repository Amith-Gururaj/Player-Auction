package amith.auction.players.service;

import amith.auction.players.entity.Player;
import amith.auction.players.exception.CustomException;

public interface PlayerService {

	public String addNewPlayer(Player player) throws CustomException;

	public String updateExistingPlayer(Long pid, String type) throws CustomException;

	public String deleteExistingPlayer(Long pid) throws CustomException;

	public Iterable<Player> getPlayersByType(String type) throws CustomException;

	public Player getPlayerById(Long pid) throws CustomException;

}
