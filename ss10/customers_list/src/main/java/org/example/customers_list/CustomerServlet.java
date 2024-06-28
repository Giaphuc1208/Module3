package org.example.customers_list;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "CustomerServlet",value = "/customer")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customers> customersList = new ArrayList<>();
        customersList.add(new Customers("Trần Văn Sỷ","31/7/1998","QN","https://scontent.fdad3-6.fna.fbcdn.net/v/t1.15752-9/449047725_1686558385414849_4665688379849080790_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=9f807c&_nc_ohc=oQWQilysxQkQ7kNvgGXEIp0&_nc_ht=scontent.fdad3-6.fna&oh=03_Q7cD1QGwOzDcAa2JS-i9e7sFHgi6Pqh5tnt7P9cVyjtKjh05Sg&oe=66A64288"));
        customersList.add(new Customers("Phạm Trường Hội","16/5/1999","QN","https://www.facebook.com/messenger_media?attachment_id=1686558382081516&message_id=mid.%24cAABa9h7AtNmWkOKV4GQX51Es61k6&thread_id=100013124400345"));
        customersList.add(new Customers("Huỳnh Dương Nhất","08/01/2002","PY","https://scontent.fdad3-6.fna.fbcdn.net/v/t1.15752-9/448872560_489060023486651_3812664156595048202_n.jpg?stp=dst-jpg_p1080x2048&_nc_cat=109&ccb=1-7&_nc_sid=9f807c&_nc_ohc=WLH7MqBLAUMQ7kNvgExgQXX&_nc_ht=scontent.fdad3-6.fna&oh=03_Q7cD1QFiXUBVQedZhzQFZuE3xI8LXjr7_8iMcWAfARPTigP-tg&oe=66A663F4"));
        customersList.add(new Customers("Lê Văn Cường","06/01/2001","QN","https://scontent.fdad3-6.fna.fbcdn.net/v/t1.15752-9/448807705_1668989460623331_4954966788241808634_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=9f807c&_nc_ohc=SmRSNnkEudoQ7kNvgGlg2ir&_nc_ht=scontent.fdad3-6.fna&oh=03_Q7cD1QFahYJMz42oidZ2Jg7WFFpHvtQnWFbuEi7wEM7ePx3ehQ&oe=668030CA"));
        req.setAttribute("list", customersList);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
