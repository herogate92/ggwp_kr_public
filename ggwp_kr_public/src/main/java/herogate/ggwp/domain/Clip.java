package herogate.ggwp.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class Clip {
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // generated auto_increment IDENTITY SEQUENCE TABLE AUTO
	private Long idx;

	@Column(nullable = false, unique = true)
	String clipId;

	@Column(nullable = false, unique = true)
	String url;

	@Column(nullable = false, unique = true)
	String embed_url;
	String broadcaster_id;
	String broadcaster_name;
	String creator_id;
	String creator_name;
	String video_id;

	@Column(name = "game_id", nullable = false)
	String gameId;
	String language;
	String title;
	String view_count;
	String created_at;
	String thumbnail_url;

	@Column(name = "created_datetime")
	@CreatedDate
	Date createdDatetime;

	@Builder
	public Clip(String clipId, String url, String embed_url, String broadcaster_id, String creator_id, String video_id,
			String game_id, String language, String title, String view_count, String created_at, String thumbnail_url) {
		this.clipId = clipId;
		this.url = url;
		this.embed_url = embed_url;
		this.broadcaster_id = broadcaster_id;
		this.creator_id = creator_id;
		this.video_id = video_id;
		this.gameId = game_id;
		this.language = language;
		this.title = title;
		this.view_count = view_count;
		this.created_at = created_at;
		this.thumbnail_url = thumbnail_url;
	}

}
