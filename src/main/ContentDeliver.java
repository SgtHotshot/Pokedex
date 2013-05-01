package main;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simpleDB.SimpleDBHelper;

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
		String requestId = request.getParameter("ID");
		String requestName = request.getParameter("Name");

		// get values from db
		SimpleDBHelper sdb = new SimpleDBHelper();
		Map<String, String> answers = null;
		
		if(requestId == null && requestName != null){
			answers = sdb.getPokemonByName(requestName);
		}else if(requestId != null && requestName == null){
			answers = sdb.getPokemonByID(requestId);
		}
		
		JSONObject result = new JSONObject();
		
		if(answers != null){
			String pokemonId = answers.get("ID");
			String name = answers.get("Name");
			String species = answers.get("Species");
			String height = answers.get("Height");
			String weight = answers.get("Weight (lbs)");
			String type = answers.get("Type");
			String weakness = answers.get("Weaknesses");
			String imageUrl = answers.get("URL");
		
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
