package asw.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asw.model.CitizenDB;
import asw.model.Comment;
import asw.model.Suggestion;
import asw.model.VoteComment;
import asw.model.VoteSuggestion;
import asw.services.SuggestionService;

@Scope("session")
@Controller
public class SuggestionController {
	
	//Descomentar cuando funciones service
//	@Autowired
//	private SuggestionService suggestionService;
//	@Autowired
//	private CitizenDBService citizenDBService;
//	@Autowired
//	private CommentsService commentsService;
	
//	public void setSuggestionService(SuggestionService suggestionService) {
//		this.suggestionService = suggestionService;
//	}


	private Set<Suggestion> sugerencias = new HashSet<Suggestion>();
	private Set<Comment> comments = new HashSet<Comment>();
	
	
  	@RequestMapping(value="/user/suggestion/makeSuggestion")
    public String makeSuggestion(@RequestParam String titulo, @RequestParam String contenido, HttpSession session){
     
		CitizenDB user = (CitizenDB) session.getAttribute("usuario");
		sugerencias = (Set<Suggestion>) session.getAttribute("sugerencias");
		Suggestion suggestion = new Suggestion((long)user.getSugerencias().size()+1,titulo, user);
		suggestion.setContent(contenido);
		sugerencias.add(suggestion);
		//Esto cuando funcione el service
		//suggestionService.createSuggestion(suggestion);
		//sugerencias = suggestionService.findAll();
		//session.setAttribute("sugerencias", sugerencias);
		
		// AHORA 
		session.setAttribute("sugerencias", sugerencias);
		
		return "user/home";
		
		
}
  	
  	 	@RequestMapping(value="/votaPosSuggestion")
  	     public String votePosSuggestion(String id_sug,HttpSession session){
  	 	  	
  			 //Cuando tengamos service
  			   //Suggestion suggestion = suggestionService.fingById(Long.parseLong(id_sug));
  			 	
  			 
  			 	//AHORA 
  			 	Suggestion suggestion = (Suggestion) session.getAttribute("sugerencia");
  			 	Set<Suggestion> suggestions = (Set<Suggestion>) session.getAttribute("sugerencias");
  			 	for(Suggestion sug : suggestions)
  			 		if(sug.getId() == Long.parseLong(id_sug))
  			 			suggestion = sug;
  			 
  			 	boolean existe = false;		 	
  			 	CitizenDB user = (CitizenDB) session.getAttribute("usuario");
  			 	for(VoteSuggestion voteSuggestion: user.getVotesSugerencias())
  			 		if(voteSuggestion.getSuggestion().getId() == Long.parseLong(id_sug))
  			 			existe = true;
  				if(!existe){
  					
  					VoteSuggestion  voteSuggestion = new VoteSuggestion((long)1,user,suggestion);
  					Set<Suggestion> aux = (Set<Suggestion>) session.getAttribute("sugerencias");
  					for(Suggestion suggestion2 : aux)
  		    		if(suggestion2.getId() == Long.parseLong(id_sug)){ //sino nos quedaríamos en negativo en los votos
  		    			suggestion2.setNum_votes(suggestion2.getNum_votes()+1);
  		    			//suggestionService.update(suggestion2);
  		    		}
  				}
  		    	session.setAttribute("sugerencias", suggestions);
  		    	
  		    	return "user/home";
  	 	}
  	     
  	     @RequestMapping(value="/votaNegSuggestion")
  	     public String voteNegSuggestion(String id_sug,HttpSession session){
  	    	 //Cuando tengamos service
			   //Suggestion suggestion = suggestionService.fingById(Long.parseLong(id_sug));
			 	
			 
			 	//AHORA 
			 	Suggestion suggestion = (Suggestion) session.getAttribute("sugerencia");
			 	Set<Suggestion> suggestions = (Set<Suggestion>) session.getAttribute("sugerencias");
			 	for(Suggestion sug : suggestions)
			 		if(sug.getId() == Long.parseLong(id_sug))
			 			suggestion = sug;
			 
			 	boolean existe = false;		 	
			 	CitizenDB user = (CitizenDB) session.getAttribute("usuario");
			 	for(VoteSuggestion voteSuggestion: user.getVotesSugerencias())
			 		if(voteSuggestion.getSuggestion().getId() == Long.parseLong(id_sug))
			 			existe = true;
				if(!existe){
					
					VoteSuggestion  voteSuggestion = new VoteSuggestion((long)1,user,suggestion);
					Set<Suggestion> aux = (Set<Suggestion>) session.getAttribute("sugerencias");
					for(Suggestion suggestion2 : aux)
		    		if(suggestion2.getId() == Long.parseLong(id_sug)){
		    			if(suggestion2.getNum_votes()>0){//sino nos quedaríamos en negativo en los votos
		    				suggestion2.setNum_votes(suggestion2.getNum_votes()-1);
		    				//suggestionService.update(suggestion2);
		    			}
		    		}
				}
		    	session.setAttribute("sugerencias", suggestions);
		    	
		    	return "user/home";
	 	}
    
    //De momento no funciona correctamente
//    @RequestMapping(value="/user/suggestion")
//    public String goMakeSuggestion(@RequestParam String id_sug,HttpSession session){
//    	//de nuevo en este método
//    	//sería lógico buscar la sugerencia
//    	//por id a través de un servicio
//    	//no obstante a falta de funcionamiento de los mismos iré
//    	//buscando las sugerencias en la lista creada 
//    	//en la misma session del usuario
//    	Long id = Long.parseLong(id_sug);
//		//Descomentar cuando solucionemos el error
////    	Suggestion suggestion = new Suggestion();
////    	suggestion = SuggestionService.findById(id);
//		
////    	session.setAttribute("sugerencia", suggestion);
//    	
//    	return "user/suggestion";
//    }

}
