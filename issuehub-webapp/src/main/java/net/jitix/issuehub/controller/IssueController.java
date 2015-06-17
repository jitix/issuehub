package net.jitix.issuehub.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.jitix.issuehub.controller.exception.AuthorizationException;
import net.jitix.issuehub.entity.Issue;
import net.jitix.issuehub.exception.AppException;
import net.jitix.issuehub.service.IssueService;
import net.jitix.issuehub.util.ControllerUtil;
import net.jitix.issuehub.vo.IssueInfo;
import net.jitix.issuehub.vo.IssueUpdationDetails;
import net.jitix.issuehub.vo.NewIssueDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/issues")
public class IssueController {

    private static final Logger LOG = LoggerFactory.getLogger(IssueController.class);

    @Autowired
    private IssueService issueService;

    @RequestMapping(value = "/", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Issue createIssue(@RequestBody NewIssueDetails newIssueDetails,
            HttpServletRequest request, HttpServletResponse response)
            throws AuthorizationException, Exception {
        ControllerUtil.checkValidSession(request.getSession());

        Integer issueNumber = this.issueService.createNewIssue(newIssueDetails);

        Issue issueDetails = this.issueService.getIssue(issueNumber);

        return issueDetails;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<IssueInfo> listIssues(
            HttpServletRequest request, HttpServletResponse response)
            throws AuthorizationException, AppException {
        ControllerUtil.checkValidSession(request.getSession());

        return this.issueService.listIssues();
    }

    @RequestMapping(value = "/{issueNumber}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateIssueDetails(@PathVariable Integer issueNumber,
            @RequestBody IssueUpdationDetails issueUpdDetails,
            HttpServletRequest request, HttpServletResponse response)
            throws AuthorizationException, AppException {

        ControllerUtil.checkValidSession(request.getSession());

        this.issueService.updateIssue(issueNumber, issueUpdDetails.getSaveIssueDetails(), issueUpdDetails.getCommentDetails());
    }

    @RequestMapping(value = "/{issueNumber}", method = RequestMethod.DELETE)
    public void deleteIssue(@PathVariable Integer issueNumber,
            HttpServletRequest request, HttpServletResponse response)
            throws AuthorizationException, AppException {

        ControllerUtil.checkValidSession(request.getSession());

        this.issueService.deleteIssue(issueNumber);
    }

    @RequestMapping(value = "/{issueNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Issue getUserDetails(@PathVariable Integer issueNumber,
            HttpServletRequest request, HttpServletResponse response)
            throws AuthorizationException, AppException {

        ControllerUtil.checkValidSession(request.getSession());

        return this.issueService.getIssue(issueNumber);
    }

}
