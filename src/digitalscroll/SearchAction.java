package digitalscroll;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import java.util.List;
import java.util.HashMap;

import org.quickconnect.json.JSONException;
import org.quickconnect.json.JSONOutputStream;

public class SearchAction implements IAction {

	@Override
	public void execute(final Object data) {
		HashMap<String, Object> params = (HashMap)data;
		String searchTerm = (String)params.get("data");
		JSONOutputStream jout = (JSONOutputStream)params.get("out");
		Session session = Database.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from article where content like :term");
		query.setParameter("term", searchTerm);
		List<Article> results = query.list();
		
		// Return articles back to client
		for (Article article : results) {
			try {
				jout.writeObject(article);
			}
			catch (JSONException e) {
				e.printStackTrace();
			}
		}
		jout.close();
	}
}
