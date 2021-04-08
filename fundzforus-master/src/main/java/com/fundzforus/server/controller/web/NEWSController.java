package com.fundzforus.server.controller.web;

import com.fundzforus.server.domain.NewsReader;
import com.fundzforus.server.domain.Tenant;
import com.fundzforus.server.form.LoginForm;
import com.fundzforus.server.form.UserForm;
import com.fundzforus.server.service.INEWSReaderService;
import com.fundzforus.server.util.FileUploadUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@SessionAttributes("user")
public class NEWSController {

    @Autowired
    FileUploadUtil fileUploadUtil;

    @Autowired
    private INEWSReaderService newsReaderServiceImpl;

    @GetMapping("/newsfeed")
    public String getNEWS(Model model, @ModelAttribute("user") UserForm userForm) {
        if (userForm == null || !userForm.isLoggedIn()) {
            model.addAttribute("loginForm", new LoginForm());
            return "login";
        } else {
            List<NewsReader> newsList = newsReaderServiceImpl.findAllNEWS();
            List<NewsReader> tempNewsList = new ArrayList<>(newsList);
            List<List<NewsReader>> newsSubList = Lists.partition(tempNewsList, 2);
            for (List<NewsReader> subList : newsSubList) {
                if (subList.size() == 1) {
                    subList.add(new NewsReader());
                }
            }
            userForm.setNewsReaderList(newsList);
            userForm.setNewsReaderSubList(newsSubList);
            model.addAttribute("userForm", userForm);
            return "news-feed";
        }
    }

    @GetMapping("/newsFeedDetails")
    public String getNEWSFeedDetails(Model model, @ModelAttribute("user") UserForm userForm, @RequestParam("id") int id) {
        if (userForm == null || !userForm.isLoggedIn()) {
            model.addAttribute("loginForm", new LoginForm());
            return "login";
        } else {
            NewsReader newsReader = newsReaderServiceImpl.getNEWSById(id);
            if (newsReader == null) {
                return "news-feed";
            }
            userForm.setNewsReader(newsReader);
            model.addAttribute("userForm", userForm);
            return "news-feed-details";
        }
    }

    @GetMapping("/addNews")
    public String insertNEWS(Model model, @ModelAttribute("user") UserForm userForm) {
        if (userForm == null || !userForm.isLoggedIn()) {
            model.addAttribute("loginForm", new LoginForm());
            return "login";
        } else {
            userForm.setNewsReaderNew(new NewsReader());
            model.addAttribute("userForm", userForm);
            return "add-news";
        }
    }

    @PostMapping("/addNews")
    public String submitNEWS(Model model, @ModelAttribute("user") UserForm userForm,
                             @RequestParam("multiPartImage") MultipartFile multipartFile) {

        NewsReader dbNewsReader = null;

        if (userForm == null || !userForm.isLoggedIn()) {
            model.addAttribute("loginForm", new LoginForm());
            return "login";
        } else {

            NewsReader newsReader = userForm.getNewsReaderNew();

            if (StringUtils.isBlank(newsReader.getTitle()) || StringUtils.isBlank(newsReader.getCategory()) ||
                    StringUtils.isBlank(newsReader.getDescription()) || StringUtils.isBlank(newsReader.getImageURL())) {
                userForm.setMessage("Mandatory Fields are missing");
                userForm.setMessage("Title, Category, Description and Image Fields are missing");
                model.addAttribute("userForm", userForm);
                return "add-news";
            }

            String fileName = org.springframework.util.StringUtils.cleanPath(multipartFile.getOriginalFilename());


            dbNewsReader = newsReaderServiceImpl.getNEWSByTitle(newsReader.getTitle());
            if (dbNewsReader != null) {
                userForm.setMessage("News Title Already Exist");
                model.addAttribute("userForm", userForm);
                return "add-news";
            }
            int rowsInserted = newsReaderServiceImpl.createNews(newsReader);
            if (rowsInserted > 0) {
                dbNewsReader = newsReaderServiceImpl.getNEWSByTitle(newsReader.getTitle());

                String fileUrl = "";
                if (StringUtils.isNotBlank(fileName)) {
                    fileUrl = fileUploadUtil.savePdfs(dbNewsReader.getId(), fileName, multipartFile, "news");
                    newsReader.setId(dbNewsReader.getId());
                    newsReader.setPdfURL(fileUrl);
                    newsReaderServiceImpl.updateNews(newsReader);
                }

                List<NewsReader> newsList = newsReaderServiceImpl.findAllNEWS();
                List<NewsReader> tempNewsList = new ArrayList<>(newsList);
                List<List<NewsReader>> newsSubList = Lists.partition(tempNewsList, 2);
                for (List<NewsReader> subList : newsSubList) {
                    if (subList.size() == 1) {
                        subList.add(new NewsReader());
                    }
                }
                userForm.setNewsReaderList(newsList);
                userForm.setNewsReaderSubList(newsSubList);
                model.addAttribute("userForm", userForm);
                return "news-feed";
            }
        }

        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }


    @ModelAttribute("user")
    public UserForm user() {
        return new UserForm();
    }
}
