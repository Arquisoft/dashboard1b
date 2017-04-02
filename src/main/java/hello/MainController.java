package hello;


import org.apache.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import asw.DBManagement.model.Sugerencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class MainController {

    private static final Logger logger = Logger.getLogger(MainController.class);

    @RequestMapping("/")
    public String landing(Model model) {
        return "login";
    }
    
//    public ResponseBodyEmitter newSugerence(String data){
//    	final SseEmitter emitter = new SseEmitter();
//    	try {
//			emitter.send(data, MediaType.APPLICATION_JSON);
//		} catch (IOException e) {
//			e.printStackTrace();
//            emitter.completeWithError(e);
//		}
//    	emitter.complete();
//    	return emitter;
//    }
    
}