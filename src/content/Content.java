package content;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Content {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ContentException;
}
