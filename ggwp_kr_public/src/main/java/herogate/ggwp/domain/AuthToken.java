package herogate.ggwp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class AuthToken {

	@Id // primary key
	@Column(name = "idx")
	private @GeneratedValue(strategy = GenerationType.IDENTITY) // generated auto_increment IDENTITY SEQUENCE TABLE AUTO
	Long idx;

	@Column(nullable = false, unique = true)
	String name;

	@Column(nullable = true, unique = true)
	String token;

	@Builder
	public AuthToken(Long idx, String name, String token) {
		this.idx = idx;
		this.name = name;
		this.token = token;
	}
}
