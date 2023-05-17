package Tracy.web.service;

import Tracy.web.model.Prisoner;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PrisonerService {
	List<Prisoner> getAllPrisoners();
	void savePrisoner(Prisoner prisoner);
	Prisoner getPrisonerById(long id);
	void deletePrisonerById(long id);
	Page<Prisoner> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}