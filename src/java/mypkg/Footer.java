package mypkg;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Footer extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            out.println("<div class=\"mt-5 text-center\">\n"
                    + "	<br><p style='text-align: center; background-color: #00abff;'>Copyright @2020 All rights reserved by E-Commerce Company.</p>\n"
                    + "	<br></div>");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
