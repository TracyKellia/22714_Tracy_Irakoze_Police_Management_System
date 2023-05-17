package Tracy.web.service;

import Tracy.web.model.Prisoner;
import Tracy.web.repository.PrisonerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrisonerServiceImpl implements PrisonerService {

	@Autowired
	private PrisonerRepository prisonerRepository;

	@Override
	public List<Prisoner> getAllPrisoners() {
		return prisonerRepository.findAll();
	}

	@Override
	public void savePrisoner(Prisoner prisoner) {
		this.prisonerRepository.save(prisoner);
	}

	@Override
	public Prisoner getPrisonerById(long id) {
		Optional<Prisoner> optional = prisonerRepository.findById(id);
		Prisoner prisoner = null;
		if (optional.isPresent()) {
			prisoner = optional.get();
		} else {
			throw new RuntimeException("Prisoner not found for id :: " + id);
		}
		return prisoner;
	}

	@Override
	public void deletePrisonerById(long id) {
		this.prisonerRepository.deleteById(id);
	}

	@Override
	public Page<Prisoner> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
				Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.prisonerRepository.findAll(pageable);
	}
}