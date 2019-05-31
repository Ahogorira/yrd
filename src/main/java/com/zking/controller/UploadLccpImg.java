package com.zking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
public class UploadLccpImg{
    @RequestMapping(value = "fileUploadPage",method = RequestMethod.POST)
    public String fileUploadPage(@RequestParam("uploadFile")MultipartFile file, HttpServletRequest request){
        //判断文件是否为空
        if(!file.isEmpty()){
            //文件存放路径
            String path = request.getServletContext().getRealPath("/images/");
            //文件名称
            String name = String.valueOf(new Date().getTime()+"_"+file.getOriginalFilename());
            File destFile = new File(path,name);
            try {
                //转存文件
                file.transferTo(destFile);
                request.setAttribute("url",name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "success.jsp";
    }


}
