package by.academy.rms.web.controller;

import by.academy.rms.pojos.Page;
import by.academy.rms.service.task.IService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class BaseController {

    @Autowired
    private IService iService;

    @RequestMapping( value = "/", method = RequestMethod.GET )
    public String home( HttpServletRequest request ) throws Exception {

        HttpSession session = request.getSession( false );

        if ( session != null ) {

            session.removeAttribute( "id" );
            session.removeAttribute( "isStarted" );
        }

        return "welcome";
    }

    @RequestMapping( value = "/pages.html", method = RequestMethod.GET )
    public String getNumberOfPages( HttpServletRequest request ) throws Exception {

        if ( !verifySession( request ) )
            return ( "redirect:/" );

        HttpSession session = request.getSession( false );

        if ( session.getAttribute( "id" ) != null  )
            return ( "redirect:/pageDetail.html?id=" + session.getAttribute( "id" ) );

        session.setAttribute( "isStarted", true );

        iService.setType( Page.class );
        Criteria criteria = iService.getCriteria();
        criteria.setProjection( Projections.rowCount() );

        request.getSession().setAttribute( "pages", criteria.list().get( 0 ) );

        return "listOfPages";
    }

    @RequestMapping( value = "/pageDetail.html", params = { "id" }, method = RequestMethod.GET )
    public String getPageDetails( HttpServletRequest request, Map< String, Object > model ) throws Exception {

        if ( !verifySession( request ) )
            return ( "redirect:/" );

        HttpSession session = request.getSession( false );

        if ( session.getAttribute( "isStarted" ) == null  )
            return ( "redirect:/" );

        Long id = Long.parseLong( request.getParameter( "id" ) );

        session.setAttribute( "id", id );

        iService.setType( Page.class );

        model.put( "page", iService.get( id ) );

        return "pageDetail";
    }

    private boolean verifySession( HttpServletRequest request ) {

        HttpSession session = request.getSession( false );

        if( session == null )
            return false;

        return true;
    }
}