package participants.errores;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "MENESNSN")
public class HTTP404Exception extends RuntimeException{
	
		private static final long serialVersionUID = 1L;
		
		public HTTP404Exception() {
		}

		public HTTP404Exception(String message) {
			super(message);
		}

		public HTTP404Exception(Throwable cause) {
			super(cause);
		}

		public HTTP404Exception(String message, Throwable cause) {
			super(message, cause);
		}
		
		
		public String getMessageJSON()
		{
			return "{\"message\": \"" + getMessage() +"\"}";
		}
}
