package amith.auction.players.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import amith.auction.players.entity.Player;

@Transactional
@Repository
public interface PlayerRepository extends JpaRepository<Player,Long>{

	public List<Player> findByTname(String tname);

	public Player findByPid(Long pid);
	
	@Modifying
	@Query("update Player set ptype=?2 where pid=?1")
	public int updatePlayerData(Long pid, String type);

	public List<Player> findByPtype(String type);

}
