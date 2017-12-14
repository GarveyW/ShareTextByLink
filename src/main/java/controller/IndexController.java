package controller;

import entity.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.ContentRepository;
import util.Md5Utils;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private ContentRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String startPage() {
        return "index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveContent(@RequestParam String content, ModelMap model) {
        Content userContent = new Content();
        userContent.setContent(content);
        try {
            userContent.setHash(Md5Utils.getMd5(content));
        } catch (NoSuchAlgorithmException e) {
            return "error";
        }
        repository.save(userContent);
        model.addAttribute("userContent", userContent);
        return "save";
    }

    @RequestMapping(value = "/{hash}", method = RequestMethod.GET)
    public String getContent(@PathVariable("hash") String hash, ModelMap model) {
        List<Content> list = repository.findByHash(hash);
        if (list.size() > 0) {
            Content content = list.get(0);
            model.addAttribute("userContent", content);
            repository.delete(content);
            return "content";
        }
        return "error-hash-not-found";
    }
}