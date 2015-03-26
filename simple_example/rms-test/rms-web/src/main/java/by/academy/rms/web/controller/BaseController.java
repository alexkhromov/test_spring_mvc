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
import java.util.Map;

@Controller
public class BaseController {

    @Autowired
    private IService iService;

    @RequestMapping( value = "/pages.html", method = RequestMethod.GET )
    public String getNumberOfPages( HttpServletRequest request ) throws Exception {

        iService.setType( Page.class );
        Criteria criteria = iService.getCriteria();
        criteria.setProjection( Projections.rowCount() );

        request.getSession().setAttribute( "pages", criteria.list().get( 0 ) );

        return "listOfPages";
    }

    @RequestMapping( value = "/pageDetail.html", params = { "id" }, method = RequestMethod.GET )
    public String getPageDetails( HttpServletRequest request, Map< String, Object > model ) throws Exception {

        Long id = Long.parseLong( request.getParameter( "id" ) );

        iService.setType( Page.class );

        model.put( "page", iService.get( id ) );

        return "pageDetail";
    }
}