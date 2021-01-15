package com.steven.controller;

import com.steven.pojo.Student;
import com.steven.util.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author CXQ
 * @version 1.0
 */
@RequestMapping("/api/forward")
@Controller
public class ForWardController {

    @RequestMapping("request-forward")
    public void requestForward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/success.html").forward(req, resp);
    }

    @RequestMapping("response-redirect")
    public void responseRedirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.sendRedirect(req.getContextPath() + "/view/success.html");
    }

    @RequestMapping("response-writer")
    public void responseWriter(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().print("response-writer");
    }

    @RequestMapping("string-forward")
    public String stringForward() {
       System.out.println("string-forward...");
       return "forward:string-redirect";
    }

    @RequestMapping("string-redirect")
    public String stringRedirect() {
       System.out.println("string-redirect...");
       return "redirect:/view/success.html";
    }

    @RequestMapping("a")
    public void a(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("使用原生转页:");
        System.out.println("a() => b()...");
        req.getRequestDispatcher("b").forward(req, resp);
    }

    @RequestMapping("b")
    public void b(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("b() redirect c()");
        resp.sendRedirect("c");
    }

    @RequestMapping("c")
    public void c(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().print("success...");
    }

    @RequestMapping("d")
    public String d() {
        System.out.println("使用字符串转页:");
        System.out.println("d() => e()...");
        return "forward:e";
    }

    @RequestMapping("e")
    public String e() {
        System.out.println("e() redirect f()");
        return "redirect:/api/forward/f";
    }

    @RequestMapping("f")
    public ModelAndView f(ModelAndView mav) {
        System.out.println("f()...");
        mav.setViewName("success");
        return mav;
    }

    @ResponseBody
    @RequestMapping("response-body-json")
    public JsonData jackson() {
        List<Student> students = new ArrayList<>();

        Student zhaosi = new Student();
        zhaosi.setSerializableId(1527228403L);
        zhaosi.setId(1);
        zhaosi.setName("赵四");
        zhaosi.setBirthday(new Date(1_111_111_111L));

        Student liuneng = new Student();
        liuneng.setId(2);
        liuneng.setBirthday(new Date(9_999_999_999L));

        students.add(zhaosi);
        students.add(liuneng);
        return new JsonData(students);
    }
}
