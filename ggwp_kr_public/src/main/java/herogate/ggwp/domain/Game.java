package herogate.ggwp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class Game {
	@Id // primary key
	@Column(name = "idx")
	private Long idx;

	@Column(nullable = false, unique = true)
	String name;

	@Column(name = "box_art_url")
	@Setter
	String boxArtUrl;

	@Builder
	public Game(Long idx, String name, String boxArtUrl) {
		this.idx = idx;
		this.name = name;
		this.boxArtUrl = boxArtUrl;
	}

}
