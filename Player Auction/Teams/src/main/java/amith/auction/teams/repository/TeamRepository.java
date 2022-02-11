package amith.auction.teams.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import amith.auction.teams.entity.Team;

@Transactional
@Repository
public interface TeamRepository extends JpaRepository<Team,String> 
{

	public Team findByName(String name);

	@Modifying
	@Query("update Team set maxbudget=?2 where name=?1")
	public void updateBudgetOfTeam(String name, float budget);

	@Modifying
	@Query("update Team set noofplayers=?2 where name=?1")
	public void incrementCountOfTeam(String name,int value);

	@Modifying
	@Query("update Team set noofplayers=?2 where name=?1")
	public void decrementCountOfTeam(String name,int value);

}
