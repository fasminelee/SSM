package org.lanqiao.controller;

import org.lanqiao.entity.Student;
import org.lanqiao.service.impl.ClassesServiceImpl;
import org.lanqiao.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {


//    @RequestMapping("showStudent")
//    String showStudent(Student student, Model model, HttpSession session) {
//        int sid = student.getSid();
//        if (id != null) {
//            Student stu = new StudentDaoImpl().getWithID(sid);
//            request.setAttribute("stu", stu);
//        }
//        List<Classes> classesList = new ClassesServiceImpl().getAll();
//        request.setAttribute("classesList", classesList);
////        request.getRequestDispatcher("show.jsp").forward(request, response);
//        return "show.jsp";
//    }

    @Autowired
    StudentServiceImpl stus;
    @Autowired
    ClassesServiceImpl clss;

    @RequestMapping("listStudent")
    public String listStudent(Model model) {
        return "listStudent";
    }

    @RequestMapping("showStudent")
    public String showStudent(@RequestParam(defaultValue = "1") String page, Model model) {
        int pageSize = 3;
        int pageNum;
        int maxPage = stus.getMaxPage(pageSize);
        if (!page.equals("") && page != null) {
            pageNum = Integer.parseInt(page);
        } else {
            pageNum = 1;
        }
        model.addAttribute("page", pageNum);
        model.addAttribute("MaxPage", maxPage);
        if (!model.containsAttribute("stuList")) {
            model.addAttribute("stuList", stus.getByPage(pageNum, pageSize));
        }
        return "forward:listStudent";
    }

    @RequestMapping("showStudentItem")
    public String showStudentItem(int id, Model model) {
        model.addAttribute("stu", stus.getById(id));
        model.addAttribute("cls", clss.getAll());
        return "showStudent";
    }

    @RequestMapping("updateStudent")
    public String UpdateStudent(Student stu) {
        if (stu.getSid() == null) {
            stus.add(stu);
        } else {
            stus.update(stu);
        }
        return "redirect: showStudent";
    }

    @RequestMapping("showStuItem")
    public String showStudentItem(Model model) {
        model.addAttribute("cls", clss.getAll());
        return "showStudent";
    }

    @RequestMapping("deleteStudent")
    public @ResponseBody String deleteStudent(int id) {
        int i = stus.deleteById(id);
        if (i == 1) {
            return "ok";
        }
        return "false";
    }
}
