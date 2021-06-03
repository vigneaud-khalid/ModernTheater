package theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import theatre.model.Billet;

public interface BilletRepository extends JpaRepository<Billet, String> {

}
