package bjtu.edu.javaee.a2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import bjtu.edu.javaee.a2.service.AccessLimitService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private AccessLimitService accessLimitService;

    @RequestMapping(value = { "", "/", "/home" })
    public String index(Model model) {
        model.addAttribute("activePage", "home");
        return "index";
    }


//    public String hello() {
//        return "Hello Spring Boot!";
//    }
//    @ResponseBody
    @RequestMapping("/hello")
    @ResponseBody
    public String access(){
        //尝试获取令牌
        if(accessLimitService.tryAcquire()){
            //模拟业务执行500毫秒
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return "aceess success [" + sdf.format(new Date()) + "]";
        }else{
            return "aceess limit [" + sdf.format(new Date()) + "]";
        }
    }
}
