package com.lyf.controller;

import com.lyf.entity.Speaker;
import com.lyf.entity.SpeakerQueryVo;
import com.lyf.service.SpeakerService;
import com.lyf.utils.InfoUtils;
import com.lyf.utils.Page;
import com.lyf.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author 喜闻乐见i
 */
@Controller
@RequestMapping("/speaker")
public class SpeakerController {
    @Autowired
    SpeakerService speakerService;

    @RequestMapping("/list")
    public String list(SpeakerQueryVo queryVo, Model model) {
        queryVo.setBegin((queryVo.getPage() - 1) * queryVo.getRows());
        Page<Speaker> page = new Page<Speaker>();
        // 数据数量
        page.setTotal(speakerService.selectQueryVoNum(queryVo));
        // 设置展示页数
        page.setPage(queryVo.getPage());
        // 设置每页展示个数
        page.setSize(queryVo.getRows());
        // 填充数据到page中
        List<Speaker> list = speakerService.selectListByQueryVo(queryVo);
        page.setRows(list);
        model.addAttribute("page", page);
        // 查询讲师名字填充控件
        List<Speaker> speakers = speakerService.selectAllSpeaker();
        model.addAttribute("speakerList", speakers);
        return "behind/speakerList.jsp";
    }

    @RequestMapping("/addSpeaker")
    public String addSpeaker() {
        return "/behind/addSpeaker.jsp";
    }


    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public String saveOrUpdate(Speaker speaker) {
        System.out.println("保存或修改方法" + speaker);
        speakerService.saveOrUpdate(speaker);
        return "success";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile headImg) {
        // 获取原上传文件名，截取后缀并生成新文件名
        System.out.println(headImg.getOriginalFilename());
        String originalFilename = headImg.getOriginalFilename();
        System.out.println("originalFilename：" + originalFilename);
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        System.out.println("suffix：" + suffix);
        String newFileName = UUIDUtils.getUUID() + suffix;
        // 上传
        try {
            headImg.transferTo(new File(InfoUtils.getProperties("IMG_PATH"), newFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回显示图片的路径
        String headImgUrl = InfoUtils.getProperties("IMG_URL") + newFileName;
        System.out.println(headImgUrl);
        return headImgUrl;
    }

    @RequestMapping("/speakerDel")
    @ResponseBody
    public String speakerDel(Integer id) {
        speakerService.delById(id);
        return "success";
    }

    @RequestMapping("/delBatchSpeakers")
    public String delBatchSpeaker(Integer[] ids) {
        int result = speakerService.delBatchSpeaker(ids);
        return "redirect:/speaker/list";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        System.out.println("要修改的id为：" + id);
        Speaker speaker = speakerService.selectById(id);
        model.addAttribute("speaker", speaker);
        return "/behind/addSpeaker.jsp";
    }
}
