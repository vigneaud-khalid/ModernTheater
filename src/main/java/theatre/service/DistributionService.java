package theatre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import theatre.model.Distribution;
import theatre.repository.DistributionRepository;

@Service
public class DistributionService {
	
	@Autowired
	private DistributionRepository distributionRepository;
	
	public List<Distribution>  rolesParPiece(int idJeu){
		return distributionRepository.rolesParPiece(idJeu);
	}

}
