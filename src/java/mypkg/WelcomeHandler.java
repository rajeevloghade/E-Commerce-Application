package mypkg;


import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class WelcomeHandler extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            out.println("<marquee><h3 style=color:blue>WELCOME TO ONLINE STORE<h3></marquee>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
