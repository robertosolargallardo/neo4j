package cl.tbd.neo4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
    @Transactional(readOnly = true)
    public Person findByName(String name) {
        Person result = personRepository.findByName(name);
        return result;
    }
}

