package herogate.ggwp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import herogate.ggwp.domain.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

	public List<Game> findByOrderByIdxDesc();

	public Optional<Game> findByName(Optional<String> name);

	public Optional<Game> findByIdx(Long idx);
}