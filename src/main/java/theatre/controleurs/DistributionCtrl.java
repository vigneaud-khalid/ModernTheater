package theatre.controleurs;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import theatre.model.Distribution;
import theatre.model.Distribution;
import theatre.service.DistributionService;

@RestController
@CrossOrigin("*")
public class DistributionCtrl {
	
	@Autowired
	private DistributionService distributionService;
	
	
	@GetMapping("distribution/piece/{id}")
	public ResponseEntity <List<Distribution>> getRolesParPiece(@PathVariable("id") int idPiece) {

		List<Distribution> distributions = distributionService.rolesParPiece(idPiece);

		return ResponseEntity.ok(distributions); 

	

}

}
