package theatre.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import theatre.model.Token;


public interface TokenRepository extends JpaRepository<Token, Integer>{
	
	@Query("select t from Token t where t.valeur =:paramValeur")
	public Optional<Token> selectByValeur(String paramValeur);
}