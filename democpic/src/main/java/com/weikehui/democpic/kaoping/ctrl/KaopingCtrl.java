package com.weikehui.democpic.kaoping.ctrl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.weikehui.democpic.kaoping.pojo.Message;
import com.weikehui.democpic.kaoping.pojo.Status;
import com.weikehui.democpic.kaoping.service.KaopingService;

@Controller
@RequestMapping("/kp")
public class KaopingCtrl {
	@Autowired
	private KaopingService kaopingService;
	
	@RequestMapping("/kpindex")
	public String kpindex() {
		kaopingService.test();
		return "kaoping/kpindex";
	}
	
	@RequestMapping("/kpimport")
	@ResponseBody
	public void kpimport(Model model) {
		kaopingService.kpimport();
		model.addAttribute("aaa", "asfd");
	}
	
	/**
	 * 导入考评主题列表
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/uploadSubjectFile", method=RequestMethod.POST, produces = "application/json;charset=utf8")
    @ResponseBody
    public Message uploadFileHandler(@RequestParam("subjectfile") MultipartFile file) throws IOException {
		System.out.println("uploadSubjectFile....");
		Message msg = new Message();
        if (!file.isEmpty()) {
            InputStream in = null;
            OutputStream out = null;
            
            try {
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();
                File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
                in = file.getInputStream();                
                out = new FileOutputStream(serverFile);
                byte[] b = new byte[1024];
                int len = 0;
                while ((len = in.read(b)) > 0) {
                    out.write(b, 0, len);
                }
                out.close();
                in.close();
                //读取数据
                msg = kaopingService.readSubjectFile(file);
                if(Status.ERROR.equals(msg.getStatus())){
                	return msg;
                }
                //logger.info("Server File Location=" + serverFile.getAbsolutePath());                
                msg.setStatus(Status.SUCCESS);
                msg.setStatusMsg("File upload success");
                return msg;
            } catch (Exception e) {
                msg.setStatus(Status.ERROR);
                msg.setError("File upload file");
                return msg;
            } finally {
                if (out != null) {
                    out.close();
                    out = null;
                }
                if (in != null) {
                    in.close();
                    in = null;
                }
            }
        } else {
            msg.setStatus(Status.ERROR);
            msg.setError("File is empty");
            return msg;
        }
    }
	
	/**
	 * 导入人员主题关联表
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/uploadRyztFile", method=RequestMethod.POST, produces = "application/json;charset=utf8")
    @ResponseBody
    public Message uploadKpFileHandler(@RequestParam("ryztfile") MultipartFile file) throws IOException {
		System.out.println("uploadRyztFile ....");
		Message msg = new Message();
        if (!file.isEmpty()) {
            InputStream in = null;
            OutputStream out = null;
            
            try {
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();
                File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
                in = file.getInputStream();                
                out = new FileOutputStream(serverFile);
                byte[] b = new byte[1024];
                int len = 0;
                while ((len = in.read(b)) > 0) {
                    out.write(b, 0, len);
                }
                out.close();
                in.close();
                //读取数据
                msg = kaopingService.readFile(file);
                if(Status.ERROR.equals(msg.getStatus())){
                	return msg;
                }
                //logger.info("Server File Location=" + serverFile.getAbsolutePath());                
                msg.setStatus(Status.SUCCESS);
                msg.setStatusMsg("File upload success");
                return msg;
            } catch (Exception e) {
                msg.setStatus(Status.ERROR);
                msg.setError("File upload file");
                return msg;
            } finally {
                if (out != null) {
                    out.close();
                    out = null;
                }
                if (in != null) {
                    in.close();
                    in = null;
                }
            }
        } else {
            msg.setStatus(Status.ERROR);
            msg.setError("File is empty");
            return msg;
        }
    }
	
}
