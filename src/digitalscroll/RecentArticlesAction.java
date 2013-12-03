package digitalscroll;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.quickconnect.json.JSONException;
import org.quickconnect.json.JSONOutputStream;

public class RecentArticlesAction implements IAction {

	@Override
	public void execute(Object data) {
		HashMap<String, Object> params = (HashMap)data;
		String category = (String)params.get("category");
		JSONOutputStream jout = (JSONOutputStream)params.get("out");
		Session session = Database.getSessionFactory().getCurrentSession();
		//need to modify query so that it returns only recent articles
		Query query = session.createQuery("from article where category = :category");
		query.setParameter("category", category);
		List<Article> results = query.list();
		
		// Return articles back to client
		for (Article article : results) {
			if (((article.getPublishDate().getTime() - new Date().getTime()) / (1000 * 60 * 60 * 24)) < 10) {
				try {
					jout.writeObject(article);
				} 
				catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
