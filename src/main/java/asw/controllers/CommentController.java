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
import asw.services.CitizenDBService;
import asw.services.CommentsService;
import asw.services.SuggestionService;
import asw.services.VoteCommentService;

@Scope("session")
@Controller
public class CommentController {
	
	//Descomentar cuando funciones service
//	@Autowired
//	private SuggestionService suggestionService;
//	@Autowired
//	private CitizenDBService citizenDBService;
//	@Autowired
//	private CommentsService commentsService;	
//	@Autowired
//	private VoteCommentService voteCommentService;
	
	private Set<Suggestion> sugerencias = new HashSet<Suggestion>();
	private Set<Comment> comments = new HashSet<Comment>();
	
	@RequestMapping(value="/user/comment/commentSuggestion")
    public String commentSuggestion( @RequestParam String comentario, HttpSession session){
     
		CitizenDB user = (CitizenDB) session.getAttribute("usuario");
		Suggestion suggestion = (Suggestion) session.getAttribute("sugerencia");
		Comment comment = new Comment((long)comments.size()+1, user, suggestion, comentario);
		
		//Esto cuando funcione el service
		//commentsService.createComment(comment);
		//comments = (Set<Comment>) commentsService.findBySuggestion(suggestion);
		//session.setAttribute("comments", comments);
		
		// AHORA 
		comments = suggestion.getComments();
		session.setAttribute("sugerencia", suggestion);
		session.setAttribute("comments", comments);
		
		return "user/comment";
		
	}
	
	@RequestMapping(value="user/comment")
    public String showComments(Long id_sug,String comment,HttpSession session){
    	//Cuando tengamso Service    
//    	Suggestion suggestion = suggestionService.findById(id_sug);
//    	comments = (Set<Comment>) commentsService.findBySuggestion(suggestion);
//    	session.setAttribute("suggestion", suggestion);
//    	session.setAttribute("comments", comments);
    	
    	
    	//Esto ahora
    	Suggestion suggestion1 = null;
    	CitizenDB citizenDB = (CitizenDB) session.getAttribute("usuario");
    	sugerencias = (Set<Suggestion>) session.getAttribute("sugerencias");
    	for(Suggestion suggestion : sugerencias)
    		if(suggestion.getId() == id_sug)
    			suggestion1 = suggestion;
    			
    	Comment com= new Comment((long)comments.size()+1,citizenDB, suggestion1, "Comentario de prueba");
    	comments = suggestion1.getComments();
    	session.setAttribute("sugerencia", suggestion1);
    	session.setAttribute("comments", comments);
    	   
    	return "user/comment";
    }
	
	 @RequestMapping(value="/votaPosComment")
	    public String votePosComment(String id_con , HttpSession session){
	    	
		 //Cuando tengamos service
		   //Comment commet = commentsService.fingById(Long.parseLong(id_con));
		 	
		 
		 	//AHORA 
		 	Suggestion suggestion = (Suggestion) session.getAttribute("sugerencia");
		 	Comment comment = null;
		 	for(Comment con : suggestion.getComments())
		 		if(con.getId() == Long.parseLong(id_con))
		 			comment = con;
		 
		 	boolean existe = false;		 	
		 	CitizenDB user = (CitizenDB) session.getAttribute("usuario");
		 	for(VoteComment comment1: user.getVotesComments())
		 		if(comment1.getComment().getId() == Long.parseLong(id_con))
		 			existe = true;
			if(!existe){
				
				VoteComment  voteComment = new VoteComment((long)1,comment,user);
				Set<Comment> aux = (Set<Comment>) session.getAttribute("comments");
				for(Comment comment1 : aux)
	    		if(comment1.getId() == Long.parseLong(id_con)){ //sino nos quedaríamos en negativo en los votos
	    			comment1.setNumero_votos(comment1.getNumero_votos()+1);
	    			//commentService.update(comment);
	    		}
			}
	    	session.setAttribute("comments", comments);
	    	
	    	return "user/comment";
	    }
	    
	    @RequestMapping(value="/votaNegComment")
	    public String voteNegComment(String id_con , HttpSession session){
	    	 //Cuando tengamos service
			   //Comment commet = commentsService.fingById(Long.parseLong(id_con));
			 	
			 
			 	//AHORA 
			 	Suggestion suggestion = (Suggestion) session.getAttribute("sugerencia");
			 	Comment comment = null;
			 	for(Comment con : suggestion.getComments())
			 		if(con.getId() == Long.parseLong(id_con))
			 			comment = con;
			 
			 	boolean existe = false;		 	
			 	CitizenDB user = (CitizenDB) session.getAttribute("usuario");
			 	for(VoteComment comment1: user.getVotesComments())
			 		if(comment1.getComment().getId() == Long.parseLong(id_con))
			 			existe = true;
				if(!existe){
					
					VoteComment  voteComment = new VoteComment((long)1,comment,user);
					Set<Comment> aux = (Set<Comment>) session.getAttribute("comments");
					for(Comment comment1 : aux)
		    		if(comment1.getId() == Long.parseLong(id_con)){ 
		    			if(comment1.getNumero_votos()>0)//sino nos quedaríamos en negativo en los votos
		    				comment1.setNumero_votos(comment1.getNumero_votos()-1);
		    				//commentService.update(comment);
		    		}
				}
		    	session.setAttribute("comments", comments);
		    	
		    	return "user/comment";
		    }

}
