package blogz;

import java.util.Date;
import java.util.Objects;

public class Post extends Entity {
	
	private String author;
	private String title;
	private String body;
	private final Date created = new Date();
	private Date modified;
	
	public Post(String auth, String title, String body) {
		super();
		this.author = auth;
		this.title = title;
		this.body = body;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		this.modified = new Date();
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
		this.modified = new Date();
	}

	public Date getModified() {
		return modified;
	}

	public Date getCreated() {
		return created;
	}
	
	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		if (!(o instanceof Post)) return false;
		Post p = (Post) o;
		return Objects.equals(author, p.author) && Objects.equals(created, p.created) && Objects.equals(body, p.body);
	}

}
