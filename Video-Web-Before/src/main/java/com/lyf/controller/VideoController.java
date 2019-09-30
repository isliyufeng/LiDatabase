package com.lyf.controller;

import com.lyf.entity.Course;
import com.lyf.entity.Speaker;
import com.lyf.entity.Video;
import com.lyf.entity.VideoQueryVo;
import com.lyf.service.CourseService;
import com.lyf.service.SpeakerService;
import com.lyf.service.VideoService;
import com.lyf.utils.InfoUtils;
import com.lyf.utils.Page;
import com.lyf.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author 喜闻乐见i
 */
@Controller
@RequestMapping("/video")
@CrossOrigin
public class VideoController {
    @Autowired
    VideoService videoService;
    @Autowired
    SpeakerService speakerService;
    @Autowired
    CourseService courseService;

    @CrossOrigin
    @RequestMapping("/list")
    public String list(VideoQueryVo queryVo, Model model) {
        System.out.println(queryVo);
        queryVo.setBegin((queryVo.getPage() - 1) * queryVo.getRows());
        Page<Video> page = new Page<Video>();
        // 数据数量
        page.setTotal(videoService.selectQueryVoNum(queryVo));
        // 设置展示页数
        page.setPage(queryVo.getPage());
        // 设置每页展示个数
        page.setSize(queryVo.getRows());
        // 填充数据到page中
        List<Video> list = videoService.selectListByQueryVo(queryVo);

        System.out.println(list);

        page.setRows(list);
        model.addAttribute("page", page);

        // 查询讲师数据集合，用途是填充页面中的控件
        List<Speaker> speakers = speakerService.selectAllSpeaker();
        model.addAttribute("speakerList", speakers);

        // 查询课程数据集合，用途是填充页面中的控件
        List<Course> courses = courseService.selectAllCourse();
        model.addAttribute("courseList", courses);

        return "behind/videoList.jsp";
    }

    @RequestMapping("/addVideo")
    public String addVideo(Model model) {
        // 查询讲师数据集合，用途是填充页面中的控件
        List<Speaker> speakers = speakerService.selectAllSpeaker();
        model.addAttribute("speakerList", speakers);

        // 查询课程数据集合，用途是填充页面中的控件
        List<Course> courses = courseService.selectAllCourse();
        model.addAttribute("courseList", courses);
        return "behind/addVideo.jsp";
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public String saveOrUpdate(Video video) {
        System.out.println("保存或修改方法" + video);
        videoService.saveOrUpdate(video);
        return "success";
    }

    @RequestMapping("/videoDel")
    @ResponseBody
    public String videoDel(Integer id) {
        System.out.println("成功删除id为" + id + "的数据！");
        videoService.delById(id);
        return "success";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        System.out.println("要修改的id为：" + id);
        Video video = videoService.selectById(id);
        model.addAttribute("video", video);
        System.out.println(video);
        List<Speaker> speakers = speakerService.selectAllSpeaker();
        model.addAttribute("speakerList", speakers);
        List<Course> courseList = courseService.selectAllCourse();
        model.addAttribute("courseList", courseList);
        return "/behind/addVideo.jsp";
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
        String imgUrl = InfoUtils.getProperties("IMG_URL") + newFileName;
        System.out.println(imgUrl);
        return imgUrl;
    }

    @RequestMapping("/delBatchVideos")
    public String delBatchVideos(Integer[] ids) {
        System.out.println("您要删除的id为：" + Arrays.toString(ids));
        int result = videoService.delBatchVideos(ids);
        return "redirect:/video/list";
    }

    @RequestMapping("/showVideo")
    public String showVideo(Integer videoId, String subjectName, Model model) {
        Video video = videoService.getVideoById(videoId);
        System.out.println(video);
        model.addAttribute("video", video);
        model.addAttribute("subjectName", subjectName);
        Course course = courseService.selectById(video.getCourseId());
        List<Video> videoList = videoService.getVideoListByCourseId(video.getCourseId());
        course.setVideoList(videoList);
        model.addAttribute("course",course);
        return "/before/section.jsp";
    }
}
