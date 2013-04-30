package content;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PokemonContent implements Content {

	
	private String id = null;
	
	public PokemonContent(String id){
		this.id = id;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ContentException {
		
		return null;
	}
	
	private String createContent(){
		return null;
	}

}
