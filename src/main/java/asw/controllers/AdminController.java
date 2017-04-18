package asw.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asw.model.Comment;
import asw.model.Suggestion;
import asw.services.CitizenDBService;
import asw.services.CommentsService;
import asw.services.SuggestionService;
import asw.services.VoteCommentService;
import asw.services.VoteSuggestionService;

@Scope("session")
@Controller
public class AdminController {
	
	private CitizenDBService citizenService;
	private CommentsService commentService;
	private SuggestionService suggestionService;
	private VoteCommentService vCommentService;
	private VoteSuggestionService vSuggestionService;
	
	
	
	//aunque lo suyo sería buscar todas las sugerencias desde el servicio de momento
	//falla, con lo que voy a crear a pelo una lista de sugerencias e insertar en ellas para
	//ir probando
	//private List<Suggestion> sugerencias = //new SuggestionServiceImpl().findAll();
	
	
	private Set<Suggestion> sugerencias = new HashSet<Suggestion>();
	private Set<Comment> comments = new HashSet<Comment>();
	
	 @RequestMapping(value="/admin/home")
	    public String adminHome(Model model){
	    	return "admin/home";
	    }
	 
	 @RequestMapping(value="/admin/edit")
	    public String adminEdit(String id_sug,HttpSession session){
	     	Set<Suggestion> aux = (Set<Suggestion>) session.getAttribute("sugerencias");
	    	for(Suggestion sug : aux)
	    		if(sug.getId() == Long.parseLong(id_sug)){
	    			session.setAttribute("sugerencia", sug);
	    			session.setAttribute("titulo", sug.getTitle());
	    		}
	    	return "admin/edit";
	    }
	 
	   @RequestMapping(value="/borrar")
	    public String borrar(String id_sug,HttpSession session){
		   Suggestion suggestion  = null;
	    	Set<Suggestion> aux = (Set<Suggestion>) session.getAttribute("sugerencias");
	    	for(Suggestion sug : aux)
	    		if(sug.getId() == Long.parseLong(id_sug))
	    			suggestion = sug;
	    	
	    	aux.remove(suggestion);
	    	sugerencias = aux;
	    	
	    	session.setAttribute("sugerencias", sugerencias);
	    	return "admin/home";
	    }
	       	
		@RequestMapping(value="/admin/edit/editSuggestion")
    	public String editSuggestion(@RequestParam String titulo,
    			@RequestParam String contenido,HttpSession session){
    		//ESTO AHORA
			Set<Suggestion> lista = (Set<Suggestion>) session.getAttribute("sugerencias");
			sugerencias=lista;
    		Suggestion suggestion = (Suggestion) session.getAttribute("sugerencia");
    		Suggestion suggestion2 = suggestion;
    		
    		sugerencias.remove(suggestion);
    		
    		if(!titulo.equals(""))
    			suggestion2.setTitle(titulo);
    		if(!contenido.equals(""))
    		suggestion2.setContent(contenido);
    		
    		sugerencias.add(suggestion2);
    		
    		//Cuando tengamos Service
    		//Suggestion suggestion = (Suggestion) session.getAttribute("sugerencia");
    		//suggestion.setTitle(titulo);
    		//suggestion.setContent(contenido);
    		//suggestionService.update(suggestion);
    		//sugerencias = suggestionService.findAll();
    		
    		session.setAttribute("sugerencia", suggestion2);
    		session.setAttribute("sugerencias", sugerencias);
    		
    		
    		return "admin/home";
    	}

}
