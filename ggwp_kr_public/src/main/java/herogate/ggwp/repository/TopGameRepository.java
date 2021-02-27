package herogate.ggwp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import herogate.ggwp.domain.TopGame;

public interface TopGameRepository extends JpaRepository<TopGame, Long> {
	public List<TopGame> findByOrderByIdxDesc();

	public Optional<TopGame> findByName(Optional<String> name);

	public Optional<TopGame> findByIdx(Long idx);

}