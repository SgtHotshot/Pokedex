package main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;

/**
 * Servlet implementation class ContentDeliver
 */
public class ContentDeliver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContentDeliver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");
		
		// get values from db
		
		String pokemonId = "";
		String name = "";
		String species = "";
		String height = "";
		String weight = "";
		String type = "";
		String weakness = "";
		String imageUrl = "";
		
		JSONObject result = new JSONObject();
		try {
			result.put("pokemonId",pokemonId);
			result.put("name",name);
			result.put("species",species);
			result.put("height",height);
			result.put("weight",weight);
			result.put("type",type);
			result.put("weakness",weakness);
			result.put("imageUrl",imageUrl);
		} catch (JSONException e) {
			System.out.println("JSON object failed to create.");
		}
		
		response.getWriter().print(result.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
