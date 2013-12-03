package digitalscroll;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "article")
public class Article implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "author")
	@Type(type = "varchar")
	private String author;
	
	@Column(name = "publish_date")
	@Type(type = "date")
	private Date publishDate;
	
	@Column
	@Type(type = "text")
	private String content;
	
	@Column
	@Type(type = "varchar")
	private String image;
	
	@Column
	@Type(type = "varchar")
	private String headline;
	
	@Column
	@Type(type = "varchar")
	private String category;

	@Column(name = "active_flag")
	@Type(type = "varchar")
	private String active;
	
	public Article() {
		
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Integer getId() {
		return id;
	}
}
