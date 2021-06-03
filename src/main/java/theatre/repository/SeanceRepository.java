package theatre.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import theatre.model.Seance;

public interface SeanceRepository extends JpaRepository<Seance, Integer>{
	
	
	
	@Query("select s from Seance s where s.id = :idSeance")
	public Optional<Seance> findSeanceById(int idSeance); 
	
	
	@Query("select s from Seance s where s.salle.numero = :numeroSalle")
	public Optional<Seance> findBySalleNum(int numeroSalle); 

}
