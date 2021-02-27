package herogate.ggwp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import herogate.ggwp.domain.Clip;

public interface ClipRepository extends JpaRepository<Clip, Long> {
	public List<Clip> findByTitleLike(String keyword);

	public List<Clip> findTop40ByOrderByIdxDesc();

	public List<Clip> findTop40ByGameIdOrderByIdxDesc(String gameId);
}