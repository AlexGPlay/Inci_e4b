package asw.agents.webService.responses.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Kind required")
public class RequiredKindResponse extends ErrorResponse{

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessageJSONFormat() {
		return "{\"reason\": \"Kind required\"}";

	}

	@Override
	public String getMessageStringFormat() {
		// TODO Auto-generated method stub
		return "Kind is required";
	}

}
