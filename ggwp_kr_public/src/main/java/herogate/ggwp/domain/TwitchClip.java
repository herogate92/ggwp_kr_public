package herogate.ggwp.domain;

import lombok.Data;

@Data
@Deprecated
public class TwitchClip {
	String id;
	String url;
	String embed_url;
	String broadcaster_id;
	String broadcaster_name;
	String creator_id;
	String creator_name;
	String video_id;
	String game_id;
	String language;
	String title;
	String view_count;
	String created_at;
	String thumbnail_url;
}
