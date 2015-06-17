package net.jitix.issuehub.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.jitix.issuehub.controller.exception.AuthorizationException;
import net.jitix.issuehub.controller.exception.PermissionException;
import net.jitix.issuehub.entity.IssueType;
import net.jitix.issuehub.exception.AppException;
import net.jitix.issuehub.service.IssueTypeService;
import net.jitix.issuehub.util.ControllerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/issuetypes")
public class IssueTypeController {
    
    private static final Logger LOG = LoggerFactory.getLogger(IssueTypeController.class);
    
    @Autowired
    private IssueTypeService issueTypeService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<IssueType> listIssueTypes(
            HttpServletRequest request, HttpServletResponse response)
            throws AuthorizationException, PermissionException, AppException {
        ControllerUtil.checkValidSession(request.getSession());

        return this.issueTypeService.getIssueTypes();
    }
    
}
